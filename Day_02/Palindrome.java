package Day_02;

import java.util.*;
public class Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String : ");
        String s = sc.nextLine();
        String rev = "";
        for(int a = s.length()-1;a>=0;a--){
            rev+=s.charAt(a);
        }
        if(s.equals(rev)){
            System.out.println("Palindrome");
        }else{
            System.out.println("Not Palindrome");
        }
        sc.close();
    }
}
