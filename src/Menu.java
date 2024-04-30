import java.util.HashMap;
import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);
    private Bank bank = new Bank();
    private BankInfo bankInfo;


    public void runMenu(){
        while (true){
            String selection;
            System.out.printf("\n%s MENU %s\n", "*".repeat(10), "*".repeat(10));
            System.out.printf("Please make a selection: \n" + "1) Access account\n" + "2) Open a new account\n" + "3) Close all accounts\n" + "4) Exit\n" + ">> ");
            selection = scanner.nextLine();

            if(selection.equals("1")){
                accessAccount();
            }
            else if(selection.equals("2")){
                openNewAccount();
            }
            else if(selection.equals("3")){
                closeAccounts();
            }
            else if(selection.equals("4")){
                System.out.println("Exiting, thank you for banking with us....");
                break;
            }
            else{
                System.out.println("Invalid entry. Please try again.");
            }
        }
    }

    private void accessAccount(){
        String pinNum;
        Customer customer;
        System.out.print("Enter account PIN: ");
        pinNum = scanner.nextLine();
        customer = bank.getCustomerByPin(pinNum);
        if(customer == null){
            System.out.println("PIN is not valid.");
            return;
        }
        else{
            //gere
            System.out.printf("\n%s Active Accounts %s\n", "*".repeat(3), "*".repeat(3));
            Account account;
            System.out.println(customer.toString());
            if(bankInfo.getResponse().equals("yes")) {
                System.out.println(bankInfo.toString());
            }
            else{
                System.out.println("No Banking Information Entered");
            }

            System.out.println(customer.getAllAccountInfo());
            String selection;
            int accountNum;
            System.out.print("Enter account number: ");
            accountNum = Integer.parseInt(scanner.nextLine());
            account = customer.getSingleAccount(accountNum);
            if(account == null){
                System.out.println("Account number invalid.");
                return;
            }
            else{
                System.out.printf("Please make a selection: \n" + "1) Make a deposit\n" + "2) Make a withdrawal\n" + "3) See account balance\n" + "4) Close account\n" + "5) Exit\n" + ">> ");
                selection = scanner.nextLine();

                if(selection.equals("1")){
                    account.depositBalance();
                }
                else if(selection.equals("2")){
                    account.withdrawBalance();
                }
                else if(selection.equals("3")){
                    double balance = account.getBalance();
                    System.out.printf("Current account balance: $%.2f\n", balance);
                }
                else if(selection.equals("4")){
                    customer.removeAccount(account);
                    accountNum = account.getAccountNumber();
                    System.out.printf("Account %d closed.\n", accountNum);
                }
                else if(selection.equals("5")){
                    System.out.println("Returning to Main Menu....");
                    return;
                }
                else{
                    System.out.println("Invalid entry. Please try again.");
                }
            }
        }
    }
    private void openNewAccount(){
        String selection;
        String pinNum;
        System.out.print("Are you a new customer?\n" + "1) Yes\n" + "2) No\n" + ">> ");
        selection = scanner.nextLine();

        if(selection.equals("1")){
            Customer customer = createNewCustomer();
            double deposit;
            System.out.print("Enter deposit for new account: ");
            deposit = Double.parseDouble(scanner.nextLine());
            Account account = new Account(deposit);
            customer.addAccount(account);
            int accountNum = account.getAccountNumber();
            System.out.println("New account opened.");
            System.out.printf("Account number: %d\n", accountNum);
        }
        else if(selection.equals("2")){
            System.out.print("Please enter account PIN: ");
            pinNum = scanner.nextLine();
            Customer customer = bank.getCustomerByPin(pinNum);
            if (customer == null) {
                System.out.println("PIN is not valid.");
                return;
            }
            else{
                double deposit;
                System.out.print("Enter deposit for new account: ");
                deposit = Double.parseDouble(scanner.nextLine());
                Account account = new Account(deposit);
                customer.addAccount(account);
                int accountNum = account.getAccountNumber();
                System.out.println("New account opened.");
                System.out.printf("Account number: %d\n", accountNum);
            }
        }
        else{
            System.out.println("Invalid entry. Please try again.");
        }
    }
    private void getBankInfo(){
        System.out.print("Enter name of banking service: ");
        String bankService = scanner.nextLine();
        System.out.print("Enter main bank branch location: ");
        String bankLocation = scanner.nextLine();
        bankInfo = new BankInfo(bankService,bankLocation);
    }
    private Customer createNewCustomer(){
        String firstName, lastName, pinNum;
        Customer customer;
        System.out.println("Enter your first name: ");
        firstName = scanner.nextLine();
        System.out.println("Enter your last name: ");
        lastName = scanner.nextLine();
        System.out.println("Enter a 4 digit PIN number: ");
        pinNum = scanner.nextLine();
        System.out.print("Would you like to add some bank information?\n" + "1) Yes\n" + "2) No\n" + ">> ");
        String selection = scanner.nextLine();
        if(selection.equals("1")){

            customer = new Customer(firstName, lastName, pinNum);
            getBankInfo();
            bankInfo.setResponse("yes");
            bank.addCustomer(customer);
        }
        else {
            customer = new Customer(firstName, lastName, pinNum);
            bankInfo = new BankInfo();
            bankInfo.setResponse("no");
            bank.addCustomer(customer);
        }
        return customer;
    }
    private void closeAccounts(){
        String pinNum;
        System.out.print("Enter account PIN: ");
        pinNum = scanner.nextLine();
        Customer customer = bank.getCustomerByPin(pinNum);
        if (customer == null){
            System.out.println("PIN is not valid");
            return;
        }
        else{
            bank.removeCustomer(customer);
            System.out.println("All accounts for this customer have been removed, along with this customer.");
        }
    }
}
