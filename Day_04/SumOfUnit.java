package Day_04;

import java.util.Scanner;
public class SumOfUnit {
    void add(){
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter a number: ");
            int num = sc.nextInt();
            int sum = 0;
            while(num > 0){
                int unit = num % 10; 
                sum += unit; 
                num /= 10; 
            }
            System.out.println("The sum of the unit digits is: " + sum);
            sc.close();
    }
    public static void main(String[] args) {
        SumOfUnit obj = new SumOfUnit();
        obj.add();
    }
    
}
