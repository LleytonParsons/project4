import java.util.Scanner;

public class Account {
    private Scanner scanner = new Scanner(System.in);
    private double balance;
    private int accountNumber;
    private static int numberOfAccounts = 1000;

    public Account(Double deposit){
        this.balance = deposit;
        this.accountNumber = ++numberOfAccounts;

    }

    public double getBalance(){
        return balance;
    }
    public int getAccountNumber(){
        return accountNumber;
    }

    public double depositBalance(){
        System.out.println("Enter deposit amount: ");
        double deposit = Double.parseDouble(scanner.nextLine());
        System.out.printf("\nDeposited: $%.2f", deposit);
        if (balance == 0){
            balance = balance + deposit;
            System.out.printf("\nBalance: $%.2f", balance);
            //If the first deposit of the newly made account is 0 ^^^
        }
        else{
            balance = balance + deposit;
            System.out.printf("\nUpdated balance: $%.2f", balance);
        }        return balance;
    }
    public double withdrawBalance(){
        System.out.println("Enter withdraw amount: ");
        double withdraw = Double.parseDouble(scanner.nextLine());
        if(withdraw > balance){
            System.out.println("Insufficient funds.");
        }
        else{
            System.out.printf("\nWithdrawn: $%.2f", withdraw);
            balance = balance - withdraw;
            System.out.printf("\nUpdated balance: $%.2f", balance);
        }
        return balance;
    }
    @Override
    public String toString() {
        return String.format("Account number: %d\n Balance: $%.2f\n", accountNumber, balance);
    }
}
