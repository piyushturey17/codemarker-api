package in.codegram.cmapi.web;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.codegram.cmapi.domain.Technology;
import in.codegram.cmapi.service.MapValidationErrorService;
import in.codegram.cmapi.service.TechnologyService;


@RestController
@RequestMapping("/api/technologies")
public class TechnologyController {
	
	@Autowired
	private TechnologyService technologyService;
	
	@Autowired
	private MapValidationErrorService mapValidationErrorService;
	@PostMapping("")
	public ResponseEntity<?> createNewProject(@Valid @RequestBody Technology technology,BindingResult result)
	{
	    ResponseEntity<?> errorMap=mapValidationErrorService.mapValidationError(result);
	    if(errorMap!=null) {
	    	return errorMap;
	    }
		Technology proj=technologyService.saveOrUpdate(technology);
		return new ResponseEntity<Technology>(proj,HttpStatus.CREATED);
	}
	@GetMapping("/all")
    public Iterable<Technology>getAllTechnology(){
    	return technologyService.findAllTechnology();
    }
	
	@DeleteMapping("/{technologyId}")
	    public ResponseEntity<?>removeProject(@PathVariable String technologyId) {
		technologyService.delete(technologyId);
		return new ResponseEntity<String>("Technology Deleted Successfully",HttpStatus.OK);
	}
}

