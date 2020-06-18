package lab5pkgForProject2;
import java.util.ArrayList;

public abstract class Client {
	private String TRN;
	 protected String clientid, telephone, name,name2nd ,CardNum,acctnumber;
	    protected ArrayList<Address> addresses;
	    protected  ArrayList<Account> accounts;
	    
	    
	    public abstract String getFullName();
	    public abstract String getName();

	    public Client(String clid, String name_, String name2,String address_, String parish_,
	                  String tel_,String trn, String Cardno){
	        accounts = new ArrayList<Account>();
	        addresses = new ArrayList<Address>();
	        // Parish pa = Parish.KingstonStAndrew;  // default parish
	        Parish pa = Parish.findByName(parish_);

	        addresses.add(new Address(address_, pa));
	        telephone = tel_;
	        name = name_;
	        name2nd=name2;
	        clientid = clid;
	        this.TRN = trn;
	        this.CardNum=Cardno;
	        
	    }
	    
	    public String getCArdNumber(){
	    	return CardNum;
	    }
	    
	    public String getClientId(){
	    	return clientid;
	    }
	    
	   

	    public void addAccount(Account account){
	        accounts.add(account);
	    }
	    
	    public void withdrawal (double wd, Account ac){
	    	if (ac.getAccountType()==AccountType.chequing){
	    		for(Account a:accounts){
	    			if(a.getAccountType()==AccountType.chequing){
	    				a.setBallance(a.currentBalance()-wd-15);
	    				break;
	    			}
	    		}
	    	}else {
	    		for(Account a:accounts){
	    			if (a.getAccountType()==ac.getAccountType()){
	    				a.setBallance(a.currentBalance()-wd);
	    				break;
	    			}
	    		}
	    	}
	    	}
	    
	    public void deposit(double dp, Account ac){
	    	if (ac.getAccountType()==AccountType.investment){
	    		for(Account a:accounts){
	    			if(a.getAccountType()==AccountType.investment){
	    				a.setBallance(a.currentBalance()+dp-120);
	    				break;
	    			}
	    		}
	    	}else {
	    		for(Account a:accounts){
	    			if (a.getAccountType()==ac.getAccountType()){
	    				a.setBallance(a.currentBalance()+dp);
	    				break;
	    			}
	    		}
	    	}
	    }
	    public String  getPin(){
	    	
	    	return telephone;
	    }    
	        
	        
	        
	    
	    public void addAccount(String type, double balance,String acctnum){
	        type = String.join("", type.split(" "));
	        AccountType act = AccountType.valueOf(type);
	        addAccount(new Account(act, balance,acctnum));
	    }
	    public void addAddress(Address addr_){
	        addresses.add(addr_);
	    }

	    public Account getAccount(int seq){
	        if (seq < accounts.size())
	            return accounts.get(seq);
	        else
	            return null;
	    }
	    public ArrayList<Account> getAccounts(){
	        return this.accounts;
	    }

	    public Parish getPrimaryParish(){
	        Address p;
	        try{
	            p = this.addresses.get(0);
	        }
	        catch(Exception e){
	            p = null;
	        }
	        return p.getParish();
	    }
     
       
       
	    public String toString2(){
	        String f = "Client: %s (%s)\n  Tel: %s%s%s \n TRN: %s";
	        String aa, ac;
	        ac = "\n  Accounts:";
	        for (Account a : accounts){
	            ac += String.format("\n    %-20s:    $%,12.2f", a.getType(), a.currentBalance());
	        }
	        aa = "\n  Address:";
	        for (Address b: addresses){
	            aa += String.format("\n    %s", b.toString());
	        }
	        return String.format(f, name, clientid, telephone, ac, aa,TRN);

	    }
	    public String toString(){
	    	String ac="" ;
	    
	    	 for (Account a : accounts){
		            ac += String.format("\n    %-20s:    $%,12.2f", a.getType(), a.currentBalance());
	    	
	    	 }
	    	return ac;
	    }

}
