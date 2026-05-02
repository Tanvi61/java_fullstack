package Day_02;

import java.util.*;
public class LongestSubString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the String : ");
        String s = sc.nextLine();
        String longest = "";
        for(int i=0;i<s.length();i++){
            String current = "";
            for(int j=i;j<s.length();j++){
                char ch = s.charAt(j);
                if(current.indexOf(ch) != -1){
                    break;
                }
                current += ch;

                if(current.length() >= longest.length()){
                    longest = current;
                }
            }
        }
        System.out.println("Longest Substring is : " + longest);
        System.out.println("Length of String is : " + longest.length());
        sc.close();
    }
}
