package FilesAndStreams.BigExample;
// Testing the ReadTextFile class.

public class ReadTextFileTest
{
   public static void main( String[] args )
   {
      ReadTextFile application = new ReadTextFile();

      application.openFile();
      application.readRecords();
      application.closeFile();
   } // end main
} // end class ReadTextFileTest