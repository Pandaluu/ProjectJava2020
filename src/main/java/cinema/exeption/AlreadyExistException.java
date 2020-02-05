package cinema.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
public class AlreadyExistException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public AlreadyExistException() {
	}

	public AlreadyExistException(String msg) {
		super(msg);
	}

}