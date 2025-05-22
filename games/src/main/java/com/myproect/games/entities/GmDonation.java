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
@Table(name = "GM_DONATION")
public class GmDonation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long donationId;

	private Long userId;
	private Long paymentMethod;
	private Long transactionId;

	@Temporal(TemporalType.DATE)
	private Date createdDate;
	private String createdBy;

	@Temporal(TemporalType.DATE)
	private Date updatedDate;
	private String updatedBy;

	public GmDonation() {
		super();
	}

	public GmDonation(Long donationId, Long userId, Long paymentMethod, Long transactionId, Date createdDate,
			String createdBy, Date updatedDate, String updatedBy) {
		super();
		this.donationId = donationId;
		this.userId = userId;
		this.paymentMethod = paymentMethod;
		this.transactionId = transactionId;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.updatedDate = updatedDate;
		this.updatedBy = updatedBy;
	}

	public Long getDonationId() {
		return donationId;
	}

	public void setDonationId(Long donationId) {
		this.donationId = donationId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(Long paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
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
		return "GmDonation [donationId=" + donationId + ", userId=" + userId + ", paymentMethod=" + paymentMethod
				+ ", transactionId=" + transactionId + ", createdDate=" + createdDate + ", createdBy=" + createdBy
				+ ", updatedDate=" + updatedDate + ", updatedBy=" + updatedBy + "]";
	}

}
