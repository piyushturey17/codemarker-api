package in.codegram.cmapi.web;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.codegram.cmapi.domain.Report;
import in.codegram.cmapi.service.ReportService;

@RestController
@RequestMapping("api/reports")
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
    public Report createStudent(@Valid @RequestBody Report student) {
    	
        return studentService.createStudent(student);
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


/**
 *  @PostMapping("/")
    public Student createStudent(@Valid @RequestBody Student student , BindingResult bindingResult) {
    	
        return studentService.createStudent(student);
    }
 */

