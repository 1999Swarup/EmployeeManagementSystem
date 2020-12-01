package ed;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class View_Employee implements ActionListener {
	
	    JFrame fview;
	    JTextField t;
	    JLabel l1,l2;
	    JButton bsearch,bcancel;
	
	View_Employee() {
		    fview=new JFrame("View");
	        fview.setBackground(Color.green);
	        fview.setLayout(null);
	        
	    	JPanel p=new JPanel();
				p.setBounds(0,130,500, 270);
				p.setBackground(Color.MAGENTA);

	        l1=new JLabel();
	        l1.setBounds(0,0,500,270);
	        l1.setLayout(null);
	        fview.add(l1);
	      /*  ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("C:\\Users\\This PC\\OneDrive\\Desktop\\eclipse\\EmployeeManagementSystem\\EMS\\src\\icons\\view.jpg"));
	        l1.setIcon(img);*/


	        l2=new JLabel("Employee Id");
	        l2.setVisible(true);
	        l2.setBounds(40,60,250,30);
	        l2.setForeground(Color.blue);
	        Font F1 = new Font("serif",Font.BOLD,30);
	        l2.setFont(F1); 
	        l1.add(l2);
	       


	        t=new JTextField();
	        t.setBounds(240,60,220,30);
	        l1.add(t);

	        bsearch=new JButton("Search");
	        bsearch.setBounds(240,150,100,30);
	        bsearch.addActionListener(this);
	        l1.add(bsearch);

	        bcancel=new JButton("Cancel");
	        bcancel.setBounds(360,150,100,30);
	        bcancel.addActionListener(this);
	        l1.add(bcancel);

	        fview.setSize(500,270);
	        fview.setLocation(450,250);
	        fview.setVisible(true); 
	        
	        fview.add(p);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  new View_Employee();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		
		  if(ae.getSource()==bcancel){
	            fview.setVisible(false);
	            new details();
	        }
	        if(ae.getSource()==bsearch){
	            fview.setVisible(false);
	            new Print_Data(t.getText());
	        }

	}

}
