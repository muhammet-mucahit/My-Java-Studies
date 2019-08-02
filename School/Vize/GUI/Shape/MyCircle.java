package GUI.Shape;

import javax.swing.*;
import java.awt.*;

public class MyCircle extends JPanel {

    private int numberOfCircle;

    public MyCircle(int numOfCircle) {
        numberOfCircle = numOfCircle;
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponents(g);

        for (int i = 0; i < numberOfCircle; i++) {
            g.setColor(Color.ORANGE);
            g.drawOval(40 + i * 5,25 + i * 5,200 - i * 10,200 - i * 10);
        }
    }
}
