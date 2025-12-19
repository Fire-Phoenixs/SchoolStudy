package Account;

public class Text {
    public static void main(String arg[]) {
        Account Text1 = new Account(1122, 20000);
        Text1.SetAnnuallnterestRate(4.5);
        Text1.Withdraw(2500);
        Text1.Deposit(3000);
        System.out.println("ID: " + Text1.GetId());
        System.out.println("Balance: " + Text1.GetBalance());
        System.out.println("Monthly Interest: " + Text1.GetMonthlyInterest());
        System.out.println("Date Created: " + Text1.GetDateCreated());

}
}
