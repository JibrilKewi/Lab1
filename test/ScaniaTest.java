import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ScaniaTest {

    private Scania Scania;

    @Before
    public void init(){
        Scania = new Scania(1, 1, Direction.NORTH);
    }

    @Test
    public void testSafeTrailerAngle(){
        double angle = 20.0;
        Scania.setCurrentSpeed(0.0);
        Scania.setSafeTrailerAngle(angle);
        assertEquals(20.0, Scania.getTrailerAngle(), 0.0);

    }

    @Test
    public void testLowerTrailer(){
        int amount = 20;
        Scania.raiseTrailer(amount);
        amount = 10;
        Scania.lowerTrailer(amount);
        assertEquals(Scania.getTrailerAngle(), 10, 0.0);
    }

    @Test
    public void testRaiseTrailer(){
        int amount = 20;
        Scania.raiseTrailer(amount);
        assertEquals(Scania.getTrailerAngle(), amount, 0.0);
    }

    @Test
    public void testIncrementSpeedScania(){
        Scania.raiseTrailer(20);
        Scania.incrementSpeed(1);
        assertEquals(Scania.getCurrentSpeed(), 0, 0);
    }

}
