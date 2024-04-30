import java.util.Scanner;

public class BankInfo extends Bank{
    private String bankService;
    private String bankLocation;
    private String Response;
private Scanner scanner =new Scanner(System.in);
  private BankInfo bankInfo;

    //private HashMap<Customer,BankInfo> customerBankInfoHashMap = new HashMap<>();

    public BankInfo(String bankService, String bankLocation) {
        this.bankService = bankService;
        this.bankLocation = bankLocation;
    }
    public BankInfo(){

    }
    public void setResponse(String response){
        if(response.equals("yes")){
            this.Response = "yes";
        }
        else{
            this.Response = "no";
        }

    }
    public String getResponse(){
        return Response;
    }
    public String getBankService(){
        return bankService;
    }
    public String getBankLocation(){
        return bankLocation;
    }
    public void setBankService(String bankName){
        bankService = bankName;
    }
    public void setBankLocation(String locationDetails){
        bankLocation = locationDetails;
    }
    @Override
    public String toString() {
        return "Bank Service: " + getBankService()+"\n"+"Branch location: " + getBankLocation() +"\n";
    }
}