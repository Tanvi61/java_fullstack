package Day_05;

public class OverrindingEx {
    protected OverrindingEx m1(OverrindingEx obj){
        System.out.println("In m1 in parent");
        return new OverrindingEx();
    }    
}

class Ovrr2 extends OverrindingEx{
     OverrindingEx m1(){
        System.out.println("In m1 in child");
        return new OverrindingEx();
    }
}

class Main{
    public static void main(String[] args) {
        OverrindingEx obj = new OverrindingEx();
        obj.m1(new OverrindingEx());
        Ovrr2 ob = new Ovrr2();
        ob.m1(new Ovrr2());
    }
}