package Day_03;

// For static nested class we can access the static members of outer class directly but for non static nested class we have to create the object of outer class to access the members of outer class
public class OuterClass {
    static int a = 10;
    static class InnerClass{
        void display(){
            System.out.println("Value of a is : " + a);
        }
    }
}

class Main1{
    public static void main(String[] args) {
        OuterClass.InnerClass obj = new OuterClass.InnerClass();
        obj.display();
    }
}