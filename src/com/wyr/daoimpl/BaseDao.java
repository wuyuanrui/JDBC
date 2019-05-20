package com.wyr.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.catalina.User;

import com.wyr.utils.JDBC;

public  class BaseDao {
	private Connection conn=null;
	private PreparedStatement pre=null;
	private ResultSet res=null;
	private JDBC jdbc=null;
	public   int num=1000;
	public BaseDao(){
		jdbc=new JDBC();
	}
	
	//增删改查
	//都会传递sql和参数
	public int update(String sql,Map<Integer,Object> map){
		int i=0;
		try {
			conn=jdbc.getConnection();
			pre=conn.prepareStatement(sql);
			/*//获取键集合
			 Set s=map.keySet();
			 //返回迭代器
			Iterator c=s.iterator();
			while(c.hasNext()){
				//通过键获取值保存
				pre.setObject(1, map.get(c.next()));
				pre.setObject(2, map.get(c.next()));
			}*/
			for(Integer index:map.keySet()){
				//keySet获取键值，
				//再通过键值获取真实值
				pre.setObject(index, map.get(index));		
			}
			i=pre.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			jdbc.close(pre, res, conn);
		}
		return i;
	}
	
	
	//查询传参数
	public List selectActive(String sql,Map<Integer,Object> map){
		List list=new ArrayList();
		
		try {
			conn=jdbc.getConnection();
			pre=conn.prepareStatement(sql);
			//遍历键，获取值
			for(Integer i:map.keySet()){
				pre.setObject(i, map.get(i));
			}
			res=pre.executeQuery();
			
			
			
			//总列数
			int  col=res.getMetaData().getColumnCount();
			//获取
			while(res.next()){
				//封装每一个对象
				List obj=new ArrayList();
				//遍历总列数，对象的每一个属性
				for(int i=1;i<=col;i++){
					//每一列添加到集合
					obj.add(res.getObject(i));
				}
				//把每一个对象的集合（包含所有字段的信息），封装到集合（一个个对象集合）
				list.add(obj);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			jdbc.close(pre, res, conn);
		}
		
		
		return list;
	}
	
	
	
	
	
}
