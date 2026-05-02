package Day_02;

public class Pr1 {
    private String name;
    private int a;
    private String clg;
    private Pr1(int a){
        this.a = a;
        System.out.println("Private constructor");
    }
    Pr1(){
        System.out.println(" No Argument Constructor called");
        name = "Tanvi";
    }
    Pr1(String clg){
        System.out.println("Parametarized Constructor");
        clg = "Zeal College";
    }

    public static void main(String[] args) {
        Pr1 obj = new Pr1();
        System.out.println(obj.name);
        Pr1 obj1 = new Pr1(6);
        System.out.println(obj1.a);
        Pr1 obj2 = new Pr1();
        System.out.println(obj2.clg);
    }
}


/*
constructor and it's type : 
Constructor : It's a special kind of method which is used for initializing the variables of the class
              And it is called at the time of object creation
    1. Default constructor : It is given by compiler when we could not provide manual constructor
    2. NO Argument constructor : Which does not have any argument in it
    3. Parameterized constructor : constructor accepting single or multiple values in it.
    4. Copy construtor : 

 */