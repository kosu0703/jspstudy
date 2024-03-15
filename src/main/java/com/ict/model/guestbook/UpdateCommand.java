package com.ict.model.guestbook;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.guestbook.GuestBookDAO;
import com.ict.db.guestbook.GuestBookVO;

public class UpdateCommand implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		String idx = request.getParameter("idx");
		
		GuestBookVO gvo = GuestBookDAO.getDetail(idx);
		
		request.setAttribute("gvo", gvo);
		
		return "view/guestbook/update.jsp";
	}
}
