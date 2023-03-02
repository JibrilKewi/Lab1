package model;

import java.util.Deque;
import java.util.LinkedList;

/**
 * model.Workshop is used to initialize workshop-object which can store vehicles.
 * Use Generic types in order to accept a specific car type ex (model.Volvo240)
 * or just vehicles in general
 * Ex: Can construct a workshop that only takes model.Volvo240 and one that only
 * takes model.Saab95
 */

public class Workshop <T extends Vehicle>{

    private int capacity;
    private final Deque<T> vehicleLoad = new LinkedList<>();

    public Workshop(int capacity){
        this.capacity = capacity;
    }

    /**
     * Stores car in workshop if capacity allows
     * @param vehicle The type of care to be stored
     */
    public void storeVehicle (T vehicle){
        if (vehicleLoad.size() < capacity){
            vehicleLoad.push(vehicle);
        } else {
            throw new IllegalArgumentException("model.Workshop is full");
        }
    }

    /**
     * Returns the specified car type that arrived most recently at the shop
     * @return The car from top of the stack
     */
    public T getVehicle(){
        return vehicleLoad.pop();
    }


    /**
     * Returns the capacity of the workshop
     * @return capacity as an int
     */
    public int getCapacity() {
        return capacity;
    }

}
