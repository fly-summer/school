package Model;

public class Course {
	private int id;
	private String cno;
	private String cname;
	private int ltime;
	private int lscore;
	public Course() {
		super();
	}
	public Course(String cno, String cname, int ltime, int lscore) {
		super();
		this.cno = cno;
		this.cname = cname;
		this.ltime = ltime;
		this.lscore = lscore;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCno() {
		return cno;
	}
	public void setCno(String cno) {
		this.cno = cno;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getLtime() {
		return ltime;
	}
	public void setLtime(int ltime) {
		this.ltime = ltime;
	}
	public int getLscore() {
		return lscore;
	}
	public void setLscore(int lscore) {
		this.lscore = lscore;
	}
	
}
