package Excersize_01;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializationDemo {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\Ass1\\employee.txt");
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        Employee emp = new Employee(101,"Tanvi",8970.90f);
        // Employee emp1 = new Employee(102,"Shruti",8970.96f);
        // Employee emp2 = new Employee(103,"Rutuja",8970.98f);
        // Employee emp3 = new Employee(104,"Tanu",8970.99f);
        oos.writeObject(emp);
        // oos.writeObject(emp1);
        // oos.writeObject(emp2);
        // oos.writeObject(emp3);
        System.out.println("Successfull");
        oos.close();
        fos.close();
    }
}
