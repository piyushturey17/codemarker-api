package in.codegram.cmapi.exception;

public class TechnologyIdExceptionResponse {
    private String technologyIdentifier;

	public TechnologyIdExceptionResponse(String projectIdentifier) {
		super();
		this.technologyIdentifier = projectIdentifier;
	}

	
	public String getProjectIdentifier() {
		return technologyIdentifier;
	}

	public void setProjectIdentifier(String projectIdentifier) {
		this.technologyIdentifier = projectIdentifier;
	}
    
}
