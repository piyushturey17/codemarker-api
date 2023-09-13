package in.codegram.cmapi.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

//push
@Entity
public class Batch {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message="Batch name cannot be empty ")
	private String batchName;
	@NotBlank(message="batch Identifier cannot be empty ")
	@Size(min = 4, max = 5, message = "batch Identifier Must Be in 4 to 5 character")
	@Column(updatable = false,unique = true)
	private String batchIdentifier;
	@NotBlank(message="description cannot be empty ")
	private String description; 
	private	Date batch_start_date; 
	private Date batch_end_date;
	private Date Batch_created_At;
	private Date Batch_updated_At;
	
	

	public Batch() {
		
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public String getBatchIdentifier() {
		return batchIdentifier;
	}

	public void setBatchIdentifier(String batchIdentifier) {
		this.batchIdentifier = batchIdentifier;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getBatch_start_date() {
		return batch_start_date;
	}

	public void setBatch_start_date(Date batch_start_date) {
		this.batch_start_date = batch_start_date;
	}

	public Date getBatch_end_date() {
		return batch_end_date;
	}

	public void setBatch_end_date(Date batch_end_date) {
		this.batch_end_date = batch_end_date;
	}

	public Date getBatch_created_At() {
		return Batch_created_At;
	}

	public void setBatch_created_At(Date Batch_created_At) {
		this.Batch_created_At = Batch_created_At;
	}

	public Date getBatch_updated_At() {
		return Batch_updated_At;
	}

	public void setBatch_updated_At(Date Batch_updated_At) {
		this.Batch_updated_At = Batch_updated_At;
	}

	public Batch(Long id, String batchName, String batchIdentifier, String description, Date batch_start_date,
			Date batch_end_date, Date Batch_created_At, Date Batch_updated_At) {
		super();
		this.id = id;
		this.batchName = batchName;
		this.batchIdentifier = batchIdentifier;
		this.description = description;
		this.batch_start_date = batch_start_date;
		this.batch_end_date = batch_end_date;
		this.Batch_created_At = Batch_created_At;
		this.Batch_updated_At = Batch_updated_At;
	}

	
	@PrePersist 
	public void onCreate() { 
		this.Batch_created_At = new Date();
	}

	@PreUpdate
	public void onUpdate() {
		this.Batch_updated_At = new Date();
	}
	

}
