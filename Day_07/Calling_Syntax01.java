package Day_07;

import java.time.LocalDate;

class A{
    void m1(){
        System.out.println("In m1");
    }
    static void m2(){
        System.out.println("In static m2");
    }
} 

class B{
    void m1(int num){
        System.out.println("In m1 Num is : "+num);
    }
    static void m2(boolean flag){
        if(flag)
            System.out.println("In static m2 flag is : "+flag);
        else
            System.out.println("I am in Else block");
    }
}

class C{
    void c1(LocalDate ld){
        System.out.println("In c1 and Date is : "+ld);
    }
    static void c2(A oa){
        oa.m1();
        System.out.println("Here in m1 static");
    }
}
public class Calling_Syntax01 {
    public static void main(String[] args) {
        /// Syntax for type 1
        A.m2();  //Static method calling syntax
        A obj = new A();  //Instance method callling syntax
        obj.m1();
        /// Systax for 2nd type 
        B.m2(true);   //Static method calling
        B objB = new B();   //Instance method calling
        objB.m1(10);

        /// Syntax for type 3
        LocalDate ld = LocalDate.now();
        C.c2(new A());  //Calling static method
        C objC = new C();  //Calling Instance method
        objC.c1(ld);
    }
}
