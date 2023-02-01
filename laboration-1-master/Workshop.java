import java.util.Deque;
import java.util.LinkedList;

public class Workshop <T extends Car>{
    /**
     * Use Generic types in order to accept a specific car type ex (Volvo240)
     * or just cars in general
     * Ex: Can construct a workshop that only takes Volvo240 and one that only
     * takes Saab95
     */
    private int capacity;
    private final Deque<T> carLoad = new LinkedList<>();

    public Workshop(int capacity){
        this.capacity = capacity;
    }

    /**
     * Stores car in workshop if capacity allows
     * @param car The type of care to be stored
     */
    public void storeCar (T car){
        if (carLoad.size() < capacity){
            carLoad.push(car);
        } else {
            throw new IllegalArgumentException("Workshop is full");
        }
    }

    /**
     * Returns the specified car type that arrived most recently at the shop
     * @return The car from top of the stack
     */
    public T getCar(){
        return carLoad.pop();
    }


    /**
     * Returns the capacity of the workshop
     * @return capacity as an int
     */
    public int getCapacity() {
        return capacity;
    }

}
