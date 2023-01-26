import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JUnitTest {
    @Test
    public void test_color() {
        Saab95 car1 = new Saab95();
        Volvo240 car2 = new Volvo240();

        assertEquals(car1.getColor(), Color.RED);
        assertEquals(car2.getColor(), Color.BLACK);
        
        car1.setColor(Color.GREEN);
        car2.setColor(Color.GRAY);

        assertEquals(car1.getColor(), Color.GREEN);
        assertEquals(car2.getColor(), Color.GRAY);

        assertEquals(car1.getTurbo(), false);
        car1.setTurboOn();
        assertEquals(car1.getTurbo(), true);
    }

    @Test
    public void test_turbo() {
        Saab95 car1 = new Saab95();
        assertEquals(car1.getTurbo(), false);
        car1.setTurboOn();
        assertEquals(car1.getTurbo(), true);
    }

    public static void main(String[] args) {}
}