package Day_08;

import java.util.*;
public class NumberChecking {
    // String checkInt(int num) throws ValidNumber{
    //     if(num < 0)
    //         throws new ValidNumber("You enter negative number");
    // }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number : ");
        
        try{
            int num = sc.nextInt();
        }catch(NumberFormatException nf){
            System.out.println("Please Enter Correct Number format..!!");
            nf.printStackTrace();
        }
    }
}
