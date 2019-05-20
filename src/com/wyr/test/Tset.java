package com.wyr.test;

import java.util.List;

import com.wyr.daoimpl.UserDaoImpl;
import com.wyr.pojo.UserEntity;

public class Tset {
	static UserDaoImpl udi=new UserDaoImpl();

public static void main(String[] args) {
		List<UserEntity> list=udi.select(null);
		System.out.println("集合装了："+list.size()+"对象");
		
		//打印对象集合
		for(UserEntity u:list){
			System.out.println(u.getUid()+" "+u.getUname()+" "+u.getUsex());
		}
		//对不起，我是一段测试的代码！
		
	}

}
