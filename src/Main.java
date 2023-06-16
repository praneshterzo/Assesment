import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashMap<Long,Integer> Account_Details = new HashMap<Long, Integer>();
        Account_Details.put(1234567L,1234);
        Account_Details.put(9876543L,9876);
        Scanner input= new Scanner(System.in);
        System.out.println("Enter Your Choice \n1.) Sign Up \n 2.) Log in \n");
        Integer Choice=input.nextInt();
        boolean entry=false;
        ATM atm=new ATM();
        while(entry!=true){
        switch(Choice) {
            case 1:
                System.out.println("Enter your Name:");
                String Name = input.next();
                System.out.println("Enter your Unique User Id:");
                Long userid = input.nextLong();
                try {
                    atm.validateUserId(userid,Account_Details);
                    System.out.println("Enter your Pin:");
                    Integer password = input.nextInt();
                    try {
                       atm.validatePass(password);
                    }
                    catch (WrongUserIdException e) {
                        System.out.println("Error: " + e.getMessage());
                        entry=true;
                        break;
                    }
                    Account_Details.put(userid, password);
                    Signup details=new Signup(Name,userid,password);
                    System.out.println("You have been Successfully Registered");
                    entry=true;
                } catch (WrongUserIdException e) {
                    System.out.println("Error: " + e.getMessage());
                    entry=true;
                }
                entry=true;
                break;
            case 2:
                Integer Balance=(int)(Math.random()*100000);
                System.out.println("Enter your Unique User Id:");
                Long Userid = input.nextLong();
                System.out.println("Enter your Pin:");
                Integer password = input.nextInt();
                try {
                    atm.validateUserId1(Userid, Account_Details);
                    try {
                        atm.validatePass(password);
                    } catch (WrongUserIdException e) {
                        System.out.println("Error: " + e.getMessage());
                        entry = true;
                        break;
                    }
                    System.out.println("Enter the Operations to be Performed\n1.)Balance Inquiry\n2.)Cash withdrawal\n3.)Cash Deposit");
                    Integer ch = input.nextInt();
                    switch (ch) {
                        case 1:
                            System.out.println("Your Available balance is" + Balance);
                            entry = true;
                            break;
                        case 2:
                            System.out.println("Your Available Balance is" + Balance);
                            System.out.println("Enter the amount need to be Withdrawn");
                            Integer amount = input.nextInt();
                            try {
                                atm.validateBalance(Balance, amount);
                            } catch (WrongUserIdException e) {
                                System.out.println("Error: " + e.getMessage());
                                entry = true;
                                break;
                            }
                            System.out.println("Amount has been withdrawn");
                            System.out.println("Remaining balance is" + (Balance - amount));
                            entry = true;
                            break;
                        case 3:
                            System.out.println("Your Available Balance is" + Balance);
                            System.out.println("Enter the amount need to be Deposited only less 10000 and more than 1000");
                            Integer deposit = input.nextInt();
                            try {
                                atm.validateDeposit(Balance, deposit);
                            } catch (WrongUserIdException e) {
                                System.out.println("Error: " + e.getMessage());
                                entry = true;
                                break;
                            }
                            System.out.println("Amount has been Deposited");
                            System.out.println("Remaining balance is" + (Balance + deposit));
                            entry = true;
                            break;
                        default:
                            entry = true;
                            break;
                    }
                }
                catch(WrongUserIdException e){
                        System.out.println("Error: " + e.getMessage());
                        entry = true;
                    }
                    entry = true;
                    break;
        }
        }
    }
    }

