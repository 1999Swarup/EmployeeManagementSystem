package ed;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Add_Employee implements ActionListener{
	
	JFrame fadd;
	JLabel lai1,la2,lid,lln,lfn,ldn,ls,ladrs,lphn;
	JTextField tid,tln,tfn,tdn,ts,tadrs,tphn;
	JButton bsubmit,bcancel;

	Add_Employee(int i){ }
	
	Add_Employee(){
	        fadd = new JFrame("Add Employee");
	        fadd.setBackground(Color.white);
	        fadd.setLayout(null);
	        
	    	JPanel p=new JPanel();
			p.setBounds(0,350, 1000, 1000);
			p.setBackground(Color.YELLOW);
			

	        lai1=new JLabel();
	        lai1.setBounds(0,0,900,700);
	        lai1.setBackground(Color.magenta);
	        lai1.setLayout(null);
	        fadd.add(lai1);
	     /*   ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("C:\\Users\\This PC\\OneDrive\\Desktop\\eclipse\\EmployeeManagementSystem\\EMS\\src\\icons\\add_employee.jpg"));
	        lai1.setIcon(img);*/
	        
	        la2 = new JLabel("New Employee Details");
	        la2.setBounds(320,30,500,50);
	        la2.setFont(new Font("serif",Font.ITALIC,25));
	        la2.setForeground(Color.black);
	        lai1.add(la2);
	       
	        
	        lid = new JLabel("EmployeeID");
	        lid.setBounds(50,150,140,30);
	        lid.setFont(new Font("serif",Font.BOLD,20));
	        lai1.add(lid);

	        tid=new JTextField();
	        tid.setBounds(200,150,150,30);
	        lai1.add(tid);

	        lln = new JLabel("LastName");
	        lln.setBounds(400,150,200,30);
	        lln.setFont(new Font("serif",Font.BOLD,20));
	        lai1.add(lln);

	        tln=new JTextField();
	        tln.setBounds(600,150,150,30);
	        lai1.add(tln);

	        lfn= new JLabel("FirstName");
	        lfn.setBounds(50,200,100,30);
	        lfn.setFont(new Font("serif",Font.BOLD,20));
	        lai1.add(lfn);

	        tfn=new JTextField();
	        tfn.setBounds(200,200,150,30);
	        lai1.add(tfn);

	        ldn= new JLabel("Department");  
	        ldn.setBounds(400,200,200,30);
	        ldn.setFont(new Font("serif",Font.BOLD,20));
	        lai1.add(ldn);

	        tdn=new JTextField();
	        tdn.setBounds(600,200,150,30);
	        lai1.add(tdn);

	        ls= new JLabel("Salary");
	        ls.setBounds(50,250,100,30);
	        ls.setFont(new Font("serif",Font.BOLD,20));
	        lai1.add(ls);

	        ts=new JTextField();
	        ts.setBounds(200,250,150,30);
	        lai1.add(ts);

	        ladrs= new JLabel("Address");
	        ladrs.setBounds(400,250,100,30);
	        ladrs.setFont(new Font("serif",Font.BOLD,20));
	        lai1.add(ladrs);

	        tadrs=new JTextField();
	        tadrs.setBounds(600,250,150,30);
	        lai1.add(tadrs);

	        lphn= new JLabel("PhoneNumber");
	        lphn.setBounds(50,300,150,30);
	        lphn.setFont(new Font("serif",Font.BOLD,20));
	        lai1.add(lphn);

	        tphn=new JTextField();
	        tphn.setBounds(200,300,150,30);
	        lai1.add(tphn);
	       
	        /* ******************* Doubt ***********************
	        lab=new JLabel();
	        lab.setBounds(200,450,250,200);
	        lai1.add(lab);

	        lab1=new JLabel("");
	        lab1.setBounds(600,450,);
	        ************************************************ */
	        
	        bsubmit = new JButton("Submit");
	        bsubmit.setBackground(Color.BLACK);
	        bsubmit.setForeground(Color.WHITE);
	        bsubmit.setBounds(250,550,150,40);
	        bsubmit.addActionListener(this);
	        lai1.add(bsubmit);

	        bcancel=new JButton("Cancel");   
	        bcancel.setBackground(Color.BLACK);
	        bcancel.setForeground(Color.WHITE);
	        bcancel.setBounds(450,550,150,40);
	        bcancel.addActionListener(this);
	        lai1.add(bcancel);
	        
	     
	        fadd.setVisible(true);
	        fadd.setSize(900,700);
	        fadd.setLocation(400,150);
	        
	        fadd.add(p);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
             new Add_Employee();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		//Getting all the TextFields down here tid,tln,tfn,tdn,ts,tadrs,tphn
		String a1=tid.getText();
		int a=Integer.parseInt(a1);
		String b=tln.getText();
		String c=tfn.getText();
		String d=tdn.getText();
		String e1=ts.getText();
		int e=Integer.parseInt(e1);
		String f=tadrs.getText();
		String g1=tphn.getText(); 
		int g=Integer.parseInt(g1);
		
		if(ae.getSource() == bsubmit){
            try{
                ConnectorClass c2 = new ConnectorClass();
                String q = "insert into employeedetails values('"+a+"','"+b+"','"+c+"','"+d+"','"+e+"','"+f+"','"+g+"')";
                c2.s.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Details Successfully Inserted");
                fadd.setVisible(false);
                new details();
            }catch(Exception ee){
                System.out.println("The error is:"+ee);
            }
        } 
		if(ae.getSource() == bcancel){
           try { fadd.setVisible(false);
            new details();
           }catch(Exception ec) {
        	   ec.printStackTrace();
           }
        }
	}

}
