package GUIComponents2.BoxLayout;
// Demonstrating BoxLayout.
import javax.swing.JFrame;

public class BoxLayoutDemo
{
   public static void main( String[] args )
   { 
      BoxLayoutFrame boxLayoutFrame = new BoxLayoutFrame();  
      boxLayoutFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      boxLayoutFrame.setSize( 400, 220 ); // set frame size
      boxLayoutFrame.setVisible( true ); // display frame
   } // end main
} // end class BoxLayoutDemo