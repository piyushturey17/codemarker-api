package in.codegram.cmapi.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.codegram.cmapi.domain.Report;
import in.codegram.cmapi.domain.Test;
import in.codegram.cmapi.service.MapValidationErrorService;
import in.codegram.cmapi.service.ReportService;

@RestController
@RequestMapping("/api/reports")
@CrossOrigin
public class ReportController {

	@Autowired
	private ReportService reportService;

	@Autowired
	private MapValidationErrorService mapValidationErrorService;

	@PostMapping("")
	public ResponseEntity<?> createNewReport(@Valid @RequestBody Report report, BindingResult result) {
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if (errorMap != null) {
			return errorMap;
		}

		Report report_save = reportService.saveOrUpdate(report);
		return new ResponseEntity<Report>(report_save, HttpStatus.CREATED);
	}

	@GetMapping("/all")
	public Iterable<Report> getAllReports() {
		return reportService.findAllReports();

	}

	@DeleteMapping("/{reportId}")
	public ResponseEntity<?> removeReport(@PathVariable String reportId) {
		reportService.delete(reportId);
		return new ResponseEntity<String>("Report Deleted Successfully", HttpStatus.OK);
	}

	@GetMapping("/{reportIdentifier}")
	public ResponseEntity<?> getReportById(@PathVariable String reportIdentifier) {
		Report report = reportService.findReportByReportIdentifier(reportIdentifier);
		return new ResponseEntity<Report>(report, HttpStatus.OK);
	}

}
