package GraphicsAndJava2D.LinesRectsOvals;
// Drawing lines, rectangles and ovals.
import java.awt.Color;
import javax.swing.JFrame;

public class LinesRectsOvals
{
   // execute application
   public static void main( String[] args )
   {
      // create frame for LinesRectsOvalsJPanel
      JFrame frame = new JFrame( "Drawing lines, rectangles and ovals" );
      frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
   
      LinesRectsOvalsJPanel linesRectsOvalsJPanel = new LinesRectsOvalsJPanel();
      linesRectsOvalsJPanel.setBackground( Color.WHITE ); 
      frame.add( linesRectsOvalsJPanel ); // add panel to frame
      frame.setSize( 400, 210 ); // set frame size
      frame.setVisible( true ); // display frame
   } // end main
} // end class LinesRectsOvals