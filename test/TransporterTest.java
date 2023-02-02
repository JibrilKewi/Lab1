import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class TransporterTest {
    private Car Volvo240;
    private CarTransporter transporter;

    @Before
    public void init(){
        Volvo240 = new Volvo240(1,1,Direction.NORTH);
        transporter = new CarTransporter(1,5,Direction.NORTH);
        Volvo240.startEngine();
    }

    @Test
    public void testLoadCar(){
        transporter.setRampDown();
        transporter.loadCar(Volvo240);
        Car car = transporter.getCarLoad().getFirst();
        assertEquals(car, Volvo240);
    }


    @Test
    public void testUnloadCar(){
        transporter.setRampDown();
        transporter.loadCar(Volvo240);
        Car car = transporter.unLoadCar();
        assertEquals(car, Volvo240);
    }
    @Test
    public void testSetRampUp(){
        transporter.setRampDown();
        transporter.setRampUp();
        assertFalse(transporter.getIsRampDown());
    }

    @Test
    public void testIncrementSpeedCarTransporter(){
        transporter.setRampDown();
        transporter.incrementSpeed(1);
        assertEquals(transporter.getCurrentSpeed(), 0, 0);

    }
}

