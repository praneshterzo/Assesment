public class Signup {
    private String CustomerName;
    private Long AccountNumber;
    private Integer Passcode;
    public Signup(String CustomerName,Long AccountNumber,Integer Passcode){
        this.CustomerName=CustomerName;
        this.AccountNumber=AccountNumber;
        this.Passcode=Passcode;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public Long getAccountNumber() {
        return AccountNumber;
    }

    public Integer getPasscode() {
        return Passcode;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public void setAccountNumber(Long accountNumber) {
        AccountNumber = accountNumber;
    }

    public void setPasscode(Integer passcode) {
        Passcode = passcode;
    }
}
