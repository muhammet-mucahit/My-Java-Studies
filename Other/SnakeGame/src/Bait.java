import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Bait extends JLabel {

    public int mWidth = 20;

    Bait() {
        setPosition(20, 20);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D)g;
        Ellipse2D ellipse = new Ellipse2D.Double(0, 0, mWidth, mWidth);
        g2.setColor(Color.black);
        g2.setStroke(new BasicStroke(2));
        g2.draw(ellipse);
        g2.setColor(Color.yellow);
        g2.fill(ellipse);
    }

    public void setPosition(int posX, int posY) {
        setBounds(posX, posY, mWidth, mWidth);
    }
}
