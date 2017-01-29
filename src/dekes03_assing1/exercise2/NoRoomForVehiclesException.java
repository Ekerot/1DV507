package dekes03_assing1.exercise2;

public class NoRoomForVehiclesException extends Exception {
    /*
     * Exception class created to throw No room for vehicle exceptions
     */
    private static final long serialVersionUID = -9049979697539276439L;

    public NoRoomForVehiclesException() {

        super("No room for new vehicles. The maximum of vehicles has been reached."); // message
        // to
        // be
        // thrown
        // when
        // exception
        // is triggered

    }

}
