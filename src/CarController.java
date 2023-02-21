import javax.swing.*;

import Vehicles.Saab95;
import Vehicles.Scania;
import Vehicles.Vehicle;
import Vehicles.Volvo240;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Vehicle> cars = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        Volvo240 volvo = new Volvo240(Color.BLACK);
        Scania scania = new Scania(Color.RED);
        Saab95 saab = new Saab95(Color.GRAY);

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        cc.cars.add(volvo);cc.cars.add(scania);cc.cars.add(saab);
        cc.frame.drawPanel.registerDrawable(volvo);
        cc.frame.drawPanel.registerDrawable(scania);
        cc.frame.drawPanel.registerDrawable(saab);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle car : cars) {
                car.move();
                car.clampPosition(0, 800);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

    // Calls the gas method for each car once
    void gasAll(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : cars) {
            car.gas(gas);
        }
    }

    void brakeAll(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle car : cars) {
            car.brake(brake);
        }
    }

    void turboOn() {
        cars.forEach(car -> {if (car instanceof Saab95) ((Saab95) car).setTurboOn();});
    }

    void turboOff() {
        cars.forEach(car -> {if (car instanceof Saab95) ((Saab95) car).setTurboOff();});
    }
}
