package com.scm.dao.impl;

import com.scm.dao.AnnouncementsDAO;

public class DAOFactory {
	private DAOFactory() {
	}

	public static AnnouncementsDAO createAnnouncementsDAOInstance() {
		return new AnnouncementsDAOImpl();
	}

	public static AnnouncementsDAO createSpringAnnouncementsDAOInstance() {
		return new AnnouncementsDAOImpl();
	}
}
