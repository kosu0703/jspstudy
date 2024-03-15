package com.ict.controller.guestbook2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.model.guestbook2.Command;
import com.ict.model.guestbook2.ListCommand;


@WebServlet("/GuestBook2")
public class GuestBook2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String cmd = request.getParameter("cmd");
		
		Command comm = null;
		
		switch (cmd) {
		case "list": comm = new ListCommand(); break;
			
		}
		
		String path = comm.exec(request, response);
		request.getRequestDispatcher(path).forward(request, response);
		
	}


}
