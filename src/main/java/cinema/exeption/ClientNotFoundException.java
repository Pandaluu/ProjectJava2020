package cinema.exeption;

public class ClientNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public ClientNotFoundException() {
	}

	public ClientNotFoundException(String msg) {
		super(msg);
	}

}
