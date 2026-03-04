import java.util.ArrayList;
import java.util.List;

public class EmployeeDataBase {
	
	public static List<Employee> getEmployeeList(){
		List<Employee> empList = new ArrayList();
		Employee darshana = new Employee(101,"Darshana",2000.9,20,'F',"Dev",2021);
		Employee Tanvi = new Employee(102,"Tanvi",3000.9,21,'F',"CEO",2022);
		Employee Shruti = new Employee(103,"Shruti",4500.9,22,'F',"CTO",2022);
		Employee Ruchika = new Employee(104,"Ruchika",5000.9,23,'F',"CFO",2023);
		Employee Gauri = new Employee(105,"Gauri",1000.9,21,'F',"Junior Dev",2023);
		Employee Rutuja = new Employee(106,"Rutuja",2500.9,25,'F',"HR",2024);
		Employee Shivani = new Employee(107,"Shivani",22000.9,20,'F',"Manager",2025);
		Employee Siya = new Employee(108,"Siya",35000.9,30,'F',"Designer",2026);
		Employee dhara = new Employee(109,"dhara",56000.9,21,'F',"Arch",2027);
		Employee darsh = new Employee(110,"darsh",2800.9,22,'M',"Manager",2028);
		Employee riya = new Employee(111,"riya",2000.9,25,'F',"Dev",2028);
		Employee diya = new Employee(112,"diya",2000.9,23,'F',"Dev",2029);
		Employee piya = new Employee(113,"piya",2000.9,27,'F',"Dev",2021);
		Employee aditi = new Employee(114,"aditi",2000.9,36,'F',"Dev",2022);
		Employee ovi = new Employee(115,"ovi",2000.9,29,'F',"Dev",2025);
		empList.add(darshana);
		empList.add(Tanvi);
		empList.add(Shruti);
		empList.add(Ruchika);
		empList.add(Rutuja);
		empList.add(Shivani);
		empList.add(Gauri);
		empList.add(Siya);
		empList.add(dhara);
		empList.add(darsh);
		empList.add(riya);
		empList.add(diya);
		empList.add(piya);
		empList.add(aditi);
		empList.add(ovi);		
		return empList;
		
	}

}
