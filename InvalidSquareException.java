/**
 * A Checked Exception for a Chess Board Square making sure
 * file is a-h and rank is 1-8. This exception is checked because
 * an invalid square should be checked at compile time for "user input"
 *
 * @author jzhan30
 * @version 2.0
 */
public class InvalidSquareException extends RuntimeException {
    /**
    * Creates a new Invalid Square Exception returning the invalid square
    * @param msg string representation that is causing the exception
    */
    public InvalidSquareException(String msg) {
      super(msg);
    }

}
