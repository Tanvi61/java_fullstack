package Day_01;
class Test{
    static int c = 6;
    void set(){
        int a = 100;
        System.out.println("Instance variable : "+a);
    }
    public static void main(String[] args){
        int d = 50;
        Test obj = new Test();
        obj.set();
        System.out.println("Static variable : "+c);
        System.out.println("Local variable : "+d);
        System.out.println(c>>d);
        System.out.println(c & d);
        System.out.println(c | d);
    }
}