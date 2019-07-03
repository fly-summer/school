package Model;

public class Grades {
	private int id;
	private String sno;
	private String cno;
	private String cname;
	private int score;
	private int rescore;
	public Grades() {
		super();
	}
	public Grades(String sno, String cno, String cname, int score, int rescore) {
		super();
		this.sno = sno;
		this.cno = cno;
		this.cname = cname;
		this.score = score;
		this.rescore = rescore;
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
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getRescore() {
		return rescore;
	}
	public void setRescore(int rescore) {
		this.rescore = rescore;
	}
	
}
