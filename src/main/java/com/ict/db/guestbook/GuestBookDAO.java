package com.ict.db.guestbook;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class GuestBookDAO {
	private static SqlSession ss;
	
	private synchronized static SqlSession getSession() {
		if (ss == null) {
			ss = GuestBookDBService.getFactory().openSession();
		}
		return ss;
	}
	
	public static List<GuestBookVO> getList() {
		List<GuestBookVO> list = null;
		list = getSession().selectList("guestbook.list");
		return list;
	}
	
	public static int getInsert(GuestBookVO gvo) {
		int result = 0;
		result = getSession().insert("guestbook.insert", gvo);
		ss.commit();
		return result;
	}
	
	public static GuestBookVO getDetail(String idx) {
		GuestBookVO gvo = null;
		gvo = getSession().selectOne("guestbook.detail", idx);
		return gvo;
	}
	
	public static int getDelete(String idx) {
		int result = 0;
		result = getSession().delete("guestbook.delete", idx);
		ss.commit();
		return result;
	}
	
	public static int getUpdate(GuestBookVO gvo){
		int result = 0;
		result = getSession().update("guestbook.update", gvo);
		ss.commit();
		return result;
	}
	
}
