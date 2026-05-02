package Day_07;

class D{
    long m1(){
        System.out.println("In D and taking Mobile number");
        return 8263847201l;
    }
    static char convertChar(){
        System.out.println("In satic char method");
        return ((char)78);
    }
    double getBalance(long accno){
        System.out.println("In return getBalance : "+accno);
        double balance = 30000.69;
        return balance;
    }
    static boolean validateAge(int age){
        if(age > 18)
            return true;
        else
            return false;
    }
    int getAtmPin(BankDetails per){
        return 25;
        
    }
}


public class Syntax_4_6 {
    
    public static void main(String[] args) {
        /// Syntax for 4th method
        /// Calling static method
        char ch = D.convertChar();
        System.out.println("ch : "+ch);
        /// Calling Non-static method
        long mobile = new D().m1();
        System.out.println("Mobile Number : "+mobile);
        /// Syntax for 5th method
        /// Calling static method
        boolean flag = D.validateAge(17);
        if(flag)
            System.out.println("Eligible for voting");
        else
            System.out.println("Not Eligible for voting");
        /// Instance method calling
        D od = new D();
        double getBalance = od.getBalance(876544357l);
        System.out.println("Balance is : "+getBalance);
    }
}
