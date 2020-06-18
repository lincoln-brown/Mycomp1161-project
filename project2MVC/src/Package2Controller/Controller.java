package Package2Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import lab5pkgForProject2.Account;
import lab5pkgForProject2.Client;
import lab5pkgForProject2.Lab5Main;
import project2.Deposit;
import project2.DipositAccountSelect;
import project2.WidthdrawAccountSelect;
import project2.BadPinLogin;
import project2.BalanceQuaryFrame;
import project2.CardLogin;
import project2.EnterPIN;
import project2.Menus;
import project2.Widthdarw;

public class Controller {
	private Lab5Main Backend;
	CardLogin CardLogin;
	EnterPIN EnterPin;
	Menus Menu;
	BadPinLogin Error;
	BalanceQuaryFrame BalanceQuary;
	WidthdrawAccountSelect Accountselect;
	DipositAccountSelect DAccountselect;
	Widthdarw Withdraw;
	Deposit diposit;
	String CardNumber;
	String pin;
	int seq;
	ArrayList<Client> clientdata ;
	public Controller(Lab5Main Backend,CardLogin cl,EnterPIN EnterPin,Menus Menu,BadPinLogin Error,WidthdrawAccountSelect Accountselect,
			BalanceQuaryFrame Balnceq,Widthdarw withdraw,DipositAccountSelect DAccountselect,Deposit diposit){
		this.Backend=Backend;
		this.CardLogin=cl;
		this.EnterPin=EnterPin;
		this.Menu=Menu;
		this.Error=Error;
		this.Accountselect=Accountselect;
		this.BalanceQuary=Balnceq;
		this.Withdraw=withdraw;
		this.DAccountselect=DAccountselect;
		this.diposit=diposit;
		cl.setVisible(true);
		cl.addb8ActionListener(new b8ActionListener());//used
		EnterPin.addb8ActionListener(new EnterPINb8listener());//used
		Error.addb8ActionListener(new ErrorListener());//used
		Menu.adddepositListener(new depositelistener());//used
		Menu.addwidthdrawListener(new widthdrawlistener());//used
		Menu.addbalancequaryctionListener(new Balancequarylistener());//used
		Accountselect.addwidthdrawAListener(new widthdrawAlistener());//used
		withdraw.adddcontinueListener(new continuelistener());//used
		Balnceq.adddMenuListener(new Menulistener());//used
		Balnceq.adddExitListener(new Exitlistener());//used
		DAccountselect.adddepositAListener(new dipositAlistener());
		diposit.addDepositcontinueListener(new Depositcontinuelistener());
		
		}
	class Depositcontinuelistener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			int amount = Integer.parseInt(diposit.DepositAmount());
			for (Client c:clientdata){
				if(c.getCArdNumber().equals(CardNumber)){
					ArrayList<Account> accounts = c.getAccounts();
					if (accounts.size()>=seq){
						Backend.deposit(amount, accounts.get(seq),CardNumber);
						BalanceQuary.setOutPut( Backend.Getbalance(CardNumber));	//depositing 
						diposit.SetdepositFieldtoempty();
						diposit.dispose();
						BalanceQuary.setVisible(true);
			
					}}
			
			
		}}}
	
	
	
	
	class dipositAlistener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			seq=0;
			DAccountselect.dispose();
			diposit.setVisible(true);
		}
		
		
		
	}
	
	
	
	class Exitlistener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			Menu.dispose();
			BalanceQuary.dispose();	
			
		}
		
		
		
	}
	class Menulistener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			BalanceQuary.dispose();
			Menu.setVisible(true);
		}
}
		
	// this is for the continue button on the screen whereu in but the amout yo are witdrawing	
	class continuelistener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			
				int amount = Integer.parseInt(Withdraw.WidthdrawAmount());
				
				for (Client c:clientdata){
					if(c.getCArdNumber().equals(CardNumber)){
						ArrayList<Account> accounts = c.getAccounts();
						if (accounts.size()>=seq){
							Backend.withdraw(amount, accounts.get(seq),CardNumber);
							BalanceQuary.setOutPut( Backend.Getbalance(CardNumber));	//widthdrawing 
							Withdraw.SetwidthdrawFieldtoempty();
							Withdraw.dispose();
							BalanceQuary.setVisible(true);
							
						}// you can put an erro cscree here if the acount can not be found
					}
					}
				}
		}
		
		
		
		
	

	class widthdrawAlistener implements ActionListener {
		

		public void actionPerformed(ActionEvent arg0) {
			seq=0;
			Withdraw.setVisible(true);
			Accountselect.dispose();
			
		}
		
		} 
		
