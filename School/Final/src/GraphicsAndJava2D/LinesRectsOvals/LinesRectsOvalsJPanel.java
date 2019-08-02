package GraphicsAndJava2D.LinesRectsOvals;
// Drawing lines, rectangles and ovals.
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class LinesRectsOvalsJPanel extends JPanel 
{
   // display various lines, rectangles and ovals
   public void paintComponent( Graphics g )
   {
      super.paintComponent( g ); // call superclass's paint method

      this.setBackground( Color.WHITE );

      g.setColor( Color.RED );
      g.drawLine( 5, 30, 380, 30 );

      g.setColor( Color.BLUE );
      g.drawRect( 5, 40, 90, 55 );
      g.fillRect( 100, 40, 90, 55 );

      g.setColor( Color.BLACK );
      g.fillRoundRect( 195, 40, 90, 55, 50, 50 );
      g.drawRoundRect( 290, 40, 90, 55, 20, 20 );

      g.setColor( Color.GREEN );   
      g.draw3DRect( 5, 100, 90, 55, true );
      g.fill3DRect( 100, 100, 90, 55, false );

      g.setColor( Color.MAGENTA );
      g.drawOval( 195, 100, 90, 55 );
      g.fillOval( 290, 100, 90, 55 );
   } // end method paintComponent
} // end class LinesRectsOvalsJPanel