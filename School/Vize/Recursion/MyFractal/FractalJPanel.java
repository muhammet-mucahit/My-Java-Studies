package Recursion.MyFractal;
// Drawing the "Lo fractal" using recursion.
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

public class FractalJPanel extends JPanel
{
   private Color color; // stores color used to draw fractal
   private int level;   // stores current level of fractal

   private static final int WIDTH = 400;  // defines width of JPanel
   private static final int HEIGHT = 400; // defines height of JPanel

   // set the initial fractal level to the value specified
   // and set up JPanel specifications
   public FractalJPanel( int currentLevel )
   {
      color = Color.BLUE;  // initialize drawing color to blue
      level = currentLevel; // set initial fractal level
      setBackground( Color.WHITE );
      setPreferredSize( new Dimension( WIDTH, HEIGHT ) );
   } // end constructor FractalJPanel

   // draw fractal recursively
   public void drawFractal( int level, int xA, int yA, int xB, 
      int yB, int angle, Graphics g )
   {
      // base case: draw a line connecting two given points
      if ( level == 0 ) 
         g.drawLine( xA, yA, xB, yB );
      else // recursion step: determine new points, draw next level
      {	
      	 double h = Math.sqrt((xB-xA)*(xB-xA)+(yB-yA)*(yB-yA));
      	 
      	 int x1 = xA + (int)(h/3*Math.cos(Math.PI*angle/180));
      	 int y1 = yA - (int)(h/3*Math.sin(Math.PI*angle/180));
      	 int x2 = x1 + (int)(h/3*Math.cos(Math.PI*(angle+60)/180));
      	 int y2 = y1 - (int)(h/3*Math.sin(Math.PI*(angle+60)/180));
      	 int x3 = xA + (int)(2*h/3*Math.cos(Math.PI*angle/180));
      	 int y3 = yA - (int)(2*h/3*Math.sin(Math.PI*angle/180));
      	 
      	 drawFractal(level-1, xA, yA, x1, y1, angle, g);
      	 drawFractal(level-1, x1, y1, x2, y2, angle+60, g);
      	 drawFractal(level-1, x2, y2, x3, y3, angle-60, g);
      	 drawFractal(level-1, x3, y3, xB, yB, angle, g);
      } // end else
   } // end method drawFractal
   
   public void drawFractal2( int level, int xA, int yA, int xB, 
      int yB, Graphics g )
   {
      // base case: draw a line connecting two given points
      if ( level == 0 ) 
         g.drawLine( xA, yA, xB, yB );
      else // recursion step: determine new points, draw next level
      {	
         // calculate midpoint between (xA, yA) and (xB, yB)
         int xC = ( xA + xB ) / 2;
         int yC = ( yA + yB ) / 2;

         // calculate the fourth point (xD, yD) which forms an 
         // isosceles right triangle between (xA, yA) and (xC, yC) 
         // where the right angle is at (xD, yD)
         int xD = xA + ( xC - xA ) / 2 - ( yC - yA ) / 2;
         int yD = yA + ( yC - yA ) / 2 + ( xC - xA ) / 2;
         
         // recursively draw the Fractal
         drawFractal2( level - 1, xD, yD, xA, yA, g );
         drawFractal2( level - 1, xD, yD, xC, yC, g );
         drawFractal2( level - 1, xD, yD, xB, yB, g );  
      } // end else
   } // end method drawFractal

   // start the drawing of fractal
   public void paintComponent( Graphics g )
   {
      super.paintComponent( g );

      // draw fractal pattern
      g.setColor( color );
      //drawFractal2( level, 100, 90, 290, 200, g );
      drawFractal( level, 50, 150, 350, 150, 0, g ); 
   } // end method paintComponent

   // set the drawing color to c
   public void setColor( Color c )
   {
      color = c;
   } // end method setColor
    
   // set the new level of recursion
   public void setLevel( int currentLevel )
   {
      level = currentLevel;
   } // end method setLevel

   // returns level of recursion 
   public int getLevel()
   {
      return level;
   } // end method getLevel
} // end class FractalJPanel
