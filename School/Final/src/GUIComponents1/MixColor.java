package GUIComponents1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class MixColor extends JFrame {
    ColorPanel colorPanel;
    boolean start = true;
    int x, y, r;

    public static void main(String args[]) {
        MixColor mixColor = new MixColor();
        mixColor.setDefaultCloseOperation(EXIT_ON_CLOSE);
        mixColor.setSize(600, 400);
        mixColor.setVisible(true);
    }

    public MixColor() {
        setTitle("Mouse Events");
        colorPanel = new ColorPanel();
        colorPanel.setBackground(Color.black);
        colorPanel.addMouseListener(
                new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        x = e.getX();
                        y = e.getY();
                        r = 0;
                        colorPanel.setColor();
                        start = true;
                        (new Thread() {
                            public void run() {
                                while (start) {
                                    r += 2;
                                    try {
                                        Thread.sleep(30);
                                        colorPanel.drawOval(x, y, r);
                                    }
                                    catch (InterruptedException ex) { }
                                }
                            }
                        }).start();
                    }
                    public void mouseReleased(MouseEvent e) {
                        start = false;
                    }
                });

        add(colorPanel, BorderLayout.CENTER);

    }
}

//sliderRed.addChangeListener(
//        new ChangeListener() {
//public void stateChanged(ChangeEvent e) {
//        colorPanel.setRed(sliderRed.getValue());
//        colorPanel.drawColor();
//        }
//        });

class ColorPanel extends JPanel {
    int red = 0, green = 0, blue = 0;
    int x = 0, y = 0, r = 0;
    Color c;

    public void paintComponent(Graphics g) {
        //super.paintComponent(g);
        //this.setBackground(new Color(red, green, blue));
        if (x+y > 0) {
            g.setColor(c);
            g.fillOval(x-r, y-r, 2*r, 2*r);
        }
    }

    public void setRed(int r) {
        red = r;
    }

    public void setGreen(int g) {
        green = g;
    }

    public void setBlue(int b) {
        blue = b;
    }

    public void drawColor() {
        repaint();
    }

    public void drawOval(int x, int y, int r) {
        this.x = x;
        this.y = y;
        this.r = r;
        repaint();
    }

    public void setColor() {
        c = new Color((int)(Math.random()*256), (int)(Math.random()*256), (int)(Math.random()*256));
    }
}
