package ed;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Remove_Employee implements ActionListener{

	JFrame frmv;
    JTextField t;
    JLabel lid,lfn,lln,lphn,lrmv,lfn1,lln1,lphn1;
    JButton bsearch,bremove,bcancel,b_back;
    

    Remove_Employee(){
        frmv=new JFrame("Remove Employee");
        frmv.setBackground(Color.white);   
        frmv.setLayout(null);

        lrmv=new JLabel();
        lrmv.setBounds(0,0,500,500);
        lrmv.setLayout(null);
        frmv.add(lrmv);
       /* ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("C:\\Users\\This PC\\OneDrive\\Desktop\\eclipse\\EmployeeManagementSystem\\EMS\\src\\icons\\remove.jpg"));
        lrmv.setIcon(img);
        frmv.add(lrmv);*/
        
        
        lid=new JLabel("EmployeeID");
        lid.setBounds(50,50,250,30);
        lid.setForeground(Color.cyan);
        Font f2 = new Font("serif",Font.BOLD,25); 
        lid.setFont(f2);
        lrmv.add(lid);

        t=new JTextField();
        t.setBounds(250,50,150,30);
        lrmv.add(t);


        bsearch=new JButton("Search");
        bsearch.setBounds(200,100,100,30);
        bsearch.addActionListener(this);
        lrmv.add(bsearch);

        b_back=new JButton("back");
        b_back.setBounds(360,100,100,30);   
        b_back.addActionListener(this);
        lrmv.add(b_back);


        lfn=new JLabel("FirstName:"); 
        lfn.setBounds(50,150,250,30);
        lfn.setForeground(Color.black);
        Font f3 = new Font("serif",Font.BOLD,20); 
        lfn.setFont(f3);
        lrmv.add(lfn);

        lfn1=new JLabel();    
        lfn1.setBounds(200,150,350,30);
        lfn1.setForeground(Color.black);
        Font F6=new Font("serif",Font.BOLD,20); 
        lfn1.setFont(F6);
        lrmv.add(lfn1);

        lln=new JLabel("LastName");
        lln.setBounds(50,200,250,30);
        lln.setForeground(Color.black);
        Font f4 = new Font("serif",Font.BOLD,20); 
        lln.setFont(f4);
        lrmv.add(lln);


        lln1=new JLabel();
        lln1.setBounds(200,200,350,30);
        lln1.setForeground(Color.black);
        Font F7=new Font("serif",Font.BOLD,20); 
        lln1.setFont(F7);
        lrmv.add(lln1);



        lphn=new JLabel("PhoneNumber:");
        lphn.setBounds(50,250,250,30);
        lphn.setForeground(Color.black);
        Font F5=new Font("serif",Font.BOLD,20); 
        lphn.setFont(F5);
        lrmv.add(lphn);

        lphn1=new JLabel();
        lphn1.setBounds(200,250,350,30);
        lphn1.setForeground(Color.black);
        Font f8=new Font("serif",Font.BOLD,20); 
        lphn1.setFont(f8);
        lrmv.add(lphn1);

        bremove=new JButton("Remove");
        bremove.setBounds(120,300,100,30);
        bremove.addActionListener(this);
        lrmv.add(bremove);


        bcancel=new JButton("Cancel");
        bcancel.setBounds(300,300,100,30);
        bcancel.addActionListener(this);
        lrmv.add(bcancel);
        
        lfn.setVisible(false);
        lfn1.setVisible(false);
        lln.setVisible(false);
        lln1.setVisible(false);
        lphn.setVisible(false);
        lphn1.setVisible(false);
        bremove.setVisible(false);
        bcancel.setVisible(false);

        frmv.setSize(500,500);
        frmv.setLocation(500,250);  
        frmv.setVisible(true);
        
        
    }

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Remove_Employee();
	}


	@Override
	public void actionPerformed(ActionEvent ae) {
		
		String emp_id=t.getText();
		// TODO Auto-generated method stub
		 if(ae.getSource()==bsearch){
	            try{
	                ConnectorClass con = new ConnectorClass();
	                String str = "select FirstName,LastName,PhoneNumber from employeedetails where EmployeeID='"+Integer.parseInt(emp_id)+"' ";
	                ResultSet rs = con.s.executeQuery(str);

	                int i=0;
	                if(rs.next()){
	                    String firstname = rs.getString(2);
	                    String lastname = rs.getString(1);
	                    int i7=rs.getInt(7);
	                    String phone=String.valueOf(i7);

	                    lfn.setVisible(true);
	                    lln.setVisible(true);
	                    lphn.setVisible(true);
	                    lfn1.setVisible(true);
	                    lln1.setVisible(true);
	                    lphn1.setVisible(true);
	                    bremove.setVisible(true);
	                    bcancel.setVisible(true);    
	                    i=1;
	                    lfn1.setText(firstname);
	                    lln1.setText(lastname);
	                    lphn1.setText(phone);
	                }
	                if(i==0)
	                    JOptionPane.showMessageDialog(null,"Id not found");
	            }catch(Exception ex){}
	        }
	        if(ae.getSource()==bremove){
	            try{
	            	ConnectorClass con = new ConnectorClass();
	                String str = "delete from employeedetails where EmployeeID = '"+Integer.parseInt(emp_id)+"'";
	                con.s.executeUpdate(str);
	                JOptionPane.showMessageDialog(null,"deleted successfully");
	                lfn.setVisible(false);
	                lln.setVisible(false);
	                lphn.setVisible(false);
	                lfn1.setVisible(false);
	                lln1.setVisible(false);
	                lphn1.setVisible(false);
	                bremove.setVisible(false);
	                bcancel.setVisible(false);

	            }catch(Exception ex){
	                JOptionPane.showMessageDialog(null,"Exception occured while delting record "+ex);
	            }
	        }
	        if(ae.getSource()==bcancel){
	            frmv.setVisible(false);
	            details d=new details();
	        }
	        if(ae.getSource()==b_back){
	            frmv.setVisible(false);
	            details d=new details();
	        }
	}

}
