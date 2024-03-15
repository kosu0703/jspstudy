package com.ict.model.guestbook;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.guestbook.GuestBookDAO;
import com.ict.db.guestbook.GuestBookVO;

public class UpdateOkCommand implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		String idx = request.getParameter("idx");
		
		GuestBookVO gvo = new GuestBookVO();
		gvo.setIdx(idx);
		gvo.setName(request.getParameter("name"));
		gvo.setSubject(request.getParameter("subject"));
		gvo.setEmail(request.getParameter("email"));
		gvo.setContent(request.getParameter("content"));
		
		int result = GuestBookDAO.getUpdate(gvo);
		
		if (result > 0) {
			return "GuestBook?cmd=detail&idx="+idx;
		}else {
			return "view/guestbook/error.jsp";
		}
		
	}
}
