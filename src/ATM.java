import java.util.HashMap;

class ATM {
    public void validateUserId(Long Userid, HashMap Accdetails) throws WrongUserIdException {
        if (Accdetails.containsKey(Userid)) {
            throw new WrongUserIdException("Invalid User ID");
        }
    }
    public void validateUserId1(Long Userid, HashMap Accdetails) throws WrongUserIdException {
        if (!Accdetails.containsKey(Userid)) {
            throw new WrongUserIdException("Invalid User ID");
        }
    }
    public void validatePass(Integer Password) throws WrongUserIdException{
        if(Password>10000 || Password <1000 ){
         throw new WrongUserIdException("Invalid Password");
        }
    }
    public void validateBalance(Integer Balance,Integer Amount) throws WrongUserIdException{
        if(Balance-Amount<0){
            throw new WrongUserIdException("Unavailable Balance");
        }
    }
    public void validateDeposit(Integer Balance,Integer Deposit) throws WrongUserIdException{
        if(Deposit>100000 ||Deposit<1000){
            throw new WrongUserIdException("Amount Cannot be deposited Contact Branch");
        }
    }
}