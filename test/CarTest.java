import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;

public class CarTest {
    private final double amount = 0.3;
    private Car saab95;
    private Car volvo240;

    @Before
    public void init() {
        saab95 = new Saab95(1,1, Direction.NORTH);

        volvo240 = new Volvo240(1, 1, Direction.NORTH);

        volvo240.startEngine();
        saab95.startEngine();
    }

    @Test
    public void testIncrementSpeed() {
        double expectedSpeedVolvo = Math.min(volvo240.getCurrentSpeed() + volvo240.speedFactor() * amount,
                                             volvo240.getEnginePower());

        double expectedSpeedSaab = Math.min(saab95.getCurrentSpeed() + saab95.speedFactor() * amount,
                                            saab95.getEnginePower());

        volvo240.incrementSpeed(amount);
        assertEquals(expectedSpeedVolvo, volvo240.getCurrentSpeed(), 0.0);

        saab95.incrementSpeed(amount);
        assertEquals(expectedSpeedSaab, saab95.getCurrentSpeed(), 0.0);

    }

    @Test
    public void testDecrementSpeed() {
        double expectedSpeedVolvo = Math.max(volvo240.getCurrentSpeed() - volvo240.speedFactor() * amount, 0);
        double expectedSpeedSaab = Math.max(saab95.getCurrentSpeed() - saab95.speedFactor() * amount, 0);

        volvo240.decrementSpeed(amount);
        assertEquals(expectedSpeedVolvo, volvo240.getCurrentSpeed(), 0.0);

        saab95.decrementSpeed(amount);
        assertEquals(expectedSpeedSaab, saab95.getCurrentSpeed(), 0.0);
    }


}