package com.ict.model.guestbook;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.guestbook.GuestBookDAO;
import com.ict.db.guestbook.GuestBookVO;

public class WriteOkCommand implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		try {
			GuestBookVO gvo = new GuestBookVO();
			gvo.setName(request.getParameter("name"));
			gvo.setSubject(request.getParameter("subject"));
			gvo.setEmail(request.getParameter("email"));
			gvo.setPwd(request.getParameter("pwd"));
			gvo.setContent(request.getParameter("content"));
			
			int result = GuestBookDAO.getInsert(gvo);
			if (result > 0) {
				return "GuestBook?cmd=list";
			}
			return "view/guestbook/error.jsp";
		} catch (Exception e) {
			System.out.println(e);
			return "view/guestbook/error.jsp";
		}
		
		
	}
}
