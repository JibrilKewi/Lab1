package model;

import java.util.List;

public interface WorldListener {

    void actOnChange(List<MotorizedVehicle> vehicles);
}
