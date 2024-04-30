import java.util.ArrayList;

public class Customer {
    protected String firstName;
    protected String lastName;
    protected String pinNum;
    protected ArrayList<Account> accountArrayList = new ArrayList<>();


    public Customer(String firstName, String lastName, String pinNum){
        this.firstName = firstName;
        this.lastName = lastName;
        this.pinNum = pinNum;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getPinNum(){
        return pinNum;
    }
    public void addAccount(Account account){
        accountArrayList.add(account);
    }
    public void removeAccount(Account account){
        accountArrayList.remove(account);
    }
    public Account getSingleAccount(int accountNum){
        Account accountFound = null;
        for(Account account: accountArrayList){
            if(account.getAccountNumber()== accountNum){
                accountFound = account;
                break;
            }
        }
        return accountFound;
    }
    public StringBuilder getAllAccountInfo(){
        StringBuilder accounts = new StringBuilder();
        for (Account account : accountArrayList){
            accounts.append(account + "\n");
        }
        return accounts;
    }
    @Override
    public String toString(){
        return String.format("Name: %s %s PIN: %s", firstName, lastName, pinNum);
    }
}
