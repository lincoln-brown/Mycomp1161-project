package project2;


import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.*;

public class WidthdrawAccountSelect extends JFrame   {
	private String Output;
	JTextArea OutPutConsole;
	JButton  b1;
	JButton  b2;
	JButton  b3;
	JButton  b4;
	JButton  b5;
	JButton  b7;
	JButton  b8; 
	public WidthdrawAccountSelect(){
		
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
		 MainPanel.setPreferredSize (new Dimension(960,480));
		 MainPanel.setLayout(new BorderLayout());
		 WESTPanel.setLayout(new BoxLayout(WESTPanel,BoxLayout.PAGE_AXIS)); 
		 EASTPanel.setLayout(new BoxLayout(EASTPanel,BoxLayout.PAGE_AXIS)); 
		 
			
			
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
		 b1 =new JButton("      1     ");
		 b2 =new JButton("      2    ");
		 b3 =new JButton("      3     ");
		 b4 =new JButton("      4    ");
		 b5 =new JButton("      5     ");
		 JButton  b6 =new JButton("------------");
		 b7 =new JButton("BUSINESS ACCOUNT");
		 b8 =new JButton("CANCEL");
		 b1.setPreferredSize(new Dimension (100,100));
		 b2.setPreferredSize(new Dimension (100,100));		
		 b3.setPreferredSize(new Dimension (100,100));		
		 b4.setPreferredSize(new Dimension (100,100));		
		 b5.setPreferredSize(new Dimension (100,100));		
		 b6.setPreferredSize(new Dimension (100,100));		
		 b7.setPreferredSize(new Dimension (160,100));		
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
		 
		 JPanel TextAreaPanel = new JPanel();
		 OutPutConsole =new JTextArea();
		 OutPutConsole.setPreferredSize(new Dimension (500,200));;
         OutPutConsole.setEditable(false);
		 OutPutConsole.setOpaque(false);
		 
		 OutPutConsole.setBorder(BorderFactory.createLineBorder(Color.black,2));
		
		 TextAreaPanel.add(OutPutConsole,BorderLayout.CENTER); 
		 MainPanel.add(TextAreaPanel,BorderLayout.CENTER); 
//----------------------------SOUTH PANEL----------------------------------------------------
		 SOUTHPanel.setSize(15,10);
		 MainPanel.add(SOUTHPanel,BorderLayout.SOUTH);
//----------------------------------------------------------------------------------------		 
		 this.getContentPane().add(MainPanel);
		 this.pack();
		// this.setVisible(true);
		
	}
public void addwidthdrawAListener(ActionListener Alistener) {
		
		b1.addActionListener(Alistener);
	}
public void addBListener(ActionListener Blistener) {
	
	b2.addActionListener(Blistener);
}
public void addCListener(ActionListener Clistener) {
	
	b3.addActionListener(Clistener);
}
public void addDListener(ActionListener Dlistener) {
	
	b4.addActionListener(Dlistener);
}
	
	
	
	
	public void setOutPut(String Text){
		
		
		 OutPutConsole.setText(Text);	
	}
	
	
	
	
	
	
	
	
	public static void main(String[] args)
	{
		WidthdrawAccountSelect Frame = new WidthdrawAccountSelect();
	}
	
	
	
	
	
	
	
	
	
	
	

}
