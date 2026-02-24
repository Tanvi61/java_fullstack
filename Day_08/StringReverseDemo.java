package Day_08;

import java.util.*;
public class StringReverseDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string : ");
        String str = sc.nextLine();
        for(int i=str.length()-1;i>=0;i--){
            System.out.println(str.charAt(i));
        }
    }
}
