package com.wyr.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wyr.dao.UserDao;
import com.wyr.pojo.UserEntity;

public class UserDaoImpl extends BaseDao  implements Serializable,UserDao {
	
	@Override
	public int add(UserEntity user) {
		String sql="insert into users values(?,?)";
		Map<Integer,Object> map=new HashMap<Integer,Object>();
		map.put(1, user.getUname());
		map.put(2, user.getUsex());
		int i=super.update(sql, map);
		return i;
	}

	@Override
	public int delete(int uid) {
		String sql="delete from users where uid=? ";
		Map<Integer,Object> map=new HashMap<Integer,Object>();
		map.put(1, uid);
		//父类的方法直接用
		int i=super.update(sql, map);
		return i;
	}

	@Override
	public int update(UserEntity user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<UserEntity> select(Object obj) {
		List<UserEntity> user=new ArrayList<UserEntity>();
		String sql="select * from users";
		Map<Integer,Object> map=new HashMap<Integer,Object>();
		//调用
		List list=super.selectActive(sql, map);
				//遍历最外层
				for(int i=0;i<list.size();i++){
					UserEntity en=new UserEntity();
					//遍历集合对象
					List slist=(List) list.get(i);
					for(int j=0;j<slist.size();j++){
						en.setUid(Integer.parseInt(slist.get(0).toString()));
						en.setUname(slist.get(1).toString());
						en.setUsex(slist.get(2).toString());
					}
					//
					user.add(en);
				}
		return user;
	}
	
	
	
	
	
	
	

}
