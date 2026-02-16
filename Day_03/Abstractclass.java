package Day_03;

abstract class Abstractclass {
    abstract void display();
    
}
abstract class Example extends Abstractclass{
    abstract void display();
    void show(){
        System.out.println("In Show method");
    }
}

class Main2 extends Example{
    void display(){
        System.out.println("In Display method");
    }
    public static void main(String[] args) {
        Main2 obj = new Main2();
        obj.display();
        obj.show();
    }
}
