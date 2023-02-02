import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


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
        transporter.loadCar(Volvo240);
        assertEquals(transporter.getCarLoad(), Volvo240);
    }


    @Test
    public void testUnloadCar(){
        transporter.loadCar(Volvo240);
        Car car = transporter.unLoadCar();
        assertEquals(car, Volvo240);


    }

}
