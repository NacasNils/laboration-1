import static org.junit.Assert.*;

import java.awt.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class JUnitTest {
    @Test
    public void test_turbo() {
        Saab95 car1 = new Saab95();
        assertEquals(car1.getTurbo(), false);
        car1.setTurboOn();
        assertEquals(car1.getTurbo(), true);
    }

    @Test
    public void test_dir() {
        Saab95 car1 = new Saab95();
        assertEquals(car1.getCurrentDir(), Car.Dir.UP);
        car1.turnRight();
        assertEquals(car1.getCurrentDir(), Car.Dir.RIGHT);
        car1.turnRight();
        assertEquals(car1.getCurrentDir(), Car.Dir.DOWN);
        car1.turnRight();
        assertEquals(car1.getCurrentDir(), Car.Dir.LEFT);
        car1.turnLeft();
        assertEquals(car1.getCurrentDir(), Car.Dir.DOWN);
    }

    @Test
    public void test_stationary() {
        Saab95 car1 = new Saab95();
        assertEquals(car1.getCurrentPos(), new Point (0,0) );
        car1.move();
        assertEquals(car1.getCurrentPos(), new Point (0,0) );
    }

    @Test
    public void test_colors() {
        Saab95 car1 = new Saab95();
        Volvo240 car2 = new Volvo240();

        car1.setColor(Color.GREEN);
        car2.setColor(Color.GRAY);

        assertEquals(car1.getColor(), Color.GREEN);
        assertEquals(car2.getColor(), Color.GRAY);

        car1.gas(0.0);
        car1.brake(0.0);
        assertEquals((int) car1.getCurrentSpeed(), 0);


    }

    @Test
    public void test_doors() {
        Saab95 car1 = new Saab95();
        Volvo240 car2 = new Volvo240();

        assertEquals(car1.getNrDoors(), 2);
        assertEquals(car2.getNrDoors(), 4);
    }

    @Test
    public void test_fake_input() {
        Saab95 car1 = new Saab95();
        Volvo240 car2 = new Volvo240();

        car1.gas(0.0);
        car1.brake(0.0);
        assertEquals((int) car1.getCurrentSpeed(), 0);
    }

    @Test
    public void test_specs() {
        Saab95 car1 = new Saab95();
        Volvo240 car2 = new Volvo240();

        assertEquals(car1.getColor(), Color.RED);
        assertEquals(car2.getColor(), Color.BLACK);
        assertEquals((int) car1.getEnginePower(), 125);
        assertEquals((int) car2.getEnginePower(), 100);
    }


    @Test
    public void test_wrong_input_speed() {
        Saab95 car1 = new Saab95();

        car1.gas(-1);
        car1.move();
        assertEquals((int) car1.getCurrentSpeed(), 0);
        assertEquals(car1.getCurrentPos(), new Point(0,0));

        car1.gas(1);
        car1.brake(-1);
        assertTrue((int) car1.getCurrentSpeed() != 0);
    }

    @Test
    public void test_fullstop() {
        Saab95 car1 = new Saab95();

        int i = 10;
        while (i > 0) {
            i--;
            car1.gas(1);
        }

        assertTrue((int) car1.getCurrentSpeed() > 0);

        while (car1.getCurrentSpeed() > 0) {
            car1.brake(1);
        }

        assertEquals((int) car1.getCurrentSpeed(), 0);
    }
}