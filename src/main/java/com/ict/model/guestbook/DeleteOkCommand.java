package com.ict.model.guestbook;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.guestbook.GuestBookDAO;

public class DeleteOkCommand implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		String idx = request.getParameter("idx");
		
		int result = GuestBookDAO.getDelete(idx);
		
		if (result > 0) {
			return "GuestBook?cmd=list";
		}else {
			return "view/guestbook/error.jsp";
		}
		
	}
}
