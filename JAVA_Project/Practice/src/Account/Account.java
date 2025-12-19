package Account;
import java.util.Date;

public class Account {
    private int Id;
    private double Balance;
    private double AnnuallnterestRate;
    private Date DateCreated;

    public Account() {
        Id = 0;
        Balance = 0.0;
        AnnuallnterestRate = 0.0;
        DateCreated = new Date();
    }

    public Account(int id, double balance) {
        Id = id;
        Balance = balance;
        DateCreated = new Date();
    }

    public int GetId() {
        return Id;
    }
    
    public double GetBalance() {
        return Balance;
    }

    public double GetAnnuallnterestRate() {
        return AnnuallnterestRate;
    }

    public Date GetDateCreated() {
        return DateCreated;
    }

    public void SetId(int id) {
        Id = id;
    }

    public void SetBalance(double balance) {
        Balance = balance;
    }

    public void SetAnnuallnterestRate(double annualInterestRate) {
        AnnuallnterestRate = annualInterestRate;
    }

    public double GetMonthlyInterestRate() {
        return AnnuallnterestRate / 12;
    }

    public double GetMonthlyInterest() {
        return Balance * (GetMonthlyInterestRate() / 100);
    }

    public void Withdraw(double amount) {
        if (amount <= Balance) {
            Balance -= amount;
        } else {
            System.out.println("Your balance is insufficient!");
        }
    }

    public void Deposit(double amount) {
        Balance += amount;
    }
}
