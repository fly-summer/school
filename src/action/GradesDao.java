package action;

import java.util.ArrayList;
import java.util.List;

import Model.Course;
import Model.Grades;

public class GradesDao extends Base {
	public boolean saveGrades(Grades gra) {
		// TODO Auto-generated method coub
		String sql="insert into grades (sno,cno,cname,score,rescore)values(?,?,?,?,?)";
		List<Object> params=new ArrayList<Object>();
		params.add(gra.getSno());
		params.add(gra.getCno());
		params.add(gra.getCname());
		params.add(gra.getScore());
		params.add(gra.getRescore());
		
		
		return this.operUpdate(sql, params);
	}


	public boolean delGrades(String cno,String sno) {
		// TODO Auto-generated method coub
		String sql="delete from grades where cno=? and sno=? ";
		List<Object> params=new ArrayList<Object>();
		params.add(cno);
		params.add(sno);
		
		
		return this.operUpdate(sql, params);
	}


	public boolean updateGrades(int score,int rescore,String cno,String sno) {
		// TODO Auto-generated method coub
		String sql="update grades set score=?,rescore=? where cno=? and sno=? ";
		List<Object> params=new ArrayList<Object>();
		params.add(score);
		params.add(rescore);
		params.add(cno);
		params.add(sno);
		
		
		return this.operUpdate(sql, params);
	}

	
	public List<Grades> queryGrades() {
		// TODO Auto-generated method coub
		List<Grades> uList=null;
		String sql="select * from grades ";
		List<Object> params=new ArrayList<Object>();
		try {
	
			uList=this.operQuery(sql, params, Grades.class);
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

	
	public List<Grades> queryGradesBySnoCno(String sno,String cno) {
		// TODO Auto-generated method coub
		List<Grades> uList=null;
		String sql="select * from grades where sno=? and cno=?";
		List<Object> params=new ArrayList<Object>();
		params.add(sno);
		params.add(cno);
		try {
	
			uList=this.operQuery(sql, params, Grades.class);
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
	
	public List<Grades> queryGradesBySnoCon(int score,int rescore) {
		// TODO Auto-generated method coub
		List<Grades> uList=null;
		String sql="select * from grades where cno=? and sno=?";
		List<Object> params=new ArrayList<Object>();
		params.add(score);
		params.add(rescore);
		try {
	
			uList=this.operQuery(sql, params, Grades.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(uList.size()>0){
			
			return uList;
			
		}
		return null;
		
	}
	

	/*
	public List<Doctor> queryDocByDId(int DId) {
		// TODO Auto-generated method coub
		List<Doctor> uList=null;
		String sql="select DId,Room,DName from coudent where DId=?";
		List<Object> params=new ArrayList<Object>();
	
		params.add(DId);
		try {
	
			uList=this.operQuery(sql, params, Doctor.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(uList.size()>0){
			
			return uList;
			
		}
		return null;
	}
	
	public boolean queryDocBySick(String Room,String DName){
		List<Doctor> uList=null;
		String sql="select DId,Room,DName from coudent where Room=? and DName=?";
		List<Object> params=new ArrayList<Object>();
	
		params.add(Room);
		params.add(DName);
		try {
			
			uList=this.operQuery(sql, params, Doctor.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(uList.size()>0){
			
			return true;
			
		}
		return false;
	}
	*/
}
