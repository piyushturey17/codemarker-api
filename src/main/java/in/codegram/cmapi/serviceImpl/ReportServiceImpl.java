package in.codegram.cmapi.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.codegram.cmapi.domain.Report;
import in.codegram.cmapi.repository.ReportRepository;
import in.codegram.cmapi.service.ReportService;

import java.util.List;
import java.util.Optional;

@Service
public class ReportServiceImpl implements ReportService {
    private final ReportRepository studentRepository;

    @Autowired
    public ReportServiceImpl(ReportRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Report> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Report> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public Report createStudent(Report student) {
        return studentRepository.save(student);
    }

    @Override
    public Report updateStudent(Long id, Report updatedStudent) {
        if (studentRepository.existsById(id)) {
            updatedStudent.setId(id);
            return studentRepository.save(updatedStudent);
        }
        return null; // Handle error appropriately
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}