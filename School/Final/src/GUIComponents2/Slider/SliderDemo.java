package GUIComponents2.Slider;
// Testing SliderFrame.
import javax.swing.JFrame;

public class SliderDemo 
{
   public static void main( String[] args )
   { 
      SliderFrame sliderFrame = new SliderFrame(); 
      sliderFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      sliderFrame.setSize( 220, 270 ); // set frame size
      sliderFrame.setVisible( true ); // display frame
   } // end main
} // end class SliderDemo