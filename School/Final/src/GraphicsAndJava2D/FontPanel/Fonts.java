package GraphicsAndJava2D.FontPanel;
// Using fonts.
import javax.swing.JFrame;

public class Fonts 
{
   // execute application
   public static void main( String[] args )
   {
      // create frame for FontJPanel
      JFrame frame = new JFrame( "Using fonts" );
      frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

      FontJPanel fontJPanel = new FontJPanel(); // create FontJPanel
      frame.add( fontJPanel ); // add fontJPanel to frame
      frame.setSize( 420, 150 ); // set frame size
      frame.setVisible( true ); // display frame
   } // end main
} // end class Fonts