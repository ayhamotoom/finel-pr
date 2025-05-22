package com.myproect.games.entities;

import jakarta.persistence.*;

import java.util.Arrays;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "GM_GAMES")
public class GmGame {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long gameId;

	private String name;
	@Column(name = "DESCRIPTION")
	private String description;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date releaseDate;

	private Long category;
	private Long studio;

	@Lob
	private byte[] imager;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdDate;

	private String createdBy;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedDate;

	private String updatedBy;

	public GmGame() {
		super();
	}

	public GmGame(Long gameId, String name, String description, Date releaseDate, Long category, Long studio,
			byte[] imager, Date createdDate, String createdBy, Date updatedDate, String updatedBy) {
		super();
		this.gameId = gameId;
		this.name = name;
		this.description = description;
		this.releaseDate = releaseDate;
		this.category = category;
		this.studio = studio;
		this.imager = imager;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.updatedDate = updatedDate;
		this.updatedBy = updatedBy;
	}

	public Long getGameId() {
		return gameId;
	}

	public void setGameId(Long gameId) {
		this.gameId = gameId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
	    return description;
	}

	public void setDescription(String description) {
	    this.description = description;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Long getCategory() {
		return category;
	}

	public void setCategory(Long category) {
		this.category = category;
	}

	public Long getStudio() {
		return studio;
	}

	public void setStudio(Long studio) {
		this.studio = studio;
	}

	public byte[] getImager() {
		return imager;
	}

	public void setImager(byte[] imager) {
		this.imager = imager;
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
		return "GmGame [gameId=" + gameId + ", name=" + name + ", description=" + description + ", releaseDate="
				+ releaseDate + ", category=" + category + ", studio=" + studio + ", imager=" + Arrays.toString(imager)
				+ ", createdDate=" + createdDate + ", createdBy=" + createdBy + ", updatedDate=" + updatedDate
				+ ", updatedBy=" + updatedBy + "]";
	}

}
