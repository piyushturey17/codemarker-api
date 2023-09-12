package in.codegram.cmapi.exception;

public class ProjectIdExceptionResponse {
	private String projectIdentifier;

	/**
	 * @param projectIdentifier
	 */
	public ProjectIdExceptionResponse(String projectIdentifier) {
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
