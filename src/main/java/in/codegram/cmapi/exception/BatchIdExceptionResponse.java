package in.codegram.cmapi.exception;

public class BatchIdExceptionResponse {

	private String batchIdentifier;

	public BatchIdExceptionResponse(String batchIdentifier) {
		super();
		this.batchIdentifier = batchIdentifier;
	}

	public String getBatchIdentifier() {
		return batchIdentifier;
	}

	public void setBatchIdentifier(String batchIdentifier) {
		this.batchIdentifier = batchIdentifier;
	}
	
	
}
