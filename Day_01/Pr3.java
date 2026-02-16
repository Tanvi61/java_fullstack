package Day_01;

public class Pr3 {
    private Pr3(){}
    void msg(){
        System.out.println("Hello JAVA");
    }
    public static void main(String[] args) {
        Pr3 obj = new Pr3();
        obj.msg();
        Stud obj1 = new Stud();
        obj1.setName("Tanvi");
        System.out.println(obj1.getName());
    }
}


class Stud{
    private String name = "Tanu";
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
}