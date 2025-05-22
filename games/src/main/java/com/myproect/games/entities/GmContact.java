package com.myproect.games.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "GM_CONTACT")
public class GmContact {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long contactId;

	private String name;
	private String email;
	private String subject;
	private String message;

	@Temporal(TemporalType.DATE)
	private Date createdDate;

	private String createdBy;

	@Temporal(TemporalType.DATE)
	private Date updatedDate;

	private String updatedBy;

	public GmContact() {
		super();
	}

	public GmContact(Long contactId, String name, String email, String subject, String message, Date createdDate,
			String createdBy, Date updatedDate, String updatedBy) {
		super();
		this.contactId = contactId;
		this.name = name;
		this.email = email;
		this.subject = subject;
		this.message = message;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.updatedDate = updatedDate;
		this.updatedBy = updatedBy;
	}

	public Long getContactId() {
		return contactId;
	}

	public void setContactId(Long contactId) {
		this.contactId = contactId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Override
	public String toString() {
		return "GmContact [contactId=" + contactId + ", name=" + name + ", email=" + email + ", subject=" + subject
				+ ", message=" + message + ", createdDate=" + createdDate + ", createdBy=" + createdBy
				+ ", updatedDate=" + updatedDate + ", updatedBy=" + updatedBy + "]";
	}

}
