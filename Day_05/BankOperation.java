package Day_05;

class Bank_01{
    void miniStatement(){
        System.out.println("Print last 5 Transaction");
    }
}

class Bank_02 extends Bank_01{
    void miniStatement(){
        System.out.println("Print last 10 transaction");
    }
}
public class BankOperation {
    public static void main(String[] args) {
        Bank_01 b1 = new Bank_02();
        b1.miniStatement();
    }
}
