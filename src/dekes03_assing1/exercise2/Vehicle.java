package dekes03_assing1.exercise2;

import java.util.ArrayList;

/**
 * Class constructing <code>Vehicles</code>
 */

public class Vehicle {

    private int maxPassengers = 0;
    private int space = 0;
    private double costVehicle = 0;
    private double costPassenger = 0;

    ArrayList<Passenger> passengers = new ArrayList<Passenger>();

    public Vehicle(int maxPassengers, int space, double costVehicle, double costPassenger) {

        this.maxPassengers = maxPassengers;
        this.space = space;
        this.costVehicle = costVehicle;
        this.costPassenger = costPassenger;

    }

    /**
     * Method adding <code>Passangers</code> to vehicle
     *
     * Throws <code>NoRoomForPassengerrException</code>
     *
     */

    public void addPassenger(Passenger passenger) throws NoRoomForPassengerException {

        if (this.maxPassengers > this.passengers.size()) {

            passengers.add(passenger);

        } else {

            throw new NoRoomForPassengerException(maxPassengers);

        }

    }

    /**
     * Method gets total cost of veichle with passengers
     * @return double
     */

    public double getTotalCost() {

        return this.costVehicle + (this.passengers.size() * this.costPassenger);

    }

    /**
     * Method gets total amount passengers in veichle
     * @return int
     */

    public int getTotalPassengers() {
        return this.passengers.size();
    }

    /**
     * Method gets total amount of space that the veichle occupies
     * @return int
     */

    public int getTotalSpace() {
        return this.space;

    }

    /**
     * Make a nice print out
     * @return String
     */

    public String toString() {

        StringBuffer sb = new StringBuffer();

        sb.append("Passengers: " + passengers.size() + " ");
        sb.append("Cost vehicle: " + costVehicle + " ");
        sb.append("Cost passengers:" + costPassenger * passengers.size() + " ");

        return sb.toString();

    }

}
