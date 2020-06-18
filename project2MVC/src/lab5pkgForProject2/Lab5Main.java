package lab5pkgForProject2;
import java.io.IOException;
import java.util.*;


public class Lab5Main {

    // ToDo: Create a private ArrayList to hold a single type that can
    // be used to access client and account information.
    // e.g.
    private static  ArrayList<Client> clientData;
    // change YOUR_CLASS to reflect the actual class whose instances
    // will be in the clientData ArrayList;
    
    
    
    
    SimpleData c =new SimpleData();

    private void createObjects(){String[] accountInfo, ai;
    ArrayList<String[]> DataFiles =new ArrayList();
	   String a;
    
    try {
 	 
 	   
 	  DataFiles =c.ReadCSV("Book1.txt",",");
 	// a=Arrays.toString(s.get(1)); this turns the array into a string 
 	  //s is a list of arrays, each line of data in the txt file  is an array 
 	  
		//System.out.println(s.get(1)[0]+","+s.get(1)[1]+","+s.get(1)[2]);
	} catch (IOException e) {
		
		e.printStackTrace();
	}
    clientData = new ArrayList<Client>();
    Client c;
    ArrayList<String> clientIdList = new ArrayList<String>();
    String clid;
    int clientIndex;
    for (int i=1; i<DataFiles.size(); i++ ) {
        // accountInfo = accountData.get(i);
        ai = DataFiles.get(i);
        // columns: 0-id, 1-name, 2-accType, 3-balance, 4-address, 5-parish, 6-phone
        clid = ai[0];
        clientIndex = clientIdList.indexOf(clid);
        if (clientIndex >= 0){
            c = clientData.get(clientIndex);
           // System.out.println("Found " + clid);
            Address addr = new Address(ai[5], ai[6]);
            
        } else {
            clientIndex = clientIdList.size();
            clientIdList.add(clid);
            c = new PersonalClient(ai[0], ai[1],ai[2], ai[5], ai[6], ai[7],ai[8],ai[9]);
            clientData.add(c);
        }
        
        c.addAccount(ai[3], Double.parseDouble(ai[4]),ai[10]);
    }
    }
    
//-----------------checking pin from client data----------------------------   
    
  public static boolean PinCheck(String pin ,String card){
    	
    	for (Client c:clientData){
    		if (pin.equals(c.getPin() )   && card.equals(c.getCArdNumber()))
    		{
    			return true;
    		}
    		//System.out.println(pin);
    	}
    	return false;
    	
    }
  
  
  //----------------show balace -----------------------------
  
  public   String Getbalance(String card){
	  String balance ="";
	  String head ="AccountSequence  AccountNumber\tAccountType\tBalance \n";
	  int i=0;
	  String seq;
	  //Account account;
	  
	  for (Client c:clientData){
		   
		  if (card.equals(c.getCArdNumber())){
			  ArrayList<Account> allaccount =new ArrayList<Account>();
			  allaccount= c.getAccounts();
			  for (Account a:allaccount){
				  i++;
				seq=String.valueOf(i);
				  balance="  "+seq+"\t"+a.getaccountnumber()+"\t"+a.getType()+"\t"+Double.toString(a.currentBalance())+"\n"+balance; 
				 } 
			  //System.out.println(balance);
		  }
		  else {
			 // System.out.println(c.getCArdNumber() );
		  }
		  }
	 
	  return head+balance  ;  
  }
  
  
  
  
  
  
  
  
  //----------------checking cardnumber for data---------------------
    
  public ArrayList<Client> CardCheck(){
  	
 
  	return clientData;
  	
  }  
  
  
  
  //used
    
    public void withdraw(int amunt, Account ac, String cardnum){
    	
    	for (Client p:clientData){
    		if(p.getCArdNumber().equals(cardnum)){
    			p.withdrawal (amunt, ac);
    			}
    			//System.out.println("BALANCE IS"p.);
    		}
    	
    	
    	}
    
    
    public void deposit(int amunt, Account ac, String cardnum ){
        	
    	for (Client p:clientData){
    		if(p.getCArdNumber().equals(cardnum));{
    			p.deposit(amunt, ac);
    			//System.out.println("BALANCE IS"p.);
    		}
    	}
    }
    
    
    public static String AllAcounts(){
    	String Clients="";
    	  for(Client c:clientData){
          Clients+=	c.toString();
          	}
    	
    	return Clients;
    }
    
    

    public double totalFunds(){

        double mgmtTotal = 0;
        for (Client k: clientData){
            ArrayList<Account> accs = k.getAccounts();
            for (int i = 0; i < accs.size(); i++){
                mgmtTotal += accs.get(i).currentBalance();
            }
        }
        return mgmtTotal;
        // ToDo:
        // complete this method that will loop through clientData to 
        // extract the balance for accounts contained within to 
        // general a total that is then returned.
       
    }

  

    public Lab5Main(){
        // instantiate accountData, the arraylist with string arrays
      
        createObjects();
    }
    
 

   public static void main(String[] args){
      /*  Lab5Main m = new Lab5Main();
        double fundsUnderManagement = m.totalFunds();
        System.out.printf("The total sum under management is %,.2f",
                          fundsUnderManagement);*/
       // SimpleData h =new SimpleData ();
	   
	   
	   
	   
     /*  try {
    	   ArrayList<String[]> s =new ArrayList();
    	   String a;
    	   
    	  s=SimpleData.ReadCSV("Book1.txt",",");
    	// a=Arrays.toString(s.get(1)); this turns the array into a string 
    	  //s is a list of arrays, each line of data in the txt file  is an array 
    	  
		System.out.println(s.get(1)[0]+","+s.get(1)[1]+","+s.get(1)[4]);
	} catch (IOException e) {
		
		e.printStackTrace();
	}
       
       
       
      /*  for(Client c:clientData){
        	System.out.println(c.toString());
        }
      
       m.withdraw();
       
       for(Client c:clientData){
       	System.out.println(c.toString());
       }
       m.deposit();
       
       
       
      
       
       for(Client c:clientData){
          	System.out.println(c.toString());
          }*/

        // ToDo: print out some of the values in clientData
        // no more than 6 entries.
    }
}
