import java.util.HashMap;

public class Bank {
    private HashMap<Key, Customer> customerHashMap = new HashMap();

    public void addCustomer(Customer customer){
        customerArrayList.add(customer);
    }
    public void removeCustomer(Customer customer){
        customerArrayList.remove(customer);
    }
    public ArrayList<Customer> getCustomerArrayList(){
        return customerArrayList;
    }
    public Customer getCustomerByPin(String pinNum){
        Customer foundCustomer = null;
        for(Customer customer : customerArrayList){
            if(customer.getPinNum().equals(pinNum)){
                foundCustomer = customer;
                break;
            }
        }
        return foundCustomer;
    }
    public StringBuilder getAllCustomerInfo(){
        StringBuilder customers = new StringBuilder();
        for(Customer customer : customerArrayList){
            customers.append(customer + "\n");
        }
        return customers;
    }
}
