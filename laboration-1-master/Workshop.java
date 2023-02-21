/**
 * Workshop is used to initialize workshop-object which can store cars.
 * Use Generic types in order to accept a specific car type ex (Volvo240)
 * or just cars in general
 * Ex: Can construct a workshop that only takes Volvo240 and one that only
 * takes Saab95
 */

public class Workshop <T extends Car>{

    // TODO Implementera interface carloadmethods korrekt
    CarLoad<T> carLoad;

    public Workshop() {
        this.carLoad = new CarLoad<>();
    }

    /**
     * Stores car in workshop if capacity allows
     * @param car The type of care to be stored
     */
    public void loadCar(T car){
        if (canLoad()){
            carLoad.loadCar(car);
        } else {
            throw new IllegalArgumentException("Workshop is full");
        }
    }


    /**
     * Returns the specified car type that arrived most recently at the shop
     * The car from top of the stack
     */
    public void unloadCar(){
        carLoad.unloadCar();
    }



    public boolean canLoad(){
        return carLoad.notFullLoad();
    }

}
