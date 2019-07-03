package action;

import java.util.ArrayList;
import java.util.List;

import Model.User;

public class UserDao extends Base {
	//Ôö¼Ó
	public boolean saveUser(User user) {
		String sql="insert into user(name,password,type)values(?,?,?)";
		List<Object> params=new ArrayList<Object>();
		params.add(user.getId());
		params.add(user.getName());
		params.add(user.getType());
		

		return this.operUpdate(sql, params);
	}


	//ĞŞ¸ÄÃÜÂë
	public boolean updateUser(User user) {
		String sql="update user set password=? where name=?";
		List<Object> params=new ArrayList<Object>();
	
		params.add(user.getPassword());
		params.add(user.getName());
		
		return this.operUpdate(sql, params);
	}


	public User queryUser(User user) {
		List<User> uList=null;
		String sql="select id,name,password from user where name=? and password=? and type=?";
		List<Object> params=new ArrayList<Object>();
		params.add(user.getName());
		params.add(user.getPassword());
		params.add(user.getType());
		try {
	
			uList=this.operQuery(sql, params, User.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(uList.size()>0){
			
			return uList.get(0);
			
		}
		return null;
		
	}
}
