package lab5pkgForProject2;

public class Account {
	 private final AccountType type;
	    private double balance;
	    private String accountnumber;

	    public Account(AccountType accType, double accBalance,String accountnum){
	        type = accType;
	        balance = accBalance;
	        accountnumber=accountnum;

	    }

	    public String getType(){
	        return type.longName();
	    }
	    public String getaccountnumber(){
	        return accountnumber ;
	    }

	    public AccountType getAccountType(){
	        return type;
	    }
	   
	    

	   public void setBallance(double bal){
		   this.balance=bal;
	   } 
	    
	    
	    public double currentBalance(){
	        return balance;
	    }

	    public double calcInterest(int days){
	        double totalInterest, daysInterest;
	        totalInterest = balance * type.interestRate();
	        daysInterest = totalInterest * ((double)days/365.25);
	        return daysInterest;
	    }

}
