package Final2016;

import javax.swing.*;
import java.awt.*;


public class Question14 extends JFrame {

    public Question14() {

        JPanel panel = new JPanel();
        panel.add(new JButton("One"));
        panel.add(new JButton("Two"));

        JPanel panel2 = new JPanel();
        panel2.add(new JButton("Three"));

        JPanel panel3 = new JPanel();
        panel3.add(new JButton("Four"));
        panel3.add(new JButton("Five"));

        add(panel, BorderLayout.NORTH);
        add(panel2, BorderLayout.CENTER);
        add(panel3, BorderLayout.SOUTH);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300,150);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Question14();
    }
}
