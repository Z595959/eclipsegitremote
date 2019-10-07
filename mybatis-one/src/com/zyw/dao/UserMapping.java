package com.zyw.dao;

import java.util.List;

import com.zyw.pojo.User;

public interface UserMapping {
	List<User> list();
	int addUser(User u);
	int updateUser(User u);
	int deleteUser(User u);
}
