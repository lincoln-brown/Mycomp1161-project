package project2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.*;



public class Menus extends JFrame {
	JButton  b5;
	JButton  b6;
	JButton  b7;

	public Menus(){
		
		//-------------------------Main instansiations -----------------------------
		 this.setTitle("JLCB BANKING ");
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 this.setLocation(300, 2);
		 JPanel MainPanel = new JPanel();
		 JPanel NORTHPanel = new JPanel();
		 Date d = new Date();
		 JPanel WESTPanel = new JPanel();
		 JPanel EASTPanel = new JPanel();
		 JPanel SOUTHPanel = new JPanel();
		 JPanel CENTERPanel = new JPanel();
		 MainPanel.setPreferredSize (new Dimension(960,480));
		 MainPanel.setLayout(new BorderLayout());
		 WESTPanel.setLayout(new BoxLayout(WESTPanel,BoxLayout.PAGE_AXIS)); 
		 EASTPanel.setLayout(new BoxLayout(EASTPanel,BoxLayout.PAGE_AXIS)); 
		 CENTERPanel.setLayout(new  GridBagLayout());
			
			
	//-------------------------textArea located at top ------------------------------------
		 JTextArea NorthTextArea = new JTextArea();
			//(+ d.toString(),SwingConstants.CENTER);
			//NorthTextArea.(d.toString());
			NorthTextArea.setEditable(false);
			NorthTextArea.setOpaque(false);
			
			NorthTextArea.setText("JLCB AUTO MATED BANKING MACHINE\n      ");
			NorthTextArea.append(d.toString());
			NORTHPanel.add(NorthTextArea,BorderLayout.CENTER);
			
			MainPanel.add(NORTHPanel,BorderLayout.NORTH);
			NorthTextArea.setFont(new Font("Calibri",Font.ITALIC,30));
	//---------buttons AND WEST AND EAST FRAME --------------------------------------
			 JButton  b1 =new JButton("-----------");
			 JButton  b2 =new JButton("-----------");
			 JButton  b3 =new JButton("-----------");
			 JButton  b4 =new JButton("-----------");
		 b5 =new JButton("BALANCE QUERY");
		 b6 =new JButton(" WITHDRAW  ");
		 b7 =new JButton("  DEPOSIT  ");
		 JButton  b8 =new JButton("----------------");
		 b1.setPreferredSize(new Dimension (100,100));
		 b2.setPreferredSize(new Dimension (100,100));		
		 b3.setPreferredSize(new Dimension (100,100));		
		 b4.setPreferredSize(new Dimension (100,100));		
		 b5.setPreferredSize(new Dimension (150,100));		
		 b6.setPreferredSize(new Dimension (150,100));		
		 b7.setPreferredSize(new Dimension (150,100));		
		 b8.setPreferredSize(new Dimension (150,100));		
		 WESTPanel.add(Box.createRigidArea(new Dimension(50,80)));
		 WESTPanel.add(b1);
		 WESTPanel.add(Box.createRigidArea(new Dimension(30,50)));		 
		 WESTPanel.add(b2);
		 WESTPanel.add(Box.createRigidArea(new Dimension(30,50)));
		 WESTPanel.add(b3);
		 WESTPanel.add(Box.createRigidArea(new Dimension(30,50)));
		 WESTPanel.add(b4);
		 
		 
		 EASTPanel.add(Box.createRigidArea(new Dimension(30,80)));
		 EASTPanel.add(b5);
		 EASTPanel.add(Box.createRigidArea(new Dimension(30,50)));
		 EASTPanel.add(b6);
		 EASTPanel.add(Box.createRigidArea(new Dimension(30,50)));
		 EASTPanel.add(b7);
		 EASTPanel.add(Box.createRigidArea(new Dimension(30,50)));
		 EASTPanel.add(b8);
		 
		 MainPanel.add(WESTPanel,BorderLayout.WEST);
		 MainPanel.add(EASTPanel,BorderLayout.EAST);
		 
		 
		//--------------center PANEL ---------------------------------
		 
		 JLabel EnterCardLabel =new JLabel("PLEASE SELECT FROM THE BUTTONS ON THE RIGHT");
		 
		 EnterCardLabel.setFont(new Font("Calibri",Font.BOLD,20));
		 CENTERPanel.add(EnterCardLabel);
		
		
		 MainPanel.add(CENTERPanel,BorderLayout.CENTER); 
//----------------------------SOUTH PANEL----------------------------------------------------
		 SOUTHPanel.setSize(15,10);
		 MainPanel.add(SOUTHPanel,BorderLayout.SOUTH);
//----------------------------------------------------------------------------------------		 
		 this.getContentPane().add(MainPanel);
		 this.pack();
		// this.setVisible(true);
		 
		 
		
		 
		
		 
		 
		 
		
	}
	
	
	
public void addbalancequaryctionListener(ActionListener Balancequarylistener) {
		
		b5.addActionListener(Balancequarylistener);
	}
public void addwidthdrawListener(ActionListener widthdrawlistener) {
	
	b6.addActionListener(widthdrawlistener);
}
public void adddepositListener(ActionListener depositelistener) {
	
	b7.addActionListener(depositelistener);
}

	
	public static void main(String[] args)
	{
		//Menus Frame = new Menus();
	}
	
	
	
	
	
	
	
	
	
	
	

}
