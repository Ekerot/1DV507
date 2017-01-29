package dekes03_assing1.exercise2;

public class NoRoomForPassengerException extends Exception {

	/*
     * Exception class created to throw No room for passenger exceptions
	 */

    private static final long serialVersionUID = -9049979697538276439L;

    public NoRoomForPassengerException(int maxPassengers) {

        super("No room for new passengers. The maximum of " + maxPassengers + " passengers has been reached."); // message
        // to
        // be
        // thrown
        // when
        // exception
        // is triggered

    }

}
