import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

import General.Drawable;

// This panel represent the animated part of the view with the car images.
public class DrawPanel extends JPanel {
    // A list of drawables
    ArrayList<Drawable> drawables = new ArrayList<>();

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.blue);
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < drawables.size(); i++) {
            Drawable drawable = drawables.get(i);
            int x = (int) drawable.getCurrentPos().getX();
            int y = (int) drawable.getCurrentPos().getY();
            g.drawImage(drawable.getImage(), x, y + 100*i, null);
        }

        // Clear the buffer
        drawables.clear();
    }
}
