package com.ict.db.guestbook;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class GuestBookDBService {
	static private SqlSessionFactory factory;
	static String resource = "com/ict/db/guestbook/guestbook_config.xml";
	
	static {
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static SqlSessionFactory getFactory() {
		return factory;
	}
	
}
