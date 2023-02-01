import org.junit.Before;
import org.junit.Test;

import java.util.Deque;

import static org.junit.Assert.*;


public class WorkshopTest {

    private Volvo240 Volvo240;

    private Workshop<Volvo240> workshop;

    private Deque<Car> carLoad;


    @Before
    public void init(){
        Volvo240 = new Volvo240(1,1, Direction.NORTH);
        workshop = new Workshop<>(2);
    }

    @Test
    public void testStoreCar(){
        workshop.storeCar(Volvo240);
        Volvo240 Workshop = workshop.getCar();
        assertEquals(Workshop, Volvo240);

    }

    @Test
    public void testStoreFail(){
        for (int i = 0; i < workshop.getCapacity() + 1; i++) {
            try {
                workshop.storeCar(Volvo240);
            } catch (IllegalArgumentException e) {
                assertEquals("Workshop is full", e.getMessage());
                throw e;
            }
        }
        fail("Expected an IllegalArgumentException to be thrown");
    }






}
