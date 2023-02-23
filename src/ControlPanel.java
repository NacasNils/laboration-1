import java.awt.*;
import javax.swing.*;

// This panel represent the controls part of the view.
public class ControlPanel extends JPanel {
    private int gasAmount = 0;

    private JButton gasButton = new JButton("Gas");
    private JButton brakeButton = new JButton("Brake");
    private JButton turboOnButton = new JButton("Saab Turbo on");
    private JButton turboOffButton = new JButton("Saab Turbo off");
    private JButton liftBedButton = new JButton("Scania Lift Bed");
    private JButton lowerBedButton = new JButton("Lower Lift Bed");

    private JButton startButton = new JButton("Start all cars");
    private JButton stopButton = new JButton("Stop all cars");

    // Constructor
    public ControlPanel(CarController cc) {
        // Gas Amount setter
        JPanel gasPanel = new JPanel();
        SpinnerModel spinnerModel = new SpinnerNumberModel(0, 0, 100, 10);
        JSpinner gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.addChangeListener(e -> gasAmount = (int) ((JSpinner)e.getSource()).getValue());
        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(new JLabel("Amount of gas/brake"), BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);
        

        // Grid buttons
        JPanel grid = new JPanel();
        grid.setLayout(new GridLayout(2,4));
        grid.add(gasButton);
        grid.add(turboOnButton);
        grid.add(liftBedButton);
        grid.add(startButton);
        grid.add(brakeButton);
        grid.add(turboOffButton);
        grid.add(lowerBedButton);
        grid.add(stopButton);
        
        this.add(gasPanel);
        this.add(grid);

        // start/stop button style
        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);

        // actionListeners
        gasButton.addActionListener(e -> cc.gasAll(gasAmount));
        brakeButton.addActionListener(e -> cc.brakeAll(gasAmount));
        turboOnButton.addActionListener(e -> cc.turboOn());
        turboOffButton.addActionListener(e -> cc.turboOff());
        stopButton.addActionListener(e -> cc.stopAllCars());
        startButton.addActionListener(e -> cc.startAllCars());
    }
}