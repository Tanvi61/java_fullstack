
public class Employee {
	private int EmpId;
	private String EmpName;
	private Double EmpSalary;
	private int EmpAge;
	private char gender;
	private String dept;
	private int yearOfJoining;
	
	public Employee(int empId, String empName, Double empSalary, int empAge, char gender, String dept,
			int yearOfJoining) {
		super();
		EmpId = empId;
		EmpName = empName;
		EmpSalary = empSalary;
		EmpAge = empAge;
		this.gender = gender;
		this.dept = dept;
		this.yearOfJoining = yearOfJoining;
	}
	public int getEmpId() {
		return EmpId;
	}
	public void setEmpId(int empId) {
		EmpId = empId;
	}
	public String getEmpName() {
		return EmpName;
	}
	public void setEmpName(String empName) {
		EmpName = empName;
	}
	public Double getEmpSalary() {
		return EmpSalary;
	}
	public void setEmpSalary(Double empSalary) {
		EmpSalary = empSalary;
	}
	public int getEmpAge() {
		return EmpAge;
	}
	public void setEmpAge(int empAge) {
		EmpAge = empAge;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public int getYearOfJoining() {
		return yearOfJoining;
	}
	public void setYearOfJoining(int yearOfJoining) {
		this.yearOfJoining = yearOfJoining;
	}
	@Override
	public String toString() {
		return "Employee [EmpId=" + EmpId + ", EmpName=" + EmpName + ", EmpSalary=" + EmpSalary + ", EmpAge=" + EmpAge
				+ ", gender=" + gender + ", dept=" + dept + ", yearOfJoining=" + yearOfJoining + "]";
	}

}
