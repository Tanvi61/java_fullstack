package Day_05;

abstract class Student{
    void studentInfo(){
        System.out.println("Student Info Basic Details");
    }
    abstract void streamInfo();
}

class CivilStudent extends Student{
    void streamInfo(){
        System.out.println("Civil Student");
    }
}
public class AbstractDemo {
    public static void main(String[] args) {
        CivilStudent cs = new CivilStudent();
        cs.streamInfo();
    }
    
}
