package in.codegram.cmapi.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import in.codegram.cmapi.domain.Batch;
import in.codegram.cmapi.service.MapValidationErrorService;
import in.codegram.cmapi.service.BatchService;
@RestController
@RequestMapping("/api/Batch")
public class BatchController {

	@Autowired
	private BatchService BatchService;
	
	@Autowired
	private MapValidationErrorService mapValidationErrorService;
	
	@PostMapping("")
	public ResponseEntity<?> createNewBatch(@Valid @RequestBody Batch batch  ,BindingResult result){
		
		ResponseEntity<?> errorMap=mapValidationErrorService.mapValidationError(result);
		if (errorMap!=null) {
			return errorMap;
		}
		
		Batch proj=BatchService.saveOrUpdate(batch);
		return new ResponseEntity<Batch>(proj,HttpStatus.CREATED);
	}

	@GetMapping("/all")
	public Iterable<Batch> getAllBatch(){
		return BatchService.findAllBatch();
	}


	@DeleteMapping("/{BatchID}")
	public ResponseEntity<?> removeProject(@PathVariable String BatchID) {
		BatchService.delete(BatchID);
		return new ResponseEntity<String>("Batch Deleted Sucessfully",HttpStatus.OK);
	}

































}