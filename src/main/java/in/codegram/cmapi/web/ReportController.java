package in.codegram.cmapi.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import in.codegram.cmapi.domain.Report;
import in.codegram.cmapi.service.ReportService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

@RestController
@RequestMapping("/reports")
public class ReportController {
    private final ReportService studentService;

    @Autowired
    public ReportController(ReportService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/all")
    public List<Report> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Report> getStudentById(@PathVariable Long id) {
        Optional<Report> student = studentService.getStudentById(id);
        if (student.isPresent()) {
            return ResponseEntity.ok(student.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("")
    public ResponseEntity<?> createStudent(@Valid @RequestBody Report student, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> validationErrors = new HashMap<>();
            for (FieldError error : result.getFieldErrors()) {
                validationErrors.put(error.getField(), error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(validationErrors);
        } else {
            try {
                Report createdStudent = studentService.createStudent(student);
                return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
            } catch (DataIntegrityViolationException e) {
                // Handle the database constraint violation and return a custom error message
                Map<String, String> errorResponse = new HashMap<>();
                errorResponse.put("reportIdentifier", "Duplicate reportIdentifier not allowed.");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
            }
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<Report> updateStudent(@PathVariable Long id, @RequestBody Report updatedStudent) {
        Report student = studentService.updateStudent(id, updatedStudent);
        if (student != null) {
            return ResponseEntity.ok(student);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }
}




/*
 *     @PostMapping("")
    public ResponseEntity<?> createStudent(@Valid @RequestBody Report student, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> validationErrors = new HashMap<>();
            for (FieldError error : result.getFieldErrors()) {
                validationErrors.put(error.getField(), error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(validationErrors);
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createStudent(student));
        }
    }
 */
