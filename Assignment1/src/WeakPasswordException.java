
public class WeakPasswordException extends RuntimeException {
	public WeakPasswordException() {
		super("The password is fine, but it's weak as it is below 10 characters.");
	}
	
	public WeakPasswordException(String message) {
		super(message);
	}
}
