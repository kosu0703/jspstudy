package com.ict.db.guestbook2;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class GuestBook2DAO {
	private static SqlSession ss;
	
	private synchronized static SqlSession getSession() {
		if (ss == null) {
			ss = GuestBook2DBService.getFactory().openSession();
		}
		return ss;
	}
	
	public static List<GuestBook2VO> getList(){
		List<GuestBook2VO> list = null;
		list = getSession().selectList("guestbook2.list");
		return list;
	}
	
	public static int getInsert(GuestBook2VO g2vo){
		int result = 0;
		result = getSession().insert("guestbook2.insert", g2vo);
		ss.commit();
		return result;
	}
	
	public static GuestBook2VO getDetail(String idx){
		GuestBook2VO g2vo = null;
		g2vo = getSession().selectOne("guestbook2.detail", idx);
		return g2vo;
	}
	
}
