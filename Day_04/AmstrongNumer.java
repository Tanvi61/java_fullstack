package Day_04;

import java.util.*;
public class AmstrongNumer {
    Scanner sc = new Scanner(System.in);
    
    void checkAmstrong(){
        //System.out.println("Enter a number: ");
        //int num = sc.nextInt();
        for(int i=1;i<1000;i++){
            int num = i;
            int originalNum = num;
            int sum = 0;
        
            while (num > 0) {
                int digit = num % 10; 
                sum += Math.pow(digit, 3); 
                num /= 10; 
            }
        
            if (sum == originalNum) {
                System.out.println(originalNum + " is an Armstrong number.");
            } else {
                //System.out.println(originalNum + " is not an Armstrong number.");
            }
        }
    }
    
    public static void main(String[] args) {
        AmstrongNumer obj = new AmstrongNumer();
        obj.checkAmstrong();
    }
    
}
