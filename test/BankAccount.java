import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private String accountNumber;
    private double balance;
    private List<String> transactionHistory;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        addTransaction("계좌 생성 - 초기 잔액: " + initialBalance + "원");
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
            addTransaction(amount + "원이 입금되었습니다. 현재 잔액: " + balance + "원");
            System.out.println(amount + "원이 입금되었습니다. 현재 잔액: " + balance + "원");
        } else {
            System.out.println("입금 금액은 0보다 커야 합니다.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            addTransaction(amount + "원이 출금되었습니다. 현재 잔액: " + balance + "원");
            System.out.println(amount + "원이 출금되었습니다. 현재 잔액: " + balance + "원");
        } else if (amount > balance) {
            System.out.println("잔액이 부족합니다. 현재 잔액: " + balance + "원");
        } else {
            System.out.println("출금 금액이 잘못되었습니다. 현재 잔액: " + balance + "원");
        }
    }

    private void addTransaction(String transaction) {
        transactionHistory.add(transaction);
    }

    public void printTransactionHistory() {
        System.out.println("거래 내역:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount("123-456-789", 1000.0);
        System.out.println("계좌번호: " + account.getAccountNumber());
        System.out.println("초기 잔액: " + account.getBalance() + "원");

        account.deposit(500.0);
        account.withdraw(200.0);
        account.withdraw(-100.0);  // 잘못된 출금 시도
        account.withdraw(1500.0);  // 잔액 부족 출금 시도

        // 잔액이 음수가 되는 상황 추가
        account.withdraw(1300.0);  // 이 경우는 실제 출금이 이루어져야 한다.

        // 거래 내역 출력
        account.printTransactionHistory();
    }
}
