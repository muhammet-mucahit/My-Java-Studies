import org.w3c.dom.CharacterData;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import java.io.*;
import javax.xml.soap.*;

public class SOAPClient {
    String SOAP_ENDPOINT;
    String SOAP_ACTION;
    String TARGET_NAMESPACE;
    String OPERATION_NAME;
    String PARAMETER_NAME;
    String PARAMETER_VALUE;

    public static String getCharacterDataFromElement(Element e) {
        Node child = e.getFirstChild();
        if (child instanceof CharacterData) {
            CharacterData cd = (CharacterData) child;
            return cd.getData();
        }
        return "?";
    }

    public SOAPClient(String endpoint, String namespace, String operation, String parameter, String value) {
        SOAP_ENDPOINT = endpoint;
        SOAP_ACTION = namespace + operation;
        TARGET_NAMESPACE = namespace;
        OPERATION_NAME = operation;
        PARAMETER_NAME = parameter;
        PARAMETER_VALUE = value;
    }

    public String callSoapWebService() {
        try {
            // Create SOAP Connection
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

            // Send SOAP Message to SOAP Server
            SOAPMessage soapResponse = soapConnection.call(createSOAPRequest(), SOAP_ENDPOINT);

            // Print the SOAP Response
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            soapResponse.writeTo(stream);

            soapConnection.close();
            return new String(stream.toByteArray());

        } catch (Exception e) {
            System.err.println("\nError occurred while sending SOAP Request to Server: " + e.getMessage());
            e.printStackTrace();
        }

        return " ";
    }

    public SOAPMessage createSOAPRequest() throws Exception {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();

        createSoapEnvelope(soapMessage);

        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", SOAP_ACTION);

        soapMessage.saveChanges();

        /* Print the request message, just for debugging purposes */
        System.out.println("Request SOAP Message:");
        soapMessage.writeTo(System.out);
        System.out.println("\n");

        return soapMessage;
    }

    public void createSoapEnvelope(SOAPMessage soapMessage) throws SOAPException {
        String namespace = "namespace";
        SOAPPart soapPart = soapMessage.getSOAPPart();

        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration(namespace, TARGET_NAMESPACE);

        // SOAP Body
        SOAPBody soapBody = envelope.getBody();
        SOAPElement soapBodyElem = soapBody.addChildElement(OPERATION_NAME, namespace);
        SOAPElement soapBodyElem1 = soapBodyElem.addChildElement(PARAMETER_NAME, namespace);
        soapBodyElem1.addTextNode(PARAMETER_VALUE);
    }
}