package com.zyw.test;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

import com.zyw.dao.DBUtils;
import com.zyw.pojo.User;

public class UserMapperTest {
	//创建一个日志对象
	private Logger logger =Logger.getLogger(TestDemo.class);
	
	//测试获取表中总的数据条数
	@Test
	public void cesicount() {
		String resources = "mybatis-config.xml";
		int count = 0;
		//1.创建SqlSession
		SqlSession session = DBUtils.createSqlSession();
		
		//4、调用mapper文件来对数据进行操作，必须把mapper.xml文件引入mybatis-config.xml
		//count = session.selectOne("com.zyw.dao.UserMapping.findUser");
		Map<User,String> map = session.selectMap("com.zyw.dao.UserMapping.getUserByParams", "我");
		for(User o:map.keySet()) {
			System.out.println(o.toString());
		}
		logger.debug("UserMapping--Testcount:"+map);
		/*
		 * logger.error("错误信息");
		 * logger.info("消息");
		 * logger.warn("警告信息")
		 */
	}
}
