package com.ssafy.hw.step2.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.hw.step2.dto.User;

public interface UserDao {

	List<User> selectAllUsers() throws SQLException; 
	
	boolean insertUser(User user)throws SQLException;
	
	int userCount() throws SQLException;
	
}
