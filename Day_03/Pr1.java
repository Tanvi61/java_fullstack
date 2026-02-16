package Day_03;

public class Pr1{
    final int speedlimit = 90;
    void run(){
        //speedlimit = 400;    //Erroor because we can not change the value of final variable
        System.out.println("Running at speed : " + speedlimit);
    }
    
}
final class Bike extends Pr1 {
    void run1(){
        System.out.println("In Bike class Run");
    }

    public static void main(String[] args) {
        Pr1 obj = new Pr1();
        obj.run();
    }
    //  We can inherite the final method but we can not override it
    //  Final class can not be inherited
}