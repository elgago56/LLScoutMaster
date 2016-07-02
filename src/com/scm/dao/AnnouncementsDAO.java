package com.scm.dao;

import java.util.List;

import com.scm.model.Announcement;

public interface AnnouncementsDAO {
	public Integer getPageCount(Integer pageSize, Integer maxNumOfPages, Integer currentPage);

	public List<Announcement> findAnnouncementsPaginated(Integer firstResult, Integer maxResults);

	public byte[] findImgById(Long imgId);
}
