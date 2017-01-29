package dekes03_assing1.exercise2;

public class Bus extends Vehicle {

	/*
     * Subclass to superclass Vehicle contain values and constructor for this
	 * specific object type
	 */

    private static int maxPassangers = 20;
    private static int space = 20;
    private static double costVehicle = 100;
    private static double costPassenger = 10;

    public Bus() {

        super(maxPassangers, space, costVehicle, costPassenger);

    }

}
