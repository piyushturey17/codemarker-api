package in.codegram.cmapi.service;

import in.codegram.cmapi.domain.Report;

public interface ReportService {

	public Report saveOrUpdate(Report report);

	Iterable<Report> findAllReports();

	void delete(String reportId);
	Report findReportByReportIdentifier(String reportIdentifier);
}
