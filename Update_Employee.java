package ed;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Update_Employee extends Add_Employee implements ActionListener{
	
	JFrame fupdate;
	JLabel lai1,la2,lid,lln,lfn,ldn,ls,ladrs,lphn,lab;
	JTextField tid,tln,tfn,tdn,ts,tadrs,tphn;
	JButton bupdate,bcancel;
	String id_emp;
	
	public Update_Employee(String Emp_id) {
		// TODO Auto-generated constructor stub
		super(0);
		
		fupdate=new JFrame("update Employee details");
        fupdate.setVisible(true);
        fupdate.setSize(900,500);
        fupdate.setLocation(450,250);
        fupdate.setBackground(Color.white);
        fupdate.setLayout(null);
        
        JPanel p=new JPanel();
		p.setBounds(0,300,900, 570);
		p.setBackground(Color.orange);

        id_emp=Emp_id;  
        lai1=new JLabel();
        lai1.setBounds(0,0,900,500);
        lai1.setLayout(null);
        fupdate.add(lai1);
      /*  ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("C:\\Users\\This PC\\OneDrive\\Desktop\\eclipse\\EmployeeManagementSystem\\EMS\\src\\icons\\add_employee.jpg"));
        lai1.setIcon(img);*/

        lab = new JLabel("Update Employee Detail:");
        lab.setBounds(50,10,500,50);
        lab.setFont(new Font("serif",Font.ITALIC,40));
        lab.setForeground(Color.black);
        lai1.add(lab);
        
        
        lfn = new JLabel("First Name:");  
        lfn.setBounds(50,100,100,30);
        lfn.setFont(new Font("serif",Font.BOLD,20));
        lai1.add(lfn);

        tfn=new JTextField();
        tfn.setBounds(200,100,150,30);
        lai1.add(tfn);

        lln = new JLabel("Last Name:");
        lln.setBounds(400,100,200,30);
        lln.setFont(new Font("serif",Font.BOLD,20));
        lai1.add(lln);

        tln=new JTextField();
        tln.setBounds(600,100,150,30);
        lai1.add(tln);

        ladrs= new JLabel("Address:");
        ladrs.setBounds(50,150,100,30);
        ladrs.setFont(new Font("serif",Font.BOLD,20));
        lai1.add(ladrs);

        tadrs=new JTextField();
        tadrs.setBounds(200,150,150,30);
        lai1.add(tadrs);

        lphn= new JLabel("Phone Number:");
        lphn.setBounds(400,150,100,30);
        lphn.setFont(new Font("serif",Font.BOLD,20));
        lai1.add(lphn);

        tphn=new JTextField();
        tphn.setBounds(600,150,150,30);   
        lai1.add(tphn);

        ls= new JLabel("Salary:");
        ls.setBounds(50,200,100,30);
        ls.setFont(new Font("serif",Font.BOLD,20));
        lai1.add(ls);

        ts=new JTextField();
        ts.setBounds(200,200,150,30);
        lai1.add(ts);

        ldn= new JLabel("Department");
        ldn.setBounds(400,200,100,30);
        ldn.setFont(new Font("serif",Font.BOLD,20));    
        lai1.add(ldn);

        tdn=new JTextField();
        tdn.setBounds(600,200,150,30);
        lai1.add(tdn);

        lid= new JLabel("Employee ID:");
        lid.setBounds(50,250,100,30);
        lid.setFont(new Font("serif",Font.BOLD,20));
        lai1.add(lid);

        tid=new JTextField();
        tid.setBounds(200,250,150,30);
        lai1.add(tid);
        fupdate.setVisible(false);
        

        bupdate=new JButton("update");
        bupdate.setBounds(250,400,100,30);
        bupdate.addActionListener(this);
        lai1.add(bupdate);

        bcancel=new JButton("Cancel");
        bcancel.setBounds(450,400,100,30);
        bcancel.addActionListener(this);
        lai1.add(bcancel);

        showData(id_emp);
        
        fupdate.add(p);

	}
	
	 int i=0;

	    void showData(String idaa){
	        try{
	            ConnectorClass con = new ConnectorClass();
	            String str = "select * from employeedetails where EmployeeID= '"+Integer.parseInt(idaa)+"'";
	            ResultSet rs = con.s.executeQuery(str);

	            if(rs.next()){
	                fupdate.setVisible(true);
	                i=1;

	                int i1=rs.getInt(1);
	                int i5=rs.getInt(5);
	                int i7=rs.getInt(7);
	                tid.setText(String.valueOf(i1));
	                tln.setText(rs.getString(2));
	                tfn.setText(rs.getString(3));
	                tdn.setText(rs.getString(4));
	                ts.setText(String.valueOf(i5));
	                tadrs.setText(rs.getString(6));
	                tphn.setText(String.valueOf(i7));
	              
	              
	            }
	            if(i==0)
	                JOptionPane.showMessageDialog(null,"Id not found");
	            new Search_to_Update_Employee();
	        }catch(Exception ex){}
	        fupdate.setVisible(true);
	        fupdate.setSize(900,500);
	        fupdate.setLocation(400,100);
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 new Update_Employee("Update Employee");
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
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
		
		
		 if(ae.getSource()==bupdate && i==1){
	            try{
	            	ConnectorClass con = new ConnectorClass();
	                String str = "update employeedetails set EmployeeID='"+a+"',LastName='"+b+"',FirstName='"+c+"',Department='"+d+"',Salary='"+e+"',Address='"+f+"',PhoneNumber='"+g+"' where EmployeeID='"+id_emp+"'";
	                con.s.executeUpdate(str);
	                JOptionPane.showMessageDialog(null,"successfully updated");
	                fupdate.setVisible(false);
	                new Search_to_Update_Employee();
	            }catch(Exception exp){
	                System.out.println("The error is:"+exp);
	            }
	        }
	        if(ae.getSource()==bcancel){
	            fupdate.setVisible(false);
	            new details();
	        }
	}

}
