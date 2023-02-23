import org.junit.Before;
import org.junit.Test;

import java.util.Deque;

import static org.junit.Assert.*;


public class WorkshopTest {


    private Volvo240 Volvo240;

    private Workshop<Volvo240> workshop;

    @Before
    public void init(){
        Volvo240 = new Volvo240(1,1, Direction.NORTH);
        workshop = new Workshop<>();
    }

    @Test
    public void testStoreCar(){
        workshop.loadCar(Volvo240);
        Car car = workshop.carLoad.getCars().getLast();
        assertEquals(car, Volvo240);
    }

    @Test
    public void testUnloadCar(){
        workshop.loadCar(Volvo240);
        workshop.unloadCar();
        assertTrue(workshop.carLoad.getCars().isEmpty());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testStoreFail(){
        for (int i = 0; i < CarLoad.getMaxCars() + 1; i++) {
            try {
                workshop.loadCar(Volvo240);
            } catch (IllegalArgumentException e) {
                assertEquals("Workshop is full", e.getMessage());
                throw e;
            }
        }
        fail("Expected an IllegalArgumentException to be thrown");
    }

}
