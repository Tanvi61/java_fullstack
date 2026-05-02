package Day_06;

import java.util.Scanner;

/*
    This is client class to take the request for Tea
*/
public class PremachaChaha {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Ram ramu = new Ram();
        Scanner sc = new Scanner(System.in);
        String choice;
        do{
            System.out.println("Wel-Come to Premacha Chaha");
            System.out.println("1. BlackTea");
            System.out.println("2. MilkTea");
            System.out.println("-------------------------------------------");
            System.out.println("Enter your choice : ");
            int ch = sc.nextInt();
            switch(ch){
                case 1:
                    ramu.getOrder("Day_06.Blacktea");
                break;
                case 2:
                    ramu.getOrder("Day_06.Milktea");
                break;
                default:
                    System.out.println("This order is not present in the order");
                break;
            }
            System.out.println("Do you want to continue....(yes/YES)");
            choice = sc.next();
        }while(choice.equalsIgnoreCase("yes"));
        System.out.println("Thank You..!!");
        sc.close();
    }
}
