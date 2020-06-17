package com.touchcode.bugtrackersystem.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "bug_log")
public class BugLog {

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBugId() {
		return bugId;
	}

	public void setBugId(int bugId) {
		this.bugId = bugId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "bug_id")
	private int bugId;
	@Column(name = "description")
	private String description;
	@Column(name = "category")
	private String category;
	@Column(name = "addedby")
	private String addedBy;
	@Column(name = "status")
	private String status;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date")
	private Date date;

	public void saveBug(Bugs theBug) {
		// TODO Auto-generated method stub
		this.bugId = theBug.getId();
		this.category = theBug.getCategory();
		this.date = theBug.getDate();
		this.description = theBug.getDescription();
		this.addedBy = theBug.getAddedBy();
		this.status = theBug.getStatus();
	}

	public Bugs givemeBug(BugLog buglog) {
		return new Bugs(buglog.getBugId(), buglog.getCategory(), buglog.getDescription(), buglog.getDate(),
				buglog.getAddedBy(), buglog.getStatus());

	}

	public String getAddedBy() {
		return addedBy;
	}

	public void setAddedBy(String addedBy) {
		this.addedBy = addedBy;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
