package Day_03;

public class Pr2 {
    Pr2(int r,String c){
        rollNo = r;
        clg = c;
    }
    static int rollNo = 32;
    static String clg = "zeal"; 
    public static void display(){
        System.out.println("Roll NO. : "+rollNo);
        System.out.println("College Name : "+clg);
    }
}

class Main{
    static void dis(){
        System.out.println("Hello");
    }
    public static void main(String[] args) {
        Pr2.display();
        Pr2 obj = new Pr2(4,"ZCOER");
        obj.display();
        dis();
    }
}
