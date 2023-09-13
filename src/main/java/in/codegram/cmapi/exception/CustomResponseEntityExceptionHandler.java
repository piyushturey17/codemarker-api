package in.codegram.cmapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	@ExceptionHandler
	public final ResponseEntity<Object> handleProjectIdException(TestIdException ex,WebRequest request){
		
		TestIdExceptionResponse exceptionResponse = new TestIdExceptionResponse(ex.getMessage());
		return new ResponseEntity<Object>(exceptionResponse,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler
	public final ResponseEntity<Object> handleProjectIdException(ReportIdException ex, WebRequest request){
		ReportIdExceptionResponse exceptionResponse = new ReportIdExceptionResponse(ex.getMessage());
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public final ResponseEntity<Object> handleProjectIdException(TechnologyIdException ex, WebRequest request){
		TechnologyIdExceptionResponse exceptionResponse=new TechnologyIdExceptionResponse(ex.getMessage());
		return new ResponseEntity<Object>(exceptionResponse,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public final ResponseEntity<Object> handleProjectIdException(BatchIdException ex,WebRequest request){
	BatchIdExceptionResponse exceptionResponse=new BatchIdExceptionResponse(ex.getMessage());
	 
		return new ResponseEntity<Object>(exceptionResponse,HttpStatus.BAD_REQUEST);
}
	
	
	
}


	
	

