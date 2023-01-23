/**
 * HelperMethods contains the helper method amountInterval which checks whether a given amount lies within a given
 * interval.
 */
public abstract class HelperMethods {

    public static double amountInterval(double amount, double lower, double upper){
        return amount > upper ? upper : Math.max(amount, lower);
    }
}
