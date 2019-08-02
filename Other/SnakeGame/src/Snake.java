import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Random;

public class Snake extends JLabel {

    public Box    mHead    = new Box();
    public Timer  mTimer   = null;
    public Bait   mBait    = new Bait();
    public Random mRandom  = null;

    public ArrayList<Box> list = new ArrayList<>();

    Snake() {

        mRandom = new Random(System.currentTimeMillis());
        addKeyListener(new KeyboardControl());
        setFocusable(true);
        mTimer = new Timer(100, new TimerControl());
        mTimer.start();

        list.add(mHead);

        for (int i = 1; i < 10; i++) {
            addQueue();
        }

        add(mBait);
        add(mHead);
    }

    public void addQueue() {
        Box box = list.get(list.size() - 1).createBox();
        list.add(box);
        add(box);
    }

    public void addBait() {

        int width = getWidth() - 30 - mBait.mWidth;
        int height = getHeight() - 30 - mBait.mWidth;

        int posX = 10 + Math.abs(mRandom.nextInt()) % width;
        int posY = 10 + Math.abs(mRandom.nextInt()) % height;

        posX -= posX % 20;
        posY -= posY % 20;

        for (int i = 0; i < list.size(); i++) {
            if (posX == list.get(i).getX() && posY == list.get(i).getY()) {

                addBait();
                return;
            }
        }

        mBait.setPosition(posX, posY);
    }

    public void moveAll() {
        for (int i = list.size() - 1; i > 0; i--) {
            Box previous = list.get(i - 1);
            Box next = list.get(i);
            list.get(i).action();
            next.mDirection = previous.mDirection;
        }
        mHead.action();
    }

    public boolean isThereCollision() {

        int widthFrame = 10;
        int width = getWidth();
        int height = getHeight();

        if (mHead.getX() <= 10)
            return true;
        if (mHead.getX() + mHead.mWidth >= width - widthFrame)
            return true;

        if (mHead.getY() <= 10)
            return true;
        if (mHead.getY() + mHead.mWidth >= height - widthFrame)
            return true;

        for (int i = 1; i < list.size(); i++) {
            int x = list.get(i).getX();
            int y = list.get(i).getY();

            if (x == mHead.getX() && y == mHead.getY()) {
                return true;
            }
        }

        if (mBait.getX() == mHead.getX() && mBait.getY() == mHead.getY()) {
            addQueue();
            addBait();
        }

        return false;
    }

    class KeyboardControl implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                if (mHead.mDirection != DIRECTION.RIGHT)
                    mHead.mDirection = DIRECTION.LEFT;
            }

            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                if (mHead.mDirection != DIRECTION.LEFT)
                    mHead.mDirection = DIRECTION.RIGHT;
            }

            if (e.getKeyCode() == KeyEvent.VK_UP) {
                if (mHead.mDirection != DIRECTION.DOWN)
                    mHead.mDirection = DIRECTION.UP;
            }

            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                if (mHead.mDirection != DIRECTION.UP)
                    mHead.mDirection = DIRECTION.DOWN;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2 = (Graphics2D)g;

        Rectangle2D rect = new Rectangle2D.Double(5, 5, getWidth() - 10, getHeight() - 10);
        g2.setColor(Color.yellow);
        g2.setStroke(new BasicStroke(10));
        g2.draw(rect);
    }

    class TimerControl implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            moveAll();
            if (isThereCollision())
                mTimer.stop();
        }
    }
}
