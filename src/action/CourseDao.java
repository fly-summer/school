package action;

import java.util.ArrayList;
import java.util.List;

import Model.Course;


public class CourseDao extends Base{
	public boolean saveCourse(Course cou) {
		// TODO Auto-generated method coub
		String sql="insert into course (cno,cname,ltime,lscore)values(?,?,?,?)";
		List<Object> params=new ArrayList<Object>();
		params.add(cou.getCno());
		params.add(cou.getCname());
		params.add(cou.getLtime());
		params.add(cou.getLscore());
		
		return this.operUpdate(sql, params);
	}

	//根据学号删学生
	public boolean delCourse(int cno) {
		// TODO Auto-generated method coub
		String sql="delete from course where cno=?";
		List<Object> params=new ArrayList<Object>();
		params.add(cno);
		
		return this.operUpdate(sql, params);
	}


	public boolean updateCourse(Course cou) {
		// TODO Auto-generated method coub
		String sql="update course set cname=?,ltime=?,lscore=? where cno=?";
		List<Object> params=new ArrayList<Object>();
	
		params.add(cou.getCname());
		params.add(cou.getLtime());
		params.add(cou.getLscore());
		params.add(cou.getCno());
		
		return this.operUpdate(sql, params);
	}

	
	public List<Course> queryCourse() {
		// TODO Auto-generated method coub
		List<Course> uList=null;
		String sql="select * from course ";
		List<Object> params=new ArrayList<Object>();
		try {
	
			uList=this.operQuery(sql, params, Course.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(uList.size()>0){
			
			return uList;
			
		}
		return null;
	}

	
	public List<Course> queryCourseByCname(String cname) {
		// TODO Auto-generated method coub
		List<Course> uList=null;
		String sql="select * from course where cname=?";
		List<Object> params=new ArrayList<Object>();
	
		params.add(cname);
		try {
	
			uList=this.operQuery(sql, params, Course.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(uList==null){
			return null;
		}
		if(uList.size()>0){
			
			return uList;
			
		}
		return null;
		
	}
	
	public List<Course> queryCourseByCno(String cno) {
		// TODO Auto-generated method coub
		List<Course> uList=null;
		String sql="select * from course where cno=?";
		List<Object> params=new ArrayList<Object>();
	
		params.add(cno);
		try {
	
			uList=this.operQuery(sql, params, Course.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(uList==null){
			return null;
		}
		if(uList.size()>0){
			
			return uList;
			
		}
		return null;
		
	}

}
