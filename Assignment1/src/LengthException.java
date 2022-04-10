
/**
 * LengthException Class
 * @author Lokesh Sankar Ramesh
 *
 */

public class LengthException extends RuntimeException {
	public LengthException() {
		super("The password must be at least 6 characters long");
	}
	public LengthException(String message) {
		super(message);
	}
}