package ed;

import java.awt.*;
import javax.swing.*;
import java.lang.Thread;
import java.awt.event.*;

class front implements ActionListener{
    JFrame f; 
    JLabel id,l1;
    JButton b;

    front(){
 
        f=new JFrame("Employee Management System");
        f.setBackground(Color.red);
        f.setLayout(null);
        
        
        JPanel p=new JPanel();
        p.setBounds(0, 180, 1500, 550);
        p.setBackground(Color.cyan);
        f.add(p);
        /*ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("C://Users//This PC//OneDrive//Desktop//eclipse//EmployeeManagementSystem//EMS//src//icons//front.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1200,700,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);*/
        JLabel l1 = new JLabel();
        l1.setBounds(0,150,1460,540);
        f.add(l1);


        b = new JButton("CLICK HERE TO CONTINUE");
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        

        b.setBounds(500,600,300,70);
        b.addActionListener(this);

        id=new JLabel();
        id.setBounds(0,0,1360,750);
        id.setLayout(null);
        p.add(id);
        
   

        JLabel lid=new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        lid.setBounds(80,30,1500,100);
        lid.setFont(new Font("serif",Font.PLAIN,70));
        lid.setForeground(Color.red);
        id.add(lid);

        id.add(b);
        f.add(id);
        
        
        f.getContentPane().setBackground(Color.WHITE);

        f.setVisible(true);
        f.setSize(1360,750);
        f.setLocation(200,100);

        while(true){
            lid.setVisible(false); // lid =  j label
            try{
                Thread.sleep(500); //1000 = 1 second
            }catch(Exception e){} 
            lid.setVisible(true);
            try{
                Thread.sleep(500);
            }catch(Exception e){}
        }

    }
    public void actionPerformed(ActionEvent ae){

        try{
        	if(ae.getSource()==b){
        }
            f.setVisible(false);
            new login();    
        }
    catch(Exception ex) {
    	ex.printStackTrace();
    }
    }

    public static void main(String[] arg){
        new front();
    }
}


