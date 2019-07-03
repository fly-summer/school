package Model;

import java.util.Date;

public class Student {
	private int id;
	private String sno;
	private String sname;
	private String sex;
	private String birth;
	private String sclass;
	private String major;
	private String department;
	public Student() {
		super();
	}
	public Student(String sno, String sname, String sex, String birth, String sclass, String major, String department) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.sex = sex;
		this.birth = birth;
		this.sclass = sclass;
		this.major = major;
		this.department = department;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getSclass() {
		return sclass;
	}
	public void setSclass(String sclass) {
		this.sclass = sclass;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
}
