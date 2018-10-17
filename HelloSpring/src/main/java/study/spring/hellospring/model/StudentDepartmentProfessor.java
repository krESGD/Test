package study.spring.hellospring.model;

public class StudentDepartmentProfessor extends Student {
	private String dname;
	private String pname;
	
	/*private int limitStart;
	private int listCount;

	public int getLimitStart() {
		return limitStart;
	}

	public void setLimitStart(int limitStart) {
		this.limitStart = limitStart;
	}

	public int getListCount() {
		return listCount;
	}

	public void setListCount(int listCount) {
		this.listCount = listCount;
	}*/

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	@Override
	public String toString() {
		return "StudentDepartmentProfessor [dname=" + dname + ", pname=" + pname + ", getStudno()=" + getStudno()
				+ ", getName()=" + getName() + ", getUserid()=" + getUserid() + ", getGrade()=" + getGrade()
				+ ", getIdnum()=" + getIdnum() + ", getBirthdate()=" + getBirthdate() + ", getTel()=" + getTel()
				+ ", getHeight()=" + getHeight() + ", getWeight()=" + getWeight() + ", getDeptno()=" + getDeptno()
				+ ", getProfno()=" + getProfno() + "]";
	}	
}
