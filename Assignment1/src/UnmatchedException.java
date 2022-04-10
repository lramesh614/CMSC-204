

public class UnmatchedException extends RuntimeException {
	public UnmatchedException() {
		super("Passwords do not match");
	}
	
	public UnmatchedException(String message) {
		super(message);
	}
}