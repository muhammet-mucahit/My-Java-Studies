package GUIComponents2.PopupMenu;
// Testing PopupFrame.
import javax.swing.JFrame;

public class PopupTest 
{
   public static void main( String[] args )
   { 
      PopupFrame popupFrame = new PopupFrame(); // create PopupFrame 
      popupFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      popupFrame.setSize( 300, 200 ); // set frame size
      popupFrame.setVisible( true ); // display frame
   } // end main
} // end class PopupTest