package ed;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Search_to_Update_Employee implements ActionListener{
    JFrame fsearch;
    JTextField t;
    JLabel l,l5;
    JButton b,b2;

    Search_to_Update_Employee(){
        fsearch=new JFrame("search");
        fsearch.setBackground(Color.red);
        fsearch.setLayout(null);

       	JPanel p=new JPanel();
    				p.setBounds(0,130,500, 270);
    				p.setBackground(Color.MAGENTA);
        
        
        l5=new JLabel();
        l5.setBounds(0,0,500,270);
        l5.setLayout(null);
        fsearch.add(l5);
      /*  ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("C:\\Users\\This PC\\OneDrive\\Desktop\\eclipse\\EmployeeManagementSystem\\EMS\\src\\icons\\view.jpg"));
        l5.setIcon(img);*/


        l=new JLabel("Employee Id");
        l.setVisible(true);
        l.setBounds(40,50,250,30);
        l.setForeground(Color.blue);
        Font F1=new Font("serif",Font.BOLD,25);
        l.setFont(F1); 
        l5.add(l);
      

        t=new JTextField();
        t.setBounds(240,50,220,30);
        l5.add(t);

        b=new JButton("Search");
        b.setBounds(240,150,100,30);
        b.addActionListener(this);
        l5.add(b);


        b2=new JButton("Cancel");
        b2.setBounds(360,150,100,30);
        b2.addActionListener(this);
        l5.add(b2);

        fsearch.setSize(500,270);
        fsearch.setLocation(450,250);
        fsearch.setVisible(true);
        
        fsearch.add(p);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b2){
            fsearch.setVisible(false);
            new details();
        }
        if(ae.getSource()==b){
            new Update_Employee(t.getText());
            fsearch.setVisible(false);
        }

    }
    
    public static void main(String[]ar){
        new Search_to_Update_Employee();
    } 	
}