class depositelistener implements ActionListener{

	public void actionPerformed(ActionEvent arg0) {
		for(Client c:clientdata){			
			if (CardNumber.equalsIgnoreCase(c.getCArdNumber())&& pin.equalsIgnoreCase(c.getPin()))
			{DAccountselect.setOutPut( Backend.Getbalance(CardNumber));
			DAccountselect.setVisible(true);
			Menu.dispose();
				}
			}
				
			}
		
	}


class widthdrawlistener implements ActionListener{

	public void actionPerformed(ActionEvent arg0) {
		for(Client c:clientdata){			
			if (CardNumber.equalsIgnoreCase(c.getCArdNumber())&& pin.equalsIgnoreCase(c.getPin()))
			{Accountselect.setOutPut( Backend.Getbalance(CardNumber));
			Accountselect.setVisible(true);
			Menu.dispose();
				}
			}
		
	}
	
}



class Balancequarylistener implements ActionListener {

	public void actionPerformed(ActionEvent arg0) {
		for(Client c:clientdata){			
			if (CardNumber.equalsIgnoreCase(c.getCArdNumber())&& pin.equalsIgnoreCase(c.getPin()))
			{BalanceQuary.setOutPut( Backend.Getbalance(CardNumber));
			BalanceQuary.setVisible(true);
			Menu.dispose();
				}
			}
		
	}
	
}
	
	
	
class ErrorListener implements ActionListener{

	public void actionPerformed(ActionEvent arg0) {
		CardLogin.setVisible(true);
		EnterPin.SetpaswordfeildToNull();
		Error.dispose();
	}
	
	
	
}	
		
		 
		
class b8ActionListener  implements  ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			clientdata = Backend.CardCheck();
			CardNumber = CardLogin.getCardNmber();
			for(Client c:clientdata){
				if (CardNumber.equals(c.getCArdNumber())){
					CardLogin.dispose();
					EnterPin.setVisible(true);
					
					
				}
				else{
					CardLogin.SetTextFielssToNull();
					
				}
			}
			
		}}
		
class EnterPINb8listener implements ActionListener {

	public void actionPerformed(ActionEvent arg0) {
		//ArrayList<Client> clientdata = Backend.CardCheck();
		// CardNumber = CardLogin.getCardNmber();
		
		pin = EnterPin.getpin();
		for(Client c:clientdata){			
		if (CardNumber.equalsIgnoreCase(c.getCArdNumber())&& pin.equalsIgnoreCase(c.getPin()))
		{
			Menu.setVisible(true);
			EnterPin.dispose();
			break;
			}else{
				Error.dispose();
				EnterPin.dispose();;
			}
		}
		
	}
	
	
	
	
	
}		
	
		
		
		
	
	
	
 public static void main(String[] args){
	 Lab5Main Backend=new Lab5Main();
	 CardLogin cl =new CardLogin();
	 EnterPIN EnterPin =new EnterPIN();
	 Menus Menu =new Menus();
	 BadPinLogin Error =new BadPinLogin();
	 WidthdrawAccountSelect Accountselect =new WidthdrawAccountSelect();
	 BalanceQuaryFrame BalanceQuary = new BalanceQuaryFrame();
	 Widthdarw Withdraw =new Widthdarw();
	 DipositAccountSelect DAccountselect =new DipositAccountSelect();
	 Deposit diposit =new Deposit();
	 new Controller(Backend, cl, EnterPin, Menu, Error, Accountselect, BalanceQuary, Withdraw, DAccountselect, diposit);
 }
 





}
