package ed;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class login implements ActionListener {
	
	JFrame f;
	JLabel l1,l2;
	JTextField t1,t2;
	JButton b1,b2;
	
	
	public login() {
		
		f=new JFrame("Login");
		f.setBackground(Color.white);
		f.setLayout(null);
		
		JPanel p=new JPanel();
		p.setBounds(0, 200, 1000, 1000);
		p.setBackground(Color.orange);
		f.add(p);
		
		l1=new JLabel("Username");
		l1.setBounds(40, 20, 100,30);
		f.add(l1);
		
		l2=new JLabel("Password");
		l2.setBounds(40, 70, 100,30);
		f.add(l2);
		
		t1=new JTextField();
		t1.setBounds(150, 20, 150,30);
		f.add(t1);
		
		t2=new JPasswordField();
		t2.setBounds(150,70,150,30);
		f.add(t2);
		
		/*ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("C:\\Users\\This PC\\OneDrive\\Desktop\\eclipse\\EmployeeManagementSystem\\EMS\\src\\icons\\login.jpg"));
		Image i2=i1.getImage().getScaledInstance(150, 150,Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel l3=new JLabel();
		l3.setBounds(350, 20, 150,150);
		f.add(l3);*/
		
		b1=new JButton("Login");
		b1.setBounds(40,140,120,30);
		b1.setFont(new Font("sans",Font.BOLD,20));
		b1.addActionListener(this);
		b1.setBackground(Color.cyan);
		b1.setForeground(Color.BLACK);
		f.add(b1);
		
		b2=new JButton("Cancel");
		b2.setBounds(200,140,120,30);
		b2.setFont(new Font("sans",Font.BOLD,20));
		b2.addActionListener(this);
		b2.setBackground(Color.cyan);
		b2.setForeground(Color.BLACK);
		f.add(b2);
		
		f.getContentPane().setBackground(Color.white);
		f.setVisible(true);
		f.setSize(700,400);
		f.setLocation(500, 400);
		f.getDefaultCloseOperation();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new login();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			ConnectorClass c1=new ConnectorClass();
			String userName=t1.getText();
			String pass=t2.getText();
			
			String all="select * from login where username='"+userName+"' and password='"+pass+"'";
			
			ResultSet rs=c1.s.executeQuery(all);
			if(rs.next()) {
				new details().fdtl.setVisible(true);
				f.setVisible(false);
			}else {
				JOptionPane.showMessageDialog(null, "Invalid login!!No such User Present");
				f.setVisible(false);
			}
		
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
