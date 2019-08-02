import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Box extends JLabel {

    public int mWidth = 20;
    public int mDirection = DIRECTION.RIGHT;

    Box() {
        setBounds(100, 100, mWidth, mWidth);
    }

    @Override
    public void paint(Graphics g) {

        Graphics2D g2 = (Graphics2D)g;
        Rectangle2D rect = new Rectangle2D.Double(1, 1, getWidth() - 2, getHeight() - 2);
        g2.setColor(Color.black);
        g2.setStroke(new BasicStroke(2));
        g2.draw(rect);
        g2.setColor(Color.green);
        g2.fill(rect);
    }

    public void goLeft() {
        int posX = getX();
        int posY = getY();

        posX -= mWidth;
        setBounds(posX, posY, mWidth, mWidth);
    }

    public void goRight() {
        int posX = getX();
        int posY = getY();

        posX += mWidth;
        setBounds(posX, posY, mWidth, mWidth);
    }

    public void goUp() {
        int posX = getX();
        int posY = getY();

        posY -= mWidth;
        setBounds(posX, posY, mWidth, mWidth);
    }

    public void goDown() {
        int posX = getX();
        int posY = getY();

        posY += mWidth;
        setBounds(posX, posY, mWidth, mWidth);
    }

    public Box createBox() {
        Box box = new Box();

        int x = getX();
        int y = getY();

        box.setBounds(x, y, mWidth, mWidth);

        box.mDirection = -mDirection;
        box.action();
        box.mDirection = mDirection;

        return box;
    }

    public void action() {
        if (mDirection == DIRECTION.LEFT)
            goLeft();
        else if (mDirection == DIRECTION.RIGHT)
            goRight();
        else if (mDirection == DIRECTION.DOWN)
            goDown();
        else
            goUp();
    }
}
