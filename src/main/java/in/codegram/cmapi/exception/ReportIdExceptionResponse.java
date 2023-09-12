package in.codegram.cmapi.exception;

public class ReportIdExceptionResponse {

	private String projectIdentifier;

	public ReportIdExceptionResponse(String projectIdentifier) {
		super();
		this.projectIdentifier = projectIdentifier;
	}

	public String getProjectIdentifier() {
		return projectIdentifier;
	}

	public void setProjectIdentifier(String projectIdentifier) {
		this.projectIdentifier = projectIdentifier;
	}
	
	
}
