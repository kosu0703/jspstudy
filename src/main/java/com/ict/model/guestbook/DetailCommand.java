package com.ict.model.guestbook;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.guestbook.GuestBookDAO;
import com.ict.db.guestbook.GuestBookVO;

public class DetailCommand implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		String idx = request.getParameter("idx");
		
		GuestBookVO gvo = GuestBookDAO.getDetail(idx);
		
		if (gvo != null) {
			request.setAttribute("gvo", gvo);
			return "view/guestbook/detail.jsp";
		}else {
			return "view/guestbook/error.jsp";
		}
		
	}
}
