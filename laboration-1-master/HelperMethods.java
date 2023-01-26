/**
 * HelperMethods contains the helper method amountInterval.
 */
public abstract class HelperMethods {

    /**
     * amountInterval checks whether a given amount lies within a given interval. Returns the lower value if
     * the amount is less than the lower bound and returns the upper value if the amount exceeds the upper value,
     * otherwise returns the given amount.
     * @param amount - amount to be checked
     * @param lower - lower value
     * @param upper - upper value
     * @return - an amount between upper and lower
     */
    public static double amountInterval(double amount, double lower, double upper){
        return amount > upper ? upper : Math.max(amount, lower);
    }
}
