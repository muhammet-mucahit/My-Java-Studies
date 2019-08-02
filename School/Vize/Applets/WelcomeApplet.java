package Applets;

import java.awt.Graphics;   // program uses class Graphics
import javax.swing.JApplet; // program uses class JApplet

public class WelcomeApplet extends JApplet {

   // draw text on applet's background
   public void paint( Graphics g ) {

      // call superclass version of method paint
      super.paint( g );

      // draw a String at x-coordinate 25 and y-coordinate 25
      g.drawString( "Welcome to Java Programming!", 25, 25 );
   } // end method paint
} // end class Applets.WelcomeApplet
