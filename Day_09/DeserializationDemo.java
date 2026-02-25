package Day_09;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import Excersize_01.Employee;

public class DeserializationDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException{
     File file = new File("D:\\Ass1\\employee.txt");
    FileInputStream fis = new FileInputStream(file);
    ObjectInputStream ois = new ObjectInputStream(fis);
    Object o = ois.readObject();
    Employee emp = (Employee)o;
    System.out.println(emp);
    ois.close();
    fis.close();   
    }
}
