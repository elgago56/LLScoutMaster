package com.scm.dao.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.scm.dao.AnnouncementsDAO;
import com.scm.model.Announcement;

public class AnnouncementsDAOImpl implements AnnouncementsDAO {
	private static final EntityManager em = Persistence.createEntityManagerFactory("LLScoutMaster")
			.createEntityManager();

	AnnouncementsDAOImpl() {

	}

	@Override
	public Integer getPageCount(Integer pageSize, Integer maxNumOfPages, Integer currentPage) {
		Query query = em.createNamedQuery("getAnnouncementPaginationCount");
		query.setParameter(1, pageSize);
		query.setParameter(2, maxNumOfPages);

		Integer middlePage = maxNumOfPages / 2;
		Integer offset = currentPage <= middlePage ? 0 : (currentPage - middlePage) * pageSize;

		query.setParameter(3, offset);

		BigDecimal count = (BigDecimal) query.getSingleResult();
		return count.intValue();
	}

	@Override
	public List<Announcement> findAnnouncementsPaginated(Integer firstResult, Integer maxResults) {
		TypedQuery<Announcement> query = em.createNamedQuery("findAllAnnouncements", Announcement.class);
		query.setFirstResult(firstResult);
		query.setMaxResults(maxResults);

		return query.getResultList();
	}

	@Override
	public byte[] findImgById(Long imgId) {
		Query query = em.createNamedQuery("findImgBlobById");
		query.setParameter(1, imgId);

		try {
			Object result = query.getSingleResult();
			return (byte[]) result;
		} catch (NoResultException e) {
			return null;
		}
	}

}
