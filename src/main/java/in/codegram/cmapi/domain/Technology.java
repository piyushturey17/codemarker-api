package in.codegram.cmapi.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
@Entity
public class Technology{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@NotBlank(message="technology name can not be empty")
	private String technologyName;
	@NotBlank(message="technology identifier can not be empty")
	@Size(min=4,max=5,message="technology identifier must be in the range of 4 to 5 character")
	@Column(updatable = false,unique = true)
	private String technologyIdentifier;
	@NotBlank(message="description can not be empty")
	private String description;
	private Date start_date;
	private Date end_date;
	
	private Date technology_created_At;
	private Date technology_updated_At;
	
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

	

	public String getTechnologyIdentifier() {
		return technologyIdentifier;
	}

	public void setTechnologyIdentifier(String technologyIdentifier) {
		this.technologyIdentifier = technologyIdentifier;
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

	
	
	public Date getTechnology_created_At() {
		return technology_created_At;
	}

	public void setTechnology_created_At(Date technology_created_At) {
		this.technology_created_At = technology_created_At;
	}

	public Date getTechnology_updated_At() {
		return technology_updated_At;
	}

	public void setTechnology_updated_At(Date technology_updated_At) {
		this.technology_updated_At = technology_updated_At;
	}

	@PrePersist
	public void onCreate() {
		this.technology_created_At=new Date();
	}
	
	@PreUpdate
	public void onUpdate() {
		this.technology_updated_At=new Date();

	}

	
	

}
