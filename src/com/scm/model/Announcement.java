package com.scm.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Id;
import javax.persistence.Persistence;
import javax.persistence.Table;
import javax.persistence.TypedQuery;

@Entity
@Table(name = "ANNOUNCEMENTS")
public class Announcement implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	private Long id;

	@Column(name = "BODY")
	private String body;

	@Column(name = "TITLE")
	private String title;

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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("LLScoutMaster");
		EntityManager em = emf.createEntityManager();

		TypedQuery<Announcement> query = em.createQuery("SELECT o FROM Announcement o", Announcement.class);
		List<Announcement> results = query.getResultList();

		for (Announcement oneResult : results) {
			System.out.println("RESULT ID: " + oneResult.getId());
		}
	}
}
