package com.scm.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.scm.dao.AnnouncementsDAO;
import com.scm.dao.impl.DAOFactory;
import com.scm.model.Announcement;

public class NewsNavServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AnnouncementsDAO announcementsDAO = DAOFactory.createAnnouncementsDAOInstance();

		String currentPageStr = request.getParameter("page");
		Integer currentPage;
		Integer firstResult;
		if (currentPageStr == null) {
			currentPage = 1;
			firstResult = 0;
		} else {
			currentPage = Integer.parseInt(currentPageStr);
			firstResult = (currentPage - 1) * 10;
		}

		Integer pageCount = announcementsDAO.getPageCount(10, 8, currentPage);

		List<Announcement> announcements = announcementsDAO.findAnnouncementsPaginated(firstResult, 10);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("announcements", announcements);
		request.getRequestDispatcher("/WEB-INF/pages/news.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
