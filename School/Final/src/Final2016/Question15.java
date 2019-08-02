package Final2016;

import javax.swing.*;
import java.util.List;

public class Question15 extends JFrame {

    static int width = 300;
    static int height = 300;
    static JButton button;
    JPanel panel;

    public Question15() {
        panel = new JPanel();
        button = new JButton("Move");
        button.setBounds(0, 0, 75, 25);
        panel.setLayout(null);
        panel.add(button);
        add(panel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(width, height);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Question15();
        Move move = new Move(button, width, height);
        move.execute();
    }
}

class Move extends SwingWorker<Void,Integer> {
    JButton btn;
    int x, y, a, b, w, h;

    public Move(JButton btn, int w, int h) {
        this.btn = btn;
        x = y = 0;
        a = btn.getWidth(); //Butonun genişliği
        b = btn.getHeight(); //Butonun yüksekliği
        this.w = w; //Formun genişliği
        this.h = h; //Formun yüksekliği
    }

    public Void doInBackground() {
        do {
            try {
                Thread.sleep(2);
                //....................
//                x += 1;
//                y += b * (x / (w - a));
//                x %= (w - a);
//                y %= (h - 2 * b);
                x += 1;
                if (x == (w - a - 10)) {
                    y += b;
                    x = 0;
                }
                if (y == (h - b))
                    y = 0;
                System.out.println(x + " " + y);
                publish(x);
                //....................
            }
            catch (InterruptedException ex) { }
        } while (x != 0 || y != 0);
        return null;
    }

    protected void process(List<Integer> p) {
        for (int i = 0; i < p.size(); i++)
            btn.setBounds(p.get(i), y, a, b);
    }
}
