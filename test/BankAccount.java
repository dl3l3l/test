// BankAccount.java

public class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(amount + "원이 입금되었습니다. 현재 잔액: " + balance + "원");
        } else {
            System.out.println("입금 금액은 0보다 커야 합니다.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(amount + "원이 출금되었습니다. 현재 잔액: " + balance + "원");
        } else {
            System.out.println("출금 금액이 잘못되었습니다. 현재 잔액: " + balance + "원");
        }
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount("123-456-789", 1000.0);
        System.out.println("계좌번호: " + account.getAccountNumber());
        System.out.println("초기 잔액: " + account.getBalance() + "원");

        account.deposit(500.0);
        account.withdraw(200.0);
        account.withdraw(1500.0);
    }
}
