import java.util.HashMap;

public class Bank {
    private HashMap<Customer, String> customerHashMap = new HashMap();

    public void addCustomer(Customer customer){
        customerHashMap.put(customer, customer.getFirstName());
    }
    public void removeCustomer(Customer customer){
        customerHashMap.remove(customer);
    }
    public HashMap<Customer, String> getCustomerHashMap(){
        return customerHashMap;
    }
    public Customer getCustomerByPin(String pinNum){
        Customer foundCustomer = null;
        for(Customer customer : customerHashMap.keySet()){
            if(customer.getPinNum().equals(pinNum)){
                foundCustomer = customer;
                break;
            }
        }
        return foundCustomer;
    }
    public StringBuilder getAllCustomerInfo(){
        StringBuilder customers = new StringBuilder();
        for(Customer customer : customerHashMap.keySet()){
            customers.append(customer + "\n");
        }
        return customers;
    }
}
