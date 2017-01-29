package dekes03_assing1.exercise2;

public class Car extends Vehicle {

	/*
     * Subclass to superclass Vehicle contain values and constructor for this
	 * specific object type
	 */

    private static final int maxPassangers = 4;
    private static final int space = 5;
    private static double costVehicle = 100;
    private static double costPassenger = 15;

    public Car() {

        super(maxPassangers, space, costVehicle, costPassenger);

    }

}
