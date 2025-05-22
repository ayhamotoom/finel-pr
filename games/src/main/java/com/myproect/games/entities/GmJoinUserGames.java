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
@Table(name = "GM_JOIN_USER_GAMES")

public class GmJoinUserGames {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long joinId;

	private Long userId;
	private Long gameId;

	private String createdBy;

	@Temporal(TemporalType.DATE)
	private Date createdDate;

	private String updatedBy;

	@Temporal(TemporalType.DATE)
	private Date updatedDate;

	public GmJoinUserGames() {
		super();
	}

	public GmJoinUserGames(Long joinId, Long userId, Long gameId, String createdBy, Date createdDate, String updatedBy,
			Date updatedDate) {
		super();
		this.joinId = joinId;
		this.userId = userId;
		this.gameId = gameId;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
	}

	public Long getJoinId() {
		return joinId;
	}

	public void setJoinId(Long joinId) {
		this.joinId = joinId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getGameId() {
		return gameId;
	}

	public void setGameId(Long gameId) {
		this.gameId = gameId;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Override
	public String toString() {
		return "GmJoinUserGames [joinId=" + joinId + ", userId=" + userId + ", gameId=" + gameId + ", createdBy="
				+ createdBy + ", createdDate=" + createdDate + ", updatedBy=" + updatedBy + ", updatedDate="
				+ updatedDate + "]";
	}

}
