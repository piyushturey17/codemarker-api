package in.codegram.cmapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BatchIdException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * THis will create ProjectIDException object without error message
	 */
	public BatchIdException() {
		super();
	}

	/**
	 * THis will create ProjectIDException object with error message
	 */
	
	public BatchIdException(String errMsg) {
		super(errMsg);
	}
}
