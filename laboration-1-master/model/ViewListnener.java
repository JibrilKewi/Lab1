package model;

public interface ViewListnener {

    void gasPerformed(int gasAmount);

    void brakePerformed(int gasAmount);

    void turboOnPerformed();

    void turboOffPerformed();

    void startPerformed();

    void stopPerformed();

    void liftBedPerformed();

    void lowerBedPerformed();

}
