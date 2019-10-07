package com.zyw.dao;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBUtils {
	private static SqlSessionFactory factory;
	
	static {//在静态代码块中，factory只会创建一次
		try {
			InputStream is=Resources.getResourceAsStream("mybatis-config.xml");
			factory=new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//获取连接对象
	public static SqlSession createSqlSession() {
		return factory.openSession();
	}
	
	//关闭session
	public static void closeSqlSession(SqlSession sqlSession) {
		if(null!=sqlSession) {
			sqlSession.close();
		}
	}
}
