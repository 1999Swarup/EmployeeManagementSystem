package ed;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Print_Data implements ActionListener{
	
	    JFrame fprint;
	    JLabel lp,led,lid,lid1,lln,lln1,lfn,lfn1,ldn,ldn1,ls,ls1,ladrs,ladrs1,lphn,lphn1;
	    String emp_id,address,phone,department,FirstName,LastName,salary;
	    JButton bprint,bcancel;
	    ImageIcon icon;

	public Print_Data(String e_id) {
		// TODO Auto-generated constructor stub
		  try{
	            ConnectorClass con = new ConnectorClass();
	            String str = "select * from employeedetails where EmployeeID = '"+Integer.parseInt(e_id)+"'";
	            ResultSet rs= con.s.executeQuery(str);

	            while(rs.next()){

	            	    int i1=rs.getInt(1);
		                int i5=rs.getInt(5);
		                int i7=rs.getInt(7);
	                FirstName= rs.getString(3);
	                LastName = rs.getString(2);
	                department = rs.getString(4);
	                salary =String.valueOf(i5);
	                address = rs.getString(6);
	                phone = String.valueOf(i7);
	                emp_id =String.valueOf(i1);
	            }
	        }catch(Exception e){
	            e.printStackTrace();
	        }
		    fprint=new JFrame("Print Data");
	        fprint.setVisible(true);
	        fprint.setSize(595,642);
	        fprint.setLocation(450,200);
	        fprint.setBackground(Color.cyan);
	        fprint.setLayout(null);

	        
	  	    	JPanel p=new JPanel();
	  				p.setBounds(300,0,700, 870);
	  				p.setBackground(Color.cyan);

	        lp=new JLabel();
	        lp.setBounds(0,0,595,642);
	        lp.setLayout(null);
	        fprint.add(lp);
	       /* ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("C:\\Users\\This PC\\OneDrive\\Desktop\\eclipse\\EmployeeManagementSystem\\EMS\\src\\icons\\print.jpg"));
	        lp.setIcon(img);*/

	        led = new JLabel("Employee Details");
	        led.setBounds(50,10,250,30);
	        led.setFont(new Font("serif",Font.BOLD,25));
	        lp.add(led);
	        
	        
	        lid = new JLabel("Employee ID:");
	        lid.setBounds(50,70,120,30);
	        lid.setFont(new Font("serif",Font.BOLD,20));
	        lp.add(lid);

	        lid1 = new JLabel(emp_id);
	        lid1.setBounds(200,70,200,30);
	        lid1.setFont(new Font("serif",Font.BOLD,20));
	        lp.add(lid1);

	        lfn = new JLabel("First Name:");
	        lfn.setBounds(50,120,150,30);
	        lfn.setFont(new Font("serif",Font.BOLD,20));
	        lp.add(lfn);

	        lfn1 = new JLabel(FirstName);
	        lfn1.setBounds(200,120,300,30);
	        lfn1.setFont(new Font("serif",Font.BOLD,20));
	        lp.add(lfn1);

	  
	        lln = new JLabel("Last Name:"); 
	        lln.setBounds(50,170,200,30);
	        lln.setFont(new Font("serif",Font.BOLD,20));
	        lp.add(lln);

	        lln1 = new JLabel(LastName);
	        lln1.setBounds(200,170,300,30);
	        lln1.setFont(new Font("serif",Font.BOLD,20));
	        lp.add(lln1);

	        ladrs= new JLabel("Address:");
	        ladrs.setBounds(50,220,100,30);
	        ladrs.setFont(new Font("serif",Font.BOLD,20));
	        lp.add(ladrs);

	        ladrs1= new JLabel(address);
	        ladrs1.setBounds(200,220,300,30);
	        ladrs1.setFont(new Font("serif",Font.BOLD,20));
	        lp.add(ladrs1);


	        lphn= new JLabel("Phone Number:");  
	        lphn.setBounds(50,270,200,30);
	        lphn.setFont(new Font("serif",Font.BOLD,20));
	        lp.add(lphn);

	        lphn1= new JLabel(phone);
	        lphn1.setBounds(200,270,300,30); 
	        lphn1.setFont(new Font("serif",Font.BOLD,20));
	        lp.add(lphn1);

	        
	        ls= new JLabel("Salary:");
	        ls.setBounds(50,320,100,30);
	        ls.setFont(new Font("serif",Font.BOLD,20));
	        lp.add(ls);

	        ls1= new JLabel(salary);
	        ls1.setBounds(200,320,300,30);
	        ls1.setFont(new Font("serif",Font.BOLD,20));
	        lp.add(ls1);

	        
	        ldn= new JLabel("Department:");
	        ldn.setBounds(50,370,130,30);
	        ldn.setFont(new Font("serif",Font.BOLD,20));
	        lp.add(ldn);

	        ldn1= new JLabel(department);
	        ldn1.setBounds(200,370,300,30); 
	        ldn1.setFont(new Font("serif",Font.BOLD,20));
	        lp.add(ldn1);
	        
	        bprint=new JButton("Print");
	        bprint.setBackground(Color.BLACK);
	        bprint.setForeground(Color.WHITE);
	        bprint.setBounds(100,520,100,30);
	        bprint.addActionListener(this);
	        lp.add(bprint);

	        bcancel=new JButton("cancel");
	        bcancel.setBackground(Color.BLACK);
	        bcancel.setForeground(Color.WHITE);
	        bcancel.setBounds(250,520,100,30);
	        bcancel.addActionListener(this);
	        lp.add(bcancel);

	        fprint.add(p);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  new Print_Data("Print Data");
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		  if(ae.getSource()==bprint){
	            JOptionPane.showMessageDialog(null,"printed successfully");
	            fprint.setVisible(false);
	            new details();
	        }
	        if(ae.getSource()==bcancel){
	            fprint.setVisible(false);
	            new View_Employee();
	        }	
	}

}
