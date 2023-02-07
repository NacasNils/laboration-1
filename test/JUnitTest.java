import static org.junit.Assert.*;

import java.awt.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class JUnitTest {
    @Test
    public void test_turbo() {
        Saab95 Vehicle1 = new Saab95(Color.RED);
        assertEquals(Vehicle1.getTurbo(), false);
        Vehicle1.setTurboOn();
        assertEquals(Vehicle1.getTurbo(), true);
    }

    @Test
    public void test_dir() {
        Saab95 Vehicle1 = new Saab95(Color.RED);
        assertEquals(Vehicle1.getCurrentDir(), Vehicle.Dir.UP);
        Vehicle1.turnRight();
        assertEquals(Vehicle1.getCurrentDir(), Vehicle.Dir.RIGHT);
        Vehicle1.turnRight();
        assertEquals(Vehicle1.getCurrentDir(), Vehicle.Dir.DOWN);
        Vehicle1.turnRight();
        assertEquals(Vehicle1.getCurrentDir(), Vehicle.Dir.LEFT);
        Vehicle1.turnLeft();
        assertEquals(Vehicle1.getCurrentDir(), Vehicle.Dir.DOWN);
    }

    @Test
    public void test_stationary() {
        Saab95 Vehicle1 = new Saab95(Color.RED);
        assertEquals(Vehicle1.getCurrentPos(), new Point (0,0) );
        Vehicle1.move();
        assertEquals(Vehicle1.getCurrentPos(), new Point (0,0) );
    }

    @Test
    public void test_colors() {
        Saab95 Vehicle1 = new Saab95(Color.RED);
        Volvo240 Vehicle2 = new Volvo240(Color.RED);

        Vehicle1.setColor(Color.GREEN);
        Vehicle2.setColor(Color.GRAY);

        assertEquals(Vehicle1.getColor(), Color.GREEN);
        assertEquals(Vehicle2.getColor(), Color.GRAY);

        Vehicle1.gas(0.0);
        Vehicle1.brake(0.0);
        assertEquals((int) Vehicle1.getCurrentSpeed(), 0);


    }

    @Test
    public void test_doors() {
        Saab95 Vehicle1 = new Saab95(Color.RED);
        Volvo240 Vehicle2 = new Volvo240(Color.RED);

        assertEquals(Vehicle1.getNrDoors(), 2);
        assertEquals(Vehicle2.getNrDoors(), 4);
    }

    @Test
    public void test_fake_input() {
        Saab95 Vehicle1 = new Saab95(Color.RED);
        Volvo240 Vehicle2 = new Volvo240(Color.RED);

        Vehicle1.gas(0.0);
        Vehicle1.brake(0.0);
        assertEquals((int) Vehicle1.getCurrentSpeed(), 0);
    }

    @Test
    public void test_specs() {
        Saab95 Vehicle1 = new Saab95(Color.RED);
        Volvo240 Vehicle2 = new Volvo240(Color.RED);

        assertEquals(Vehicle1.getColor(), Color.RED);
        assertEquals(Vehicle2.getColor(), Color.BLACK);
        assertEquals((int) Vehicle1.getEnginePower(), 125);
        assertEquals((int) Vehicle2.getEnginePower(), 100);
    }


    @Test
    public void test_wrong_input_speed() {
        Saab95 Vehicle1 = new Saab95(Color.RED);

        Vehicle1.gas(-1);
        Vehicle1.move();
        assertEquals((int) Vehicle1.getCurrentSpeed(), 0);
        assertEquals(Vehicle1.getCurrentPos(), new Point(0,0));

        Vehicle1.gas(1);
        Vehicle1.brake(-1);
        assertTrue((int) Vehicle1.getCurrentSpeed() != 0);
    }

    @Test
    public void test_fullstop() {
        Saab95 Vehicle1 = new Saab95(Color.RED);

        int i = 10;
        while (i > 0) {
            i--;
            Vehicle1.gas(1);
        }

        assertTrue((int) Vehicle1.getCurrentSpeed() > 0);

        while (Vehicle1.getCurrentSpeed() > 0) {
            Vehicle1.brake(1);
        }

        assertEquals((int) Vehicle1.getCurrentSpeed(), 0);
    }
}