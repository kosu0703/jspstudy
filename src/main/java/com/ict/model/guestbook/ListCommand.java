package com.ict.model.guestbook;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.guestbook.GuestBookDAO;
import com.ict.db.guestbook.GuestBookVO;

public class ListCommand implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		List<GuestBookVO> list = GuestBookDAO.getList();
		request.setAttribute("list", list);
		
		return "view/guestbook/list.jsp";
	}
}
