package in.codegram.cmapi.service;

import java.util.List;
import java.util.Optional;

import in.codegram.cmapi.domain.Report;



public interface ReportService {
	List<Report> getAllStudents();

	Optional<Report> getStudentById(Long id);

	Report createStudent(Report student);

	Report updateStudent(Long id, Report updatedStudent);

	void deleteStudent(Long id);
}
