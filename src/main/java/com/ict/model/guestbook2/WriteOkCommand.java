package com.ict.model.guestbook2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.guestbook2.GuestBook2DAO;
import com.ict.db.guestbook2.GuestBook2VO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class WriteOkCommand implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		try {
			String path = request.getServletContext().getRealPath("upload");
			
			MultipartRequest mr = 
					new MultipartRequest(request, path, 100*1024*1024, "utf-8",
							new DefaultFileRenamePolicy());
			
			GuestBook2VO g2vo = new GuestBook2VO();
			g2vo.setName(mr.getParameter("name"));
			g2vo.setSubject(mr.getParameter("subject"));
			g2vo.setEmail(mr.getParameter("email"));
			g2vo.setPwd(mr.getParameter("pwd"));
			g2vo.setContent(mr.getParameter("content"));
			
			//	파일은 f_name 으로 가져와서 값이 있으면, 시스템에서 설정한 파일명으로 넣어주자
			//	똑같은 파일명일 경우 뒤에 숫자가 붙어서 저장되기 때문에
			if (mr.getFile("f_name") != null) {
				g2vo.setF_name(mr.getFilesystemName("f_name"));
			}else {
				g2vo.setF_name("");
			}
			
			int result = GuestBook2DAO.getInsert(g2vo);
			
			if (result > 0) {
				return "GuestBook2?cmd=list";
			}
			return "view/guestbook2/error.jsp";
		} catch (Exception e) {
			System.out.println(e);
			return "view/guestbook2/error.jsp";
		}
		
	}
}
