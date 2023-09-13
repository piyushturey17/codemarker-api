package in.codegram.cmapi.exception;

public class ReportIdExceptionResponse {

	private String reportIdentifier;

	public ReportIdExceptionResponse(String projectIdentifier) {
		super();
		this.reportIdentifier = projectIdentifier;
	}

	public String getProjectIdentifier() {
		return reportIdentifier;
	}

	public void setProjectIdentifier(String projectIdentifier) {
		this.reportIdentifier = projectIdentifier;
	}
	
	
}
