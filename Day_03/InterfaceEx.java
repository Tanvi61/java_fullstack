package Day_03;

public interface InterfaceEx {
    void print1();
}

class A implements InterfaceEx{
    public void print1(){
        System.out.println("In class A");
    }
    public static void main(String[] args) {
        System.out.println("In main method");
        A obj = new A();
        obj.print1();
    }
}
