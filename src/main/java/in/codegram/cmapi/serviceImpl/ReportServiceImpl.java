package in.codegram.cmapi.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.codegram.cmapi.domain.Report;
import in.codegram.cmapi.exception.ReportIdException;
import in.codegram.cmapi.repository.ReportRepository;
import in.codegram.cmapi.service.ReportService;

@Service
public class ReportServiceImpl implements ReportService {

	@Autowired
	private ReportRepository reportRepository;

	@Override
	public Report saveOrUpdate(Report report) {
		try {

			return reportRepository.save(report);

		} catch (Exception ex) {
			// handling logic -- rethrow exception to sent till UI layer
			throw new ReportIdException("Report Id : " + report.getReportIdentifier() + " already exist");
		}
	}

	@Override
	public Iterable<Report> findAllReports() {
		return reportRepository.findAll();
	}

	@Override
	public void delete(String reportId) {
		Report report = reportRepository.findByReportIdentifier(reportId);
		reportRepository.delete(report);

	}

	@Override
	public Report findReportByReportIdentifier(String reportIdentifier) {
		Report report = reportRepository.findByReportIdentifier(reportIdentifier);
		if (report == null) {
			throw new ReportIdException("Test Id :" + reportIdentifier + "does not exist");
		}
		return report;
	}

}
