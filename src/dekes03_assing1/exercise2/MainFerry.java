package dekes03_assing1.exercise2;

import java.util.Iterator;

public class MainFerry {

    public static void main(String[] args) {

        try {

            Car car = new Car();

            car.addPassenger(new Passenger());
            car.addPassenger(new Passenger());
            car.addPassenger(new Passenger());
            // car.addPassenger(new Passenger());

            Car car2 = new Car();

            car2.addPassenger(new Passenger());
            car2.addPassenger(new Passenger());

            Bicycle bicycle = new Bicycle();
            Bicycle bicycle1 = new Bicycle();
            Bicycle bicycle2 = new Bicycle();
            Bicycle bicycle3 = new Bicycle();
            Bicycle bicycle4 = new Bicycle();
            Bicycle bicycle5 = new Bicycle();

            bicycle.addPassenger(new Passenger());
            bicycle1.addPassenger(new Passenger());
            bicycle2.addPassenger(new Passenger());
            bicycle3.addPassenger(new Passenger());
            bicycle4.addPassenger(new Passenger());
            bicycle5.addPassenger(new Passenger());

            Passenger passenger = new Passenger();
            Passenger passenger2 = new Passenger();
            Passenger passenger3 = new Passenger();

            Bus bus = new Bus();

            bus.addPassenger(new Passenger());
            bus.addPassenger(new Passenger());
            bus.addPassenger(new Passenger());
            bus.addPassenger(new Passenger());
            bus.addPassenger(new Passenger());
            bus.addPassenger(new Passenger());
            bus.addPassenger(new Passenger());
            bus.addPassenger(new Passenger());
            bus.addPassenger(new Passenger());
            bus.addPassenger(new Passenger());
            bus.addPassenger(new Passenger());
            bus.addPassenger(new Passenger());
            bus.addPassenger(new Passenger());
            bus.addPassenger(new Passenger());
            bus.addPassenger(new Passenger());
            bus.addPassenger(new Passenger());
            bus.addPassenger(new Passenger());
            bus.addPassenger(new Passenger());
            bus.addPassenger(new Passenger());
            bus.addPassenger(new Passenger());

            Bus bus1 = new Bus();

            bus1.addPassenger(new Passenger());
            bus1.addPassenger(new Passenger());
            bus1.addPassenger(new Passenger());
            bus1.addPassenger(new Passenger());
            bus1.addPassenger(new Passenger());
            bus1.addPassenger(new Passenger());
            bus1.addPassenger(new Passenger());
            bus1.addPassenger(new Passenger());
            bus1.addPassenger(new Passenger());
            bus1.addPassenger(new Passenger());
            bus1.addPassenger(new Passenger());
            bus1.addPassenger(new Passenger());
            bus1.addPassenger(new Passenger());
            bus1.addPassenger(new Passenger());
            bus1.addPassenger(new Passenger());
            bus1.addPassenger(new Passenger());
            bus1.addPassenger(new Passenger());
            bus1.addPassenger(new Passenger());
            bus1.addPassenger(new Passenger());

            Bus bus2 = new Bus();

            bus2.addPassenger(new Passenger());

            Lorry lorry = new Lorry();

            lorry.addPassenger(new Passenger());

            Lorry lorry1 = new Lorry();

            lorry1.addPassenger(new Passenger());

            Lorry lorry2 = new Lorry();

            lorry2.addPassenger(new Passenger());

            Lorry lorry3 = new Lorry();

            lorry3.addPassenger(new Passenger());

            Lorry lorry4 = new Lorry();

            lorry4.addPassenger(new Passenger());
            lorry4.addPassenger(new Passenger());

            IFerry ferry = new Ferry();

            ferry.embark(car);
            ferry.embark(bicycle);
            ferry.embark(passenger);
            ferry.embark(passenger2);
            ferry.embark(passenger3);
            ferry.embark(bus);
            ferry.embark(bus1);
            ferry.embark(bus2);

            ferry.embark(lorry);
            ferry.embark(lorry1);
            ferry.embark(lorry2);
            ferry.embark(car2);

            System.out.println(ferry.toString());

            System.out.println("Can the ferry take more passengers? " + ferry.hasRoomFor(passenger) + "\n");

            System.out.println("Can the ferry take more vehicles? " + ferry.hasSpaceFor(bus) + "\n");

            Iterator<Vehicle> iterator = ferry.iterator();

            System.out.println("Vehicles on the ferry:\n");

            int i = 1;
            while (iterator.hasNext()) {

                Vehicle v = iterator.next();
                System.out.println("Vehicle " + i + ": " + v);
                i++;
            }

            System.out.println("");

            ferry.disembark();

            System.out.println(ferry.toString());

        } catch (NoRoomForPassengerException nrfpe) {

            System.err.println(nrfpe.getMessage());

        } catch (NoRoomForVehiclesException nrfve) {

            System.err.println(nrfve.getMessage());
        }
    }
}
