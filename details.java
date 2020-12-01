package ed;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class details implements ActionListener {
	
	JFrame fdtl;
	JLabel l1,l2;
	JButton b1,b2,b3,b4;
	
	public details() {
        fdtl=new JFrame("Employee Details");
		fdtl.setBackground(Color.cyan);
		fdtl.setLayout(null);
		
		JPanel p=new JPanel();
		p.setBounds(0,200, 1000, 1000);
		p.setBackground(Color.green);
		fdtl.add(p);
		
		l1 = new JLabel();
        l1.setBounds(0,0,700,500);
        l1.setLayout(null);
       /* ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("C:\\Users\\This PC\\OneDrive\\Desktop\\eclipse\\EmployeeManagementSystem\\EMS\\src\\icons\\details.jpg"));
        l1.setIcon(i1);*/
        fdtl.add(l1);

        l2 = new JLabel("Employee Details");
        l2.setBounds(430,20,200,40);
        l2.setFont(new Font("serif",Font.BOLD,25));
        l2.setForeground(Color.black);
        l1.add(l2);

        b1=new JButton("Add");
        b1.setBounds(420,80,100,40);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.addActionListener(this);
        l1.add(b1);


        b2=new JButton("View");
        b2.setBounds(530,80,100,40);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.addActionListener(this);
        l1.add(b2);

        b3=new JButton("Remove");
        b3.setBounds(420,140,100,40);
        b3.setFont(new Font("serif",Font.BOLD,15));
        b3.addActionListener(this);
        l1.add(b3);

        b4=new JButton("Update");
        b4.setBounds(530,140,100,40);
        b4.setFont(new Font("serif",Font.BOLD,15));
        b4.addActionListener(this);
        l1.add(b4);

        fdtl.setVisible(true);
        fdtl.setSize(700,500);
        fdtl.setLocation(450,200);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new details();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource()==b1){
            fdtl.setVisible(false);
            new Add_Employee();
        }
        if(ae.getSource()==b2){
            fdtl.setVisible(false);
            new View_Employee();
        }
        if(ae.getSource()==b3){
            fdtl.setVisible(false);
            new Remove_Employee();
        }
        if(ae.getSource()==b4){
            fdtl.setVisible(false);
            new Search_to_Update_Employee();
        }
	}


}
