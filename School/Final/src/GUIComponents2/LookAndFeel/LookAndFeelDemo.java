package GUIComponents2.LookAndFeel;
// Changing the look-and-feel.
import javax.swing.JFrame;

public class LookAndFeelDemo 
{
   public static void main( String[] args )
   { 
      LookAndFeelFrame lookAndFeelFrame = new LookAndFeelFrame();  
      lookAndFeelFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      lookAndFeelFrame.setSize( 400, 220 ); // set frame size
      lookAndFeelFrame.setVisible( true ); // display frame
   } // end main
} // end class LookAndFeelDemo