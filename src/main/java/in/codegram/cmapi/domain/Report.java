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
public class Report {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "reportName is required")
	private String reportName;

	@NotBlank(message = "report identifier cannot be empty")
	@Size(min = 4, max = 12, message = "report identifier must be in the range of 4 to 12 character")
	@Column(updatable = false, unique = true)
	private String reportIdentifier;

	@NotBlank(message = "Batch name cannot be empty ")
	private String batchName;

	@NotBlank(message = "technology name can not be empty")
	private String technologyName;

	@NotBlank(message = "description is required")
	private String reportdescription;

	private Date report_created_At;
	private Date report_updated_At;

	public String getTechnologyName() {
		return technologyName;
	}

	public void setTechnologyName(String technologyName) {
		this.technologyName = technologyName;
	}

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	public String getReportIdentifier() {
		return reportIdentifier;
	}

	public void setReportIdentifier(String reportIdentifier) {
		this.reportIdentifier = reportIdentifier;
	}

	public String getReportdescription() {
		return reportdescription;
	}

	public void setReportdescription(String reportdescription) {
		this.reportdescription = reportdescription;
	}



	public Date getReport_created_At() {
		return report_created_At;
	}

	public void setReport_created_At(Date report_created_At) {
		this.report_created_At = report_created_At;
	}

	public Date getReport_updated_At() {
		return report_updated_At;
	}

	public void setReport_updated_At(Date report_updated_At) {
		this.report_updated_At = report_updated_At;
	}

	@PrePersist
	public void onCreate() {
		this.report_created_At = new Date();
	}

	@PreUpdate
	public void onUpdate() {
		this.report_updated_At = new Date();
	}

}
