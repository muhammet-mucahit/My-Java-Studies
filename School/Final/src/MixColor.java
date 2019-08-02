//import javax.swing.*;
//import javax.swing.event.ChangeEvent;
//import javax.swing.event.ChangeListener;
//import java.awt.*;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//
//public class MixColor extends JFrame {
//    JSlider redSlider, greenSlider, blueSlider;
//    JLabel redLabel, greenLabel, blueLabel;
//    JPanel colorPanel, sliders, labels;
//
//    boolean start = true;
//    int x, y, r;
//
//    public static void main(String args[]) {
//        MixColor mixColor = new MixColor();
//        mixColor.setDefaultCloseOperation(EXIT_ON_CLOSE);
//        mixColor.setSize(600, 400);
//        mixColor.setVisible(true);
//    }
//
//    public MixColor() {
//        setTitle("Mouse Events");
//        colorPanel = new JPanel();
//        colorPanel.setBackground(Color.BLACK);
//
//        colorPanel.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mousePressed(MouseEvent e) {
//                x = e.getX();
//                y = e.getY();
//                r = 0;
////                colorPanel.set
//                start = true;
//                (new Thread(){
//                    public void run() {
//                        while (start) {
//                            r += 2;
//                            try {
//                                Thread.sleep(30);
//
//                                colorPanel.drawOval(x, y, r);
//                            } catch (InterruptedException e1) {
//                                e1.printStackTrace();
//                            }
//                        }
//                    }
//                }).start();
//            }
//
//            @Override
//            public void mouseReleased(MouseEvent e) {
//                start = false;
//            }
//        });
//
//        redSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
//        greenSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
//        blueSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
//
//        redLabel = new JLabel("Red = 0");
//        greenLabel = new JLabel("Green = 0");
//        blueLabel = new JLabel("Blue = 0");
//
//        Container pane = this.getContentPane();
//        pane.setLayout(new BorderLayout());
//
//        JPanel panel = new JPanel();
//        panel.setLayout(new GridLayout(3,2));
//
//        panel.add(redLabel);
//        panel.add(redSlider);
//        panel.add(greenLabel);
//        panel.add(greenSlider);
//        panel.add(blueLabel);
//        panel.add(blueSlider);
//
//        pane.add(colorPanel, BorderLayout.CENTER);
//        pane.add(ovalPanel, BorderLayout.CENTER);
//        pane.add(panel, BorderLayout.SOUTH);
//
//        event event = new event();
//        redSlider.addChangeListener(event);
//        greenSlider.addChangeListener(event);
//        blueSlider.addChangeListener(event);
//    }
//
//    public class event implements ChangeListener {
//
//        @Override
//        public void stateChanged(ChangeEvent e) {
//            int r = redSlider.getValue();
//            int g = greenSlider.getValue();
//            int b = blueSlider.getValue();
//
//            redLabel.setText("Red = " + r);
//            greenLabel.setText("Green = " + g);
//            blueLabel.setText("Blue = " + b);
//
//            colorPanel.setBackground(new Color(r, g, b));
//        }
//    }
//}
//
//class OvalPanel extends JPanel {
//    int red = 0, green = 0, blue = 0;
//    int x = 0, y = 0, r = 0;
//    Color c;
//
//    public void paintComponent(Graphics g) {
//        if (x+y > 0) {
//            g.setColor(c);
//            g.fillOval(x-r, y-r, 2*r, 2*r);
//        }
//    }
//
//    public void setRed(int r) {
//        red = r;
//    }
//
//    public void setGreen(int g) {
//        green = g;
//    }
//
//    public void setBlue(int b) {
//        blue = b;
//    }
//
//    public void drawColor() {
//        repaint();
//    }
//
//    public void drawOval(int x, int y, int r) {
//        this.x = x;
//        this.y = y;
//        this.r = r;
//        repaint();
//    }
//
//    public void setColor() {
//        c = new Color((int)(Math.random()*256), (int)(Math.random()*256), (int)(Math.random()*256));
//    }
//}
