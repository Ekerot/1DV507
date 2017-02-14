package dekes03_assing1.exercise2;

public class Bicycle extends Vehicle {

	/*
     * Subclass to superclass Vehicle contain values and constructor for this
	 * specific object type
	 */

    private static final int maxPassangers = 1;
    private static final int space = 1;
    private static final double costVehicle = 40;
    private static final double costPassenger = 0;

    public Bicycle() {

        super(maxPassangers, space, costVehicle, costPassenger);

    }

}
