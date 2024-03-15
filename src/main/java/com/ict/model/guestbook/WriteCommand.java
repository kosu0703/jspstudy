package com.ict.model.guestbook;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WriteCommand implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {

		return "view/guestbook/write.jsp";
	}
}
