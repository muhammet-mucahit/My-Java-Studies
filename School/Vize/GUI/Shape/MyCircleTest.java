package GUI.Shape;

import javax.swing.*;

public class MyCircleTest {
    public static void main(String[] args) {

        MyCircle circle = new MyCircle(30);
        JFrame application = new JFrame();

        application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        application.add( circle ); // add the panel to the frame
        application.setSize( 300, 300 ); // set the desired size
        application.setVisible( true ); // show the frame
    }
}
