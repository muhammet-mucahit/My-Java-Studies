package GUIComponents2.Desktop;
// Demonstrating JDesktopPane.
import javax.swing.JFrame;

public class DesktopTest 
{
   public static void main( String[] args )
   { 
      DesktopFrame desktopFrame = new DesktopFrame();  
      desktopFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      desktopFrame.setSize( 600, 480 ); // set frame size
      desktopFrame.setVisible( true ); // display frame
   } // end main
} // end class DesktopTest
