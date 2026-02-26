package Day_05;

import java.util.Random;
import java.util.Scanner;
public class SBI {
    static Random rad = new Random();
    void fundTransfer(int SendreAccNo,int RecAccNo,float amount){
        System.out.println("Welcome to Net Banking");
        System.out.println("Sender Account Number : "+SendreAccNo);
        System.out.println("Receiver Account Number : "+RecAccNo);
        System.out.println("Transefer Amount : "+amount);
        System.out.println("Fund Transfer Successfully..!!");
    }

    final void fundTransfer(int senderAccNo, float amt, int ddNo){
        System.out.println("Welcome to DD Banking");
        System.out.println("Sender Account Number : "+senderAccNo);
        System.out.println("Receiver Account Number : "+ddNo);
        System.out.println("Transefer Amount : "+amt);
        System.out.println("Fund Transfer Successfully..!!"+"Transfer ID : "+rad.nextInt());

    }
    static void fundTransfer(int senderAccNo, float amt){
        System.out.println("Welcome to Cheque Banking");
        System.out.println("Sender Account Number : "+senderAccNo);
        System.out.println("Transefer Amount : "+amt);
        System.out.println("Fund Transfer Successfully..!!"+"Transfer ID : "+rad.nextInt());

    }

    private void fundTransfer(long mobileNo, int amt){
        System.out.println("Welcome to Mobile Banking");
        System.out.println("Sender Mobile Number : "+mobileNo);
        System.out.println("Transefer Amount : "+amt);
        System.out.println("Fund Transfer Successfully..!!"+"Transfer ID : "+new Random(1000).nextInt(0));

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SBI sbi = new SBI();
        String choice = "";
        do{
            System.out.println("Welcome to SBI banking Application");
            System.out.println("1. Net Banking");
            System.out.println("2. DD Banking");
            System.out.println("3. Cheque Banking");
            System.out.println("4. Mobile Banking");
            System.out.println("-------------------------------------------------");
            System.out.println("Enter your choice : ");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    sbi.fundTransfer(103654, 9756875, 90f);
                    break;
                case 2:
                    sbi.fundTransfer(234345, 876756, 56f);
                    break;
                case 3:
                    SBI.fundTransfer(65768799, 12f);
                    break;
                case 4:
                    SBI.fundTransfer(235656765, 56f);
                    break;
                default:
                    break;
            }
        }while(choice.equalsIgnoreCase("Yes"));
            System.out.println("Thank You visit again..!!");
        sc.close();   
    }
}
