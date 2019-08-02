import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.StringReader;
import java.text.DecimalFormat;

public class Window extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private String[] columnNamesOfTable;
    private String[][] datasOfTable;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Window window = new Window();
                    window.setVisible(true);
                    window.setResizable(false);
                    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
                    window.setLocation(dim.width / 2 - window.getSize().width / 2, dim.height / 2 - window.getSize().height / 2);
                    ImageIcon icon = new ImageIcon("src/icon.png");
                    window.setIconImage(icon.getImage());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Window() {
        setTitle("CollectionService");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 750, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(25, 25, 700, 343);
        contentPane.add(scrollPane);

        JPanel jPanel = new JPanel();
        jPanel.setBounds(25, 390, 700, 150);
        contentPane.add(jPanel);

        JLabel label = new JLabel("Please enter the Reference Number: ");
        jPanel.add(label);
        JTextField text = new JTextField(10);
        jPanel.add(text);
        JButton loanButton = new JButton("Query Loan");
        JButton collectionButton = new JButton("Query Collection");
        jPanel.add(loanButton);
        jPanel.add(collectionButton);

        collectionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (text.getText().isEmpty() || text.getText().length() != 11) {
                    JOptionPane.showMessageDialog(contentPane, "Please enter a valid ReferansNo");
                    return;
                }

                table = new JTable();
                scrollPane.setViewportView(table);

                columnNamesOfTable = new String[5];

                columnNamesOfTable[0] = "TahsilatReferansNo";
                columnNamesOfTable[1] = "BorcTur";
                columnNamesOfTable[2] = "IslemTarih";
                columnNamesOfTable[3] = "BankaReferansNo";
                columnNamesOfTable[4] = "Tutar";

                String endpoint = "http://81.214.73.178/TahsilatService/TahsilatService.asmx";
                String namespace = "http://tempuri.org/";
                String operation = "TahsilatSorgu";
                String parameter = "referansNo";
                String value = text.getText();

                SOAPClient client = new SOAPClient(endpoint, namespace, operation, parameter, value);
                String xmlData = client.callSoapWebService();

                try {
                    DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
                    InputSource inputSource = new InputSource();
                    inputSource.setCharacterStream(new StringReader(xmlData));

                    Document document = documentBuilder.parse(inputSource);

                    NodeList nodes = document.getElementsByTagName("TahsilatDetay");

                    datasOfTable = new String[nodes.getLength()][5];

                    int i = 1, j = 0;
                    Double toplamTutar = 0.0;
                    for (; i < nodes.getLength(); i++) {
                        Element element = (Element) nodes.item(i);
                        j = 0;

                        NodeList tahsilatReferansNo = element.getElementsByTagName("TahsilatReferansNo");
                        Element line = (Element) tahsilatReferansNo.item(0);
                        datasOfTable[i - 1][j] = SOAPClient.getCharacterDataFromElement(line);
                        j++;

                        NodeList borcTur = element.getElementsByTagName("BorcTur");
                        line = (Element) borcTur.item(0);
                        datasOfTable[i - 1][j] = SOAPClient.getCharacterDataFromElement(line);
                        j++;

                        NodeList islemTarih = element.getElementsByTagName("IslemTarih");
                        line = (Element) islemTarih.item(0);
                        datasOfTable[i - 1][j] = SOAPClient.getCharacterDataFromElement(line);
                        j++;

                        NodeList bankaReferansNo = element.getElementsByTagName("BankaReferansNo");
                        line = (Element) bankaReferansNo.item(0);
                        datasOfTable[i - 1][j] = SOAPClient.getCharacterDataFromElement(line);
                        j++;

                        NodeList tutar = element.getElementsByTagName("Tutar");
                        line = (Element) tutar.item(0);
                        datasOfTable[i - 1][j] = SOAPClient.getCharacterDataFromElement(line);

                        toplamTutar += Double.parseDouble(datasOfTable[i - 1][j]);
                    }

                    datasOfTable[i - 1][j] = new DecimalFormat("##.##").format(toplamTutar);
                    datasOfTable[i - 1][0] = "Toplam";
                } catch (Exception exception) {
                    exception.printStackTrace();
                }

                //Dizileri model kısmına aktarıyoruz.
                TableModel tablemodel = new DefaultTableModel(datasOfTable, columnNamesOfTable);

                //Modelide Table aktarıyoruz.
                table.setModel(tablemodel);
            }
        });

        loanButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){

                if (text.getText().isEmpty() || text.getText().length() != 11) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid ReferansNo");
                    return;
                }

                table = new JTable();
                scrollPane.setViewportView(table);

                columnNamesOfTable = new String[8];

                columnNamesOfTable[0] = "BorcReferansNo";
                columnNamesOfTable[1] = "GelirID";
                columnNamesOfTable[2] = "BorcTur";
                columnNamesOfTable[3] = "DonemTaksit";
                columnNamesOfTable[4] = "SonOdemeTarih";
                columnNamesOfTable[5] = "Tutar";
                columnNamesOfTable[6] = "Gecikme";
                columnNamesOfTable[7] = "Toplam";

                String endpoint = "http://81.214.73.178/TahsilatService/TahsilatService.asmx";
                String namespace = "http://tempuri.org/";
                String operation = "BorcSorgu";
                String parameter = "referansNo";
                String value = text.getText();

                SOAPClient client = new SOAPClient(endpoint, namespace, operation, parameter, value);
                String xmlData = client.callSoapWebService();

                try {
                    DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
                    InputSource inputSource = new InputSource();
                    inputSource.setCharacterStream(new StringReader(xmlData));

                    Document document = documentBuilder.parse(inputSource);
                    NodeList nodes = document.getElementsByTagName("BorcDetay");

                    datasOfTable = new String[nodes.getLength() - 1][8];

                    // iterate the nodes
                    int i = 1, j = 0;
                    Double toplamBorc = 0.0;
                    for (; i < nodes.getLength() - 1; i++) {
                        Element element = (Element) nodes.item(i);
                        j = 0;

                        NodeList borcReferansNo = element.getElementsByTagName("BorcReferansNo");
                        Element line = (Element) borcReferansNo.item(0);
                        datasOfTable[i - 1][j] = SOAPClient.getCharacterDataFromElement(line);
                        j++;

                        NodeList gelirID = element.getElementsByTagName("GelirID");
                        line = (Element) gelirID.item(0);
                        datasOfTable[i - 1][j] = SOAPClient.getCharacterDataFromElement(line);
                        j++;

                        NodeList borcTur = element.getElementsByTagName("BorcTur");
                        line = (Element) borcTur.item(0);
                        datasOfTable[i - 1][j] = SOAPClient.getCharacterDataFromElement(line);
                        j++;

                        NodeList donemTaksit = element.getElementsByTagName("DonemTaksit");
                        line = (Element) donemTaksit.item(0);
                        datasOfTable[i - 1][j] = SOAPClient.getCharacterDataFromElement(line);
                        j++;

                        NodeList sonOdemeTarih = element.getElementsByTagName("SonOdemeTarih");
                        line = (Element) sonOdemeTarih.item(0);
                        datasOfTable[i - 1][j] = SOAPClient.getCharacterDataFromElement(line);
                        j++;

                        NodeList tutar = element.getElementsByTagName("Tutar");
                        line = (Element) tutar.item(0);
                        datasOfTable[i - 1][j] = SOAPClient.getCharacterDataFromElement(line);
                        j++;

                        NodeList gecikme = element.getElementsByTagName("Gecikme");
                        line = (Element) gecikme.item(0);
                        datasOfTable[i - 1][j] = SOAPClient.getCharacterDataFromElement(line);
                        j++;

                        NodeList toplam = element.getElementsByTagName("Toplam");
                        line = (Element) toplam.item(0);
                        datasOfTable[i - 1][j] = SOAPClient.getCharacterDataFromElement(line);

                        toplamBorc += Double.parseDouble(datasOfTable[i - 1][j]);
                    }

                    datasOfTable[i - 1][j] = new DecimalFormat("##.##").format(toplamBorc);
                    datasOfTable[i - 1][0] = "Toplam";
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }

                //Dizileri model kısmına aktarıyoruz.
                TableModel tablemodel = new DefaultTableModel(datasOfTable, columnNamesOfTable);

                //Modelide Table aktarıyoruz.
                table.setModel(tablemodel);
            }
        });
    }
}