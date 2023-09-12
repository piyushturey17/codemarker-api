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
@Entity
public class Project {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@NotBlank(message="Technology name cannot be empty ")
	private String technologyName;
	@NotBlank(message="projectIdentifier cannot be empty ")
	@Size(min = 4, max = 5, message = "Project Identifier Must Be in 4 to 5 character")
	@Column(updatable = false,unique = true)
	private String projectIdentifier;
	@NotBlank(message="description cannot be empty ")
	private String description;
	private Date start_date;
	private Date end_date;
	
	private Date batch_created_At;
	private Date batch_updated_At;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTechnologyName() {
		return technologyName;
	}

	public void setTechnologyName(String technologyName) {
		this.technologyName = technologyName;
	}

	public String getProjectIdentifier() {
		return projectIdentifier;
	}

	public void setProjectIdentifier(String projectIdentifier) {
		this.projectIdentifier = projectIdentifier;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public Date getBatch_created_At() {
		return batch_created_At;
	}

	public void setBatch_created_At(Date batch_created_At) {
		this.batch_created_At = batch_created_At;
	}

	public Date getBatch_updated_At() {
		return batch_updated_At;
	}

	public void setBatch_updated_At(Date batch_updated_At) {
		this.batch_updated_At = batch_updated_At;
	}

	
	@PrePersist
	public void onCreate() {
		this.batch_created_At=new Date();
	}
	
	@PreUpdate
	public void onUpdate() {
		this.batch_updated_At=new Date();

	}
	

}
