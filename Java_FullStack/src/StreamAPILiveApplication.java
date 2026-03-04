import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamAPILiveApplication {

	public static void main(String[] args) {
		List<Employee> list = EmployeeDataBase.getEmployeeList();
		//Print all the record with the help of forEach method
		list.stream().forEach(e->System.out.println(e));
		
		//How many male and female employees available in the organization
		Map<Character, Long> empCount = list.stream()
				.collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
		System.out.println(empCount);
		
		//Print all the department in the organization
		list.stream().map(Employee::getDept).distinct().forEach(System.out::println);
		
		//what is average age of male and female employee
		Map<Character, Double> averageAge = list.stream()
				.collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingDouble(Employee::getEmpAge)));
		System.out.println(averageAge);
		
		//Count the number of employees in each department
		Map<String, Long> CountOfEmpDept = list.stream()
				.collect(Collectors.groupingBy(Employee::getDept,Collectors.counting()));
		System.out.println(CountOfEmpDept);
		
		//average salary of each department
		Map<String, Double> averageSalaryDept = list.stream()
				.collect(Collectors.groupingBy(Employee::getDept,Collectors.averagingDouble(Employee::getEmpSalary)));
		System.out.println(averageSalaryDept);
		
		//get the details of youngest employee in development department
		Optional<Employee> emp = list.stream().filter(e->e.getDept()=="Dev")
				.min(Comparator.comparing(Employee::getEmpAge));
		System.out.println(emp);
		
		//get the details of highest paid employee
		Optional<Employee> empHighSalary = list.stream()
				.collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getEmpSalary)));
		System.out.println(empHighSalary);
		
		//print the names of employees who is join after 2022
		list.stream().filter(e->e.getYearOfJoining()>2022)
		.map(Employee::getEmpName).forEach(System.out::println);
		System.out.println("----------------------");
		
		//print the names of employees who is join after 2022 in  Development department
				list.stream().filter(e->e.getYearOfJoining()>2022 && e.getDept()=="Dev")
				.map(Employee::getEmpName).forEach(System.out::println);
		
		//who is the most working employee in the organization
		Optional<Employee> mostWorking = list
				.stream().sorted(Comparator.comparingInt(Employee::getEmpAge)).findAny();
		System.out.println("Most Working : "+mostWorking);
		
		list.stream().sorted(Comparator.comparingInt(Employee::getYearOfJoining))
		.limit(2).forEach(System.out::println);
	}

}
