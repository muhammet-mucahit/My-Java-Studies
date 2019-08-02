package GUIComponents1.BorderLayout;
// Testing BorderLayoutFrame.
import javax.swing.JFrame;

public class BorderLayoutDemo 
{
   public static void main( String[] args )
   { 
      BorderLayoutFrame borderLayoutFrame = new BorderLayoutFrame(); 
      borderLayoutFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      borderLayoutFrame.setSize( 300, 200 ); // set frame size
      borderLayoutFrame.setVisible( true ); // display frame
   } // end main
} // end class BorderLayoutDemo