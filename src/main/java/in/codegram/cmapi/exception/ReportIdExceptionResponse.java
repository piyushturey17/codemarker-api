package in.codegram.cmapi.exception;

public class ReportIdExceptionResponse {

	private String reportIdentifier;
	
	public ReportIdExceptionResponse(String reportIdentifier) {
		super();
		this.reportIdentifier = reportIdentifier;
	}

	public String getReportIdentifier() {
		return reportIdentifier;
	}

	public void setReportIdentifier(String reportIdentifier) {
		this.reportIdentifier = reportIdentifier;
	}
	
	


}
