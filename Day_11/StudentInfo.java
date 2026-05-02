package Day_11;

public class StudentInfo {
	int rollNo;
	String name;
	String div;
	long id;
	public StudentInfo(int rollNo, String name, String div, long id) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.div = div;
		this.id = id;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDiv() {
		return div;
	}
	public void setDiv(String div) {
		this.div = div;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "StudentInfo [rollNo=" + rollNo + ", name=" + name + ", div=" + div + ", id=" + id + "]";
	}
	
	
}
