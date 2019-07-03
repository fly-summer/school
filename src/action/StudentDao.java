package action;

import java.util.ArrayList;
import java.util.List;

import Model.Student;



public class StudentDao extends Base {

	
	public boolean saveStu(Student stu) {
		// TODO Auto-generated method stub
		String sql="insert into student (sno,sname,sex,birth,sclass,major,department)values(?,?,?,?,?,?,?)";
		List<Object> params=new ArrayList<Object>();
		params.add(stu.getSno());
		params.add(stu.getSname());
		params.add(stu.getSex());
		params.add(stu.getBirth());
		params.add(stu.getSclass());
		params.add(stu.getMajor());
		params.add(stu.getDepartment());
		
		return this.operUpdate(sql, params);
	}

	//根据学号删学生
	public boolean delStu(String sno) {
		// TODO Auto-generated method stub
		String sql="delete from student where sno=?";
		List<Object> params=new ArrayList<Object>();
		params.add(sno);
		
		return this.operUpdate(sql, params);
	}


	public boolean updateStu(Student stu) {
		// TODO Auto-generated method stub
		String sql="update student set sname=?,sex=?,birth=?,sclass=?,major=?,department=? where sno=?";
		List<Object> params=new ArrayList<Object>();
		
		params.add(stu.getSname());
		params.add(stu.getSex());
		params.add(stu.getBirth());
		params.add(stu.getSclass());
		params.add(stu.getMajor());
		params.add(stu.getDepartment());
		params.add(stu.getSno());
		
		return this.operUpdate(sql, params);
	}

	
	public List<Student> queryStu() {
		// TODO Auto-generated method stub
		List<Student> uList=null;
		String sql="select * from student ";
		List<Object> params=new ArrayList<Object>();
		try {
	
			uList=this.operQuery(sql, params, Student.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(uList.size()>0){
			
			return uList;
			
		}
		return null;
	}

	
	public List<Student> queryDocBySname(String sname) {
		// TODO Auto-generated method stub
		List<Student> uList=null;
		String sql="select * from student where sname=?";
		List<Object> params=new ArrayList<Object>();
	
		params.add(sname);
		try {
	
			uList=this.operQuery(sql, params, Student.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(uList.size()>0){
			
			return uList;
			
		}
		return null;
		
	}
	
	public List<Student> queryDocBySno(String sno) {
		// TODO Auto-generated method stub
		List<Student> uList=null;
		String sql="select * from student where sno=?";
		List<Object> params=new ArrayList<Object>();
	
		params.add(sno);
		try {
	
			uList=this.operQuery(sql, params, Student.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(uList.size()>0){
			
			return uList;
			
		}
		return null;
		
	}
	

}
