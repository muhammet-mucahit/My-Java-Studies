package FilesAndStreams.ObjectSerialization;
// Testing class CreateSequentialFile.

public class CreateSequentialFileTest
{
   public static void main( String[] args )
   {
      CreateSequentialFile application = new CreateSequentialFile();

      application.openFile();
      application.addRecords();
      application.closeFile();
   } // end main
} // end class CreateSequentialFileTest