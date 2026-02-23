package Day_07;

public class BankDetails {
    private int accno;
    private String accHolderName;
    private double balance;
    public BankDetails(int accno, String accHolderName, double balance) {
        this.accno = accno;
        this.accHolderName = accHolderName;
        this.balance = balance;
    }
    public int getAccno() {
        return accno;
    }
    public void setAccno(int accno) {
        this.accno = accno;
    }
    public String getAccHolderName() {
        return accHolderName;
    }
    public void setAccHolderName(String accHolderName) {
        this.accHolderName = accHolderName;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

        
}
