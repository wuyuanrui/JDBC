package com.wyr.dao;

import java.util.List;

import com.wyr.pojo.UserEntity;

public interface UserDao  {
	int add(UserEntity user);
	int delete(int uid);
	int update(UserEntity user);
	List select(Object obj);

}
