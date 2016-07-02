package com.scm.servlets;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.scm.dao.impl.DAOFactory;

public class ImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String imgIdString = request.getParameter("id");
		if (imgIdString != null) {
			Long imgId = Long.parseLong(imgIdString);
			byte[] imgBytes = DAOFactory.createAnnouncementsDAOInstance().findImgById(imgId);
			if (imgBytes != null) {
				response.setContentType("image/png");

				OutputStream out = response.getOutputStream();
				out.write(imgBytes);
			}
		}
	}
}
