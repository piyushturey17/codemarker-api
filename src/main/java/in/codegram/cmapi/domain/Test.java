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
public class Test {
	
	//This is to check git
	//This is to check from git to sts
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message= "testName is required")
	private String testName;
	
	@NotBlank(message="test identifier cannot be empty")
	@Size(min=4, max=12,message="test identifier must be in the range of 4 to 12 character")
	@Column(updatable = false, unique =true)
	private String testIdentifier;
	@NotBlank(message= "description is required")
	private String testdescription;
	private Date test_start_date;
	private Date test_end_date;
	private Date test_created_At;
	private Date test_updated_At;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	public String getTestdescription() {
		return testdescription;
	}
	public void setTestdescription(String testdescription) {
		this.testdescription = testdescription;
	}
	public Date getTest_start_date() {
		return test_start_date;
	}
	public void setTest_start_date(Date test_start_date) {
		this.test_start_date = test_start_date;
	}
	public Date getTest_end_date() {
		return test_end_date;
	}
	public void setTest_end_date(Date test_end_date) {
		this.test_end_date = test_end_date;
	}
	public Date getTest_created_At() {
		return test_created_At;
	}
	public void setTest_created_At(Date test_created_At) {
		this.test_created_At = test_created_At;
	}
	public Date getTest_updated_At() {
		return test_updated_At;
	}
	public void setTest_updated_At(Date test_updated_At) {
		this.test_updated_At = test_updated_At;
	}
	
	
	
	public String getTestIdentifier() {
		return testIdentifier;
	}
	public void setTestIdentifier(String testIdentifier) {
		this.testIdentifier = testIdentifier;
	}
	@PrePersist
	public void onCreate() {
		this.test_created_At = new Date();
	}

	@PreUpdate
	public void onUpdate() {
		this.test_updated_At = new Date();
	}
}
