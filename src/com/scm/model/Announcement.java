package com.scm.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "ANNOUNCEMENTS")
@NamedQueries({
		@NamedQuery(name = "findAllAnnouncements", query = "SELECT o FROM Announcement o ORDER BY o.eventDate DESC") })
@NamedNativeQueries({
		@NamedNativeQuery(name = "getAnnouncementPaginationCount", query = "SELECT CASE  "
				+ "WHEN COUNT(results.ID) / ?1 BETWEEN 0 AND 1 THEN 1 ELSE FLOOR( COUNT(results.ID) / ?1) END FROM "
				+ "(SELECT inner_anc.ID, ROWNUM rnum FROM ANNOUNCEMENTS inner_anc WHERE ROWNUM <= ((?1 * ?2) + ?3) ORDER BY inner_anc.EVENT_DATE DESC) results "
				+ "WHERE results.rnum > ?3"),
		@NamedNativeQuery(name = "findImgBlobById", query = "SELECT IMG_BLOB FROM ANNOUNCEMENT_IMG WHERE ID = ?1") })
public class Announcement implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	private Long id;

	@Column(name = "BODY")
	private String body;

	@Column(name = "TITLE")
	private String title;

	@Column(name = "EVENT_DATE")
	private Timestamp eventDate;

	@Column(name = "IMG_PATH")
	private String imgPath;

	@Column(name = "IMG_ID")
	private Long imgId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Long getImgId() {
		return imgId;
	}

	public void setImgId(Long imgId) {
		this.imgId = imgId;
	}

	public Timestamp getEventDate() {
		return eventDate;
	}

	public void setEventDate(Timestamp eventDate) {
		this.eventDate = eventDate;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
