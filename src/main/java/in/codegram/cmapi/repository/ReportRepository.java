package in.codegram.cmapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.codegram.cmapi.domain.Report;


public interface ReportRepository extends JpaRepository<Report, Long> {
	
//	// Define custom queries here if needed
}
