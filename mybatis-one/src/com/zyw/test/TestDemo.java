package com.zyw.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import com.zyw.dao.DBUtils;
import com.zyw.dao.UserMapping;
import com.zyw.pojo.User;

public class TestDemo {
	private static DBUtils d;
	public SqlSession gongxiang() {
		String resources = "mybatis-config.xml";
		//2、将资源以输入流的方式加载到系统
		try {
			InputStream is = Resources.getResourceAsStream(resources);
			//3、SqlSessionFactory的构建
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
			
			//4、得到SqlSession
			SqlSession session = factory.openSession();
			return session;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//@Test
	public void findUser() {
		//1、mybatis-config.xml资源位置
		//String resources = "mybatis-config.xml";
		
		//2、将资源以输入流的方式加载到系统
		try {
			//InputStream is = Resources.getResourceAsStream(resources);
			//3、SqlSessionFactory的构建
			//SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
			//4、得到SqlSession
			//SqlSession session = factory.openSession();
			SqlSession session= gongxiang();
			//5、执行操作
			List<User> list = session.selectList("com.zyw.dao.UserMapping.findUser");
			for(User u:list) {
				System.out.println(u);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void findAll() {
		
		//资源定位
		String resources = "mybatis-config.xml";
		try {
			InputStream is = Resources.getResourceAsStream(resources);
			SqlSessionFactory sqlSession = new SqlSessionFactoryBuilder().build(is);
			SqlSession session = sqlSession.openSession();
			//List<User> list = session.selectList("com.zyw.dao.UserMapping.findAll");
			List<User> list = session.getMapper(UserMapping.class).list();
			//List<User> list = (List<User>) d.createSqlSession();
			for(User u:list) {
				System.out.println(u.toString());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void addUser() {
		SqlSession session = gongxiang();
		User u = new User();
		u.setUser_name("我喜欢你");
		u.setUser_password("132131");
		u.setUser_age("32");
		u.setUser_home("wr");
		u.setUser_phone("2432432");
		int result = session.insert("com.zyw.dao.UserMapping.addUser",u);
		if(result>0) {
			System.out.println("恭喜你添加学生成功");
		}
		session.commit();
	}
	@Test
	public void deleteUser() {
		SqlSession session = gongxiang();
		int rows=session.delete("com.zyw.dao.UserMapping.deleteUser",40);
		if(rows>0) {
			System.out.println("恭喜你删除学生成功");
		}
		session.commit();
	}
	@Test
	public void updateUser() {
		SqlSession session = gongxiang();
		User u = new User();
		u.setUser_name("我喜欢你mm");
		u.setUser_password("132131");
		u.setUser_home("jsld");
		u.setUser_age("r3w");
		u.setUser_phone("uojcd");
		u.setUserid(26);
		int result = session.update("com.zyw.dao.UserMapping.updateUser",u);
		if(result>0) {
			System.out.println("恭喜你修改学生成功");
		}
		session.commit();
	}	
}
