package GUIComponents2.Slider;
// Using JSliders to size an oval.
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class SliderFrame extends JFrame 
{
   private JSlider diameterJSlider; // slider to select diameter
   private OvalPanel myPanel; // panel to draw circle

   // no-argument constructor
   public SliderFrame() 
   {
      super( "Slider Demo" );

      myPanel = new OvalPanel(); // create panel to draw circle
      myPanel.setBackground( Color.YELLOW ); // set background to yellow

      // set up JSlider to control diameter value
      diameterJSlider = new JSlider( SwingConstants.HORIZONTAL, 0, 200, 10 );
      diameterJSlider.setMajorTickSpacing( 10 ); // create tick every 10
      diameterJSlider.setPaintTicks( true ); // paint ticks on slider

      // register JSlider event listener
      diameterJSlider.addChangeListener(

         new ChangeListener() // anonymous inner class
         {  
            // handle change in slider value
            public void stateChanged( ChangeEvent e )
            {
               myPanel.setDiameter( diameterJSlider.getValue() );
            } // end method stateChanged
         } // end anonymous inner class
      ); // end call to addChangeListener

      add( diameterJSlider, BorderLayout.SOUTH ); // add slider to frame
      add( myPanel, BorderLayout.CENTER ); // add panel to frame
   } // end SliderFrame constructor
} // end class SliderFrame