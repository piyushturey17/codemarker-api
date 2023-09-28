package in.codegram.cmapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.codegram.cmapi.domain.Report;
;

@Repository
public interface ReportRepository  extends CrudRepository<Report, Long>{
	
	Report findByReportIdentifier(String reportId);
}
