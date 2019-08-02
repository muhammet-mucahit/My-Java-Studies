import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    private int mHeight = 600;
    private int mWidth = 600;

    // #Singleton design pattern. It is problem with more than one thread !!!
    private static MainWindow mWindow = null;

    // #Singleton design pattern
    private MainWindow() {
        // When we closed the window, the program also will be closed.
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setDimension(mWidth, mHeight);
        // It provides the window with constant size.
        setResizable(false);

        Snake snake = new Snake();
        add(snake);
    }

    // #Singleton design pattern
    public static MainWindow getWindow() {
        if (mWindow == null) mWindow = new MainWindow();
        return mWindow;
    }

    public void setDimension(int width, int height) {
        // We get screen size which the game is played on.
        Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();

        int posX = 0;
        int posY = 0;

        if (mWidth + 100 > screenDimension.width)   mWidth = screenDimension.width - 100;
        if (mHeight + 100 > screenDimension.height) mHeight = screenDimension.height - 100;

        posX = (screenDimension.width - mWidth) / 2;
        posY = (screenDimension.height - mHeight) / 2;

        setBounds(posX, posY, mWidth, mHeight);
    }
}
