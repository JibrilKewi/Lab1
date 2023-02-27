package model;

public interface CarLoadMethods <T extends Car> {
    void loadCar(Car car);
    void unloadCar();
}