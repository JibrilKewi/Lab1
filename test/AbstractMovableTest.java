import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AbstractMovableTest {

    private Car saab95;

    @Before
    public void init() {
        saab95 = new Saab95(1,1, Direction.NORTH, 0);

        saab95.startEngine();
    }

    @Test
    public void testMoveNorthAndSouth() {
        saab95.move();
        saab95.setCurrentSpeed(-saab95.getCurrentSpeed());
        saab95.move();
        assertEquals(1, saab95.getyPos(), 0.0);
    }

    @Test
    public void testMoveNorth() {
        saab95.move();
        assertEquals(1.1, saab95.getyPos(), 0.0);
    }


    @Test
    public void testTurnLeft() {
        saab95.turnLeft();
        saab95.turnLeft();
        saab95.turnLeft();
        saab95.turnLeft();
        assertEquals(Direction.NORTH, saab95.getDir());
    }

    @Test
    public void testTurnRight() {
        saab95.turnRight();
        saab95.turnRight();
        saab95.turnRight();
        saab95.turnRight();
        assertEquals(Direction.NORTH, saab95.getDir());
    }
}