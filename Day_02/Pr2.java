package Day_02;

public abstract class Pr2 {
    abstract void run();
}

class Bike extends Pr2{
    Bike(){
        super();
    }
    void run(){
        System.out.println("In Bike class");
    }
    final void run1(){
        System.out.println("In Final run1 method");  //Final method can not be override
    }
    static void run2(){
        System.out.println("In Static run2 method");
    }
}

class Honda extends Bike{
    static void run2(){
        System.out.println("In Honda ");
    }
}
class Main{
    public static void main(String[] args) {
        System.err.println("Error");
        Bike obj = new Bike();
        obj.run();
        obj.run1();
       // Honda obj1 = new Honda();
        Honda.run2();    //Access this method in a static way
    }
}