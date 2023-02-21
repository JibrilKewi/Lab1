import org.junit.Before;
import org.junit.Test;


import java.util.Deque;

import static org.junit.Assert.*;

public class TransporterTest {
    private Car Volvo240;
    private CarTransporter transporter;

    @Before
    public void init(){
        Volvo240 = new Volvo240(1,1,Direction.NORTH);
        transporter = new CarTransporter(5,5,Direction.NORTH);
        Volvo240.startEngine();
    }

    @Test
    public void testIncrementSpeedTransporter(){
        transporter.lowerTrailer();
        transporter.incrementSpeed(1);
        assertEquals(transporter.getCurrentSpeed(), 0 , 0.0);
    }

    @Test
    public void testLoadCar(){
        transporter.lowerTrailer();
        transporter.loadCar(Volvo240);
        Object car = transporter.load.getCars().getFirst();
        assertEquals(car, Volvo240);
    }

    @Test
    public void testUnloadCar(){
        transporter.lowerTrailer();
        transporter.loadCar(Volvo240);
        transporter.unloadCar();
        assertTrue(transporter.load.getCars().isEmpty());
    }

    @Test
    public void testSetRampUp(){
        transporter.lowerTrailer();
        transporter.raiseTrailer();
        assertTrue(transporter.getIsRampUp());
    }

    @Test
    public void testMoveY(){
        transporter.lowerTrailer();
        transporter.loadCar(Volvo240);
        transporter.raiseTrailer();
        transporter.move();
        assertEquals(transporter.getyPos(), Volvo240.getyPos(), 0.0);
    }

    @Test
    public void testMoveX(){
        transporter.lowerTrailer();
        transporter.loadCar(Volvo240);
        transporter.raiseTrailer();
        transporter.move();
        assertEquals(transporter.getxPos(), Volvo240.getxPos(), 0.0);
    }

    @Test
    public void testMoveDir(){
        transporter.lowerTrailer();
        transporter.loadCar(Volvo240);
        transporter.raiseTrailer();
        transporter.move();
        assertEquals(transporter.getDir(), Volvo240.getDir());
    }
}

