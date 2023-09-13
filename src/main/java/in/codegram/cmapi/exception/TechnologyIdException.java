package in.codegram.cmapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TechnologyIdException extends RuntimeException {
	
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		/**
		 * this will create ProjectIDException object without error message 
		 */
		
		public TechnologyIdException() {
			super();
		}
		/**
		 * 
		 *this will create ProjectIdException object with error message
		 */
		public TechnologyIdException(String errMsg) {
			super(errMsg);
			
		}
	}

