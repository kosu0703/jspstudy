package com.ict.model.guestbook2;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.guestbook2.GuestBook2DAO;
import com.ict.db.guestbook2.GuestBook2VO;

public class ListCommand implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		List<GuestBook2VO> list = GuestBook2DAO.getList();
		
		request.setAttribute("list", list);
		
		return "view/guestbook2/list.jsp";
	}
}
