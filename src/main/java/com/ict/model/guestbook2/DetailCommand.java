package com.ict.model.guestbook2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.guestbook2.GuestBook2DAO;
import com.ict.db.guestbook2.GuestBook2VO;

public class DetailCommand implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		String idx = request.getParameter("idx");
		
		GuestBook2VO g2vo = GuestBook2DAO.getDetail(idx);
		
		if (g2vo != null) {
			request.setAttribute("g2vo", g2vo);
			return "view/guestbook2/detail.jsp";
		}else {
			return "view/guestboo2/error.jsp";
		}
		
	}
}
