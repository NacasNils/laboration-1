
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

import General.Drawable;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel {
    // A list of drawables
    ArrayList<Drawable> drawables = new ArrayList<>();

    public void registerDrawable(Drawable d) {
        drawables.add(d);
    }

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
            int x = drawable.getCurrentPos().x;
            int y = drawable.getCurrentPos().y;
            g.drawImage(drawable.getImage(), x, y + 100*i, null);
        }
        /* g.drawImage(scaniaImage, scaniaPoint.x, scaniaPoint.y + 100, null);
        g.drawImage(saabImage, saabPoint.x, saabPoint.y + 200, null); */
    }
}
