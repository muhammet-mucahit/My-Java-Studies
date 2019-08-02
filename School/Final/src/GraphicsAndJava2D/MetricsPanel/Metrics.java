package GraphicsAndJava2D.MetricsPanel;
// Displaying font metrics.
import javax.swing.JFrame;

public class Metrics 
{
   // execute application
   public static void main( String[] args )
   {
      // create frame for MetricsJPanel
      JFrame frame = new JFrame( "Demonstrating FontMetrics" );
      frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

      MetricsJPanel metricsJPanel = new MetricsJPanel(); 
      frame.add( metricsJPanel ); // add metricsJPanel to frame
      frame.setSize( 510, 240 ); // set frame size
      frame.setVisible( true ); // display frame
   } // end main
} // end class Metrics
