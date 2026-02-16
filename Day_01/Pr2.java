package Day_01;

import java.util.*;
public class Pr2 {
    public int add(int a, int  b){
        int c = add(a, b);
        return c;
    }
    public int sub(int a, int b){
        int s = sub(a, b);
        return s;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter First Number : ");
        int a = sc.nextInt();
        System.out.print("Enter Second Number : ");
        int b = sc.nextInt();
        Pr2 pr = new Pr2();
        System.out.println("Addition : "+ pr.add(a,b));
        System.out.println("Substraction : "+ pr.sub(a,b));
        System.out.println("Multiplication : "+ (a*b));
        System.out.println("Division : "+ (a/b));
        sc.close();
    }
}
