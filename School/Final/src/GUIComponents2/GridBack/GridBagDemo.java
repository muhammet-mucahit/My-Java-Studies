package GUIComponents2.GridBack;
// Demonstrating GridBagLayout.
import javax.swing.JFrame;

public class GridBagDemo
{ 
   public static void main( String[] args )
   { 
      GridBagFrame gridBagFrame = new GridBagFrame(); 
      gridBagFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      gridBagFrame.setSize( 300, 150 ); // set frame size
      gridBagFrame.setVisible( true ); // display frame
   } // end main
} // end class GridBagDemo