package dekes03_assing1.exercise2;

import java.util.ArrayList;
import java.util.Iterator;

public class Ferry implements IFerry {

    protected int passengersTotal = 0;
    protected int vSpace = 0;
    protected int cost = 0;

    private ArrayList<Passenger> passengers = new ArrayList<Passenger>();
    private ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();

    @Override
    public int countPassengers() { // Number of passengers on board
        return this.passengersTotal;
    }  //returns amount of passengers

    @Override
    public int countVehicleSpace() { // Used vehicle space. One car is 1.
        return this.vSpace / 5;
    }

    @Override
    public int countMoney() { // Earned money
        int totalCostSum = 0;

        for (Vehicle v : this.vehicles) {
            totalCostSum += v.getTotalCost();

        }

        Passenger p = new Passenger();
        totalCostSum += (p.totalCostPassenger() * this.passengers.size());

        this.cost += totalCostSum;

        return this.cost;

    }

    @Override
    public Iterator<Vehicle> iterator() { // Vehicle iterator

        return new VehicleIterator();

    }

    public void embark(Vehicle v) throws NoRoomForVehiclesException { // Embark
        // vehicle,
        // warning
        // if
        // not
        // enough
        // space

        if (this.vehicles.contains(v)) {

            System.err.println("This vehicle has already embarked.");

        } else {

            this.vSpace += v.getTotalSpace();

            if (this.vSpace >= 200) {

                throw new NoRoomForVehiclesException();

            }

            this.vehicles.add(v);
            this.passengersTotal += v.getTotalPassengers();
        }
    }

    @Override
    public void embark(Passenger p) throws NoRoomForPassengerException { // Embark
        // passenger,
        // exception
        // if
        // not
        // enough
        // room
        this.passengersTotal++;

        if (this.passengersTotal >= 200) {

            throw new NoRoomForPassengerException(200);

        } else {
            this.passengers.add(p);

        }

    }

    @Override
    public void disembark() { // Clear (empty) ferry. The money earned remains,
        this.passengers.clear();
        this.vehicles.clear();
        this.vSpace = 0;
        this.passengersTotal = 0;

    }

    @Override
    public boolean hasSpaceFor(Vehicle v) { // i.e., is not reset to zero

        this.vSpace += v.getTotalSpace();

        if (this.vSpace <= 200) {
            this.vSpace -= v.getTotalSpace();
            return true;

        }

        this.vSpace -= v.getTotalSpace();
        return false;
    }

    @Override
    public boolean hasRoomFor(Passenger p) { // true if we can embark vehicle v
        if (this.passengers.size() <= 200) {
            return true;
        }
        return false;
    }

    public String toString() { // Nice looking ferry status print out

        String str = "Total ferry status:\n" + "Total embarked passengers: " + countPassengers()
                + "\nTotal vehicle space occupied(counted in cars): " + countVehicleSpace() + "\nCost: " + countMoney()
                + "\n";

        return str;
    }

    public class VehicleIterator implements Iterator<Vehicle> {

        private int index;

        public VehicleIterator() {

            index = 0;
        }

        public boolean hasNext() {
            return index < vehicles.size();
        }

        public Vehicle next() {
            return vehicles.get(index++);
        }

    }
}
