package Day_04;

public class ConstructorDemo {
    ConstructorDemo(){
        this(21); // it will call the parameterized constructor of the class
        System.out.println("In Default Constructor");
    }
    ConstructorDemo(int a){
        this(33,"Tanu"); // it will call the default constructor of the class
        System.out.println("In Parameterized Constructor");
    }
    ConstructorDemo(int rollNo, String name){
        
        System.out.println("In Parameterized Constructor with 2 parameters");
    }
    public static void main(String[] args) {
        ConstructorDemo obj = new ConstructorDemo();
        
        //ConstructorDemo obj1 = new ConstructorDemo(10);
       // ConstructorDemo obj2 = new ConstructorDemo(32,"Tanvi");
    }
}
