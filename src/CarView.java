import java.awt.*;
import javax.swing.*;

import General.Drawable;

/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller in it's state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of it's components.
 **/

public class CarView extends JFrame implements SimulationObserver {
    public static final int X = 900;
    public static final int Y = 800;

    // The controller member
    private DrawPanel drawPanel;
    private ControlPanel bottomPanel;

    // Constructor
    public CarView(String framename, CarController cc){
        this.setTitle(framename);
        this.setPreferredSize(new Dimension(X, Y));
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

        drawPanel = new DrawPanel(X, Y-100);
        bottomPanel = new ControlPanel(cc);

        this.add(drawPanel);
        this.add(bottomPanel);

        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void refreshState() {
        drawPanel.repaint();
    }
    
    public void queueDraw(Drawable d) {
        drawPanel.drawables.add(d);
    }
}