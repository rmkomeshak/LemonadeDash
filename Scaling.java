import java.awt.*;

/**
 * Created by mjschmidt on 4/4/17.
 */
public class Scaling {
    static double scale = 60;

    public static double windowWidth() {
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth();
        double newWidth = scale/100 * width;
        return newWidth;
    }

    public static double windowHeight() {
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int height = gd.getDisplayMode().getHeight();
        double newHeight = scale/100 * height;
        return newHeight;
    }
}
