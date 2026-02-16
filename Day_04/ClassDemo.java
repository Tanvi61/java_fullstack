package Day_04;

class Demo{
    int count = 0;
    void m1(){
        int localvar = 10;
        System.out.println("Local variable : "+localvar);
        count++;
    }
    void show(){
        System.out.println("Count : "+count);
    }
    static void disp(){
        //System.out.println("Localvar : "+localvar);  //Because localvarible not present in the scope 
        //System.out.println("Count : "+count);  //Static block comes first the all other variable that's why this is not access
    }
}
public class ClassDemo {
    public static void main(String[] args) {
        System.out.println("Hii Friends..!!");
        Demo d = new Demo();
        d.m1();
        d.show();
    }
}
