package dekes03_assing1.exercise2;

public class Lorry extends Vehicle {

	/*
     * Subclass to superclass Vehicle contain values and constructor for this
	 * specific object type
	 */

    private static int maxPassangers = 2;
    private static int space = 40;
    private static double costVehicle = 300;
    private static double costPassenger = 15;

    public Lorry() {

        super(maxPassangers, space, costVehicle, costPassenger);

    }

}
