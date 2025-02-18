package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login1 extends JFrame implements ActionListener{
    
    JTextField tfusername,tfpassword;
    JButton login, cancel;
    
    Login1(){
        setSize(700,600);
        setLocation(400,140);
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,60,200,200);
        add(image);
        
        JMenuBar mb = new JMenuBar();
        
        JMenu admin = new JMenu("Admin");
        admin.setForeground(Color.BLUE);
        mb.add(admin);
        
        JMenuItem log = new JMenuItem("LOGIN");
        log.setForeground(Color.BLUE);
        log.addActionListener(this);
        admin.add(log);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(60,60,150,30);
        lblusername.setFont(new Font("Tahoma",Font.BOLD,22));
        add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(230,60,150,30);
        tfusername.setFont(new Font("Tahoma", Font.PLAIN,20));
        add(tfusername);
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(60,120,150,30);
        lblpassword.setFont(new Font("Tahoma", Font.BOLD,22));
        add(lblpassword);
        
        tfpassword = new JPasswordField();
        tfpassword.setBounds(230,120,150,30);
        tfpassword.setFont(new Font("Tahoma", Font.PLAIN,20));
        add(tfpassword);
        
        ImageIcon a1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image a2 = a1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon a3 = new ImageIcon(a2);
        JLabel image1 = new JLabel(a3);
        image1.setBounds(60,230,200,200);
        add(image1);
        
        //Buttons
        
        login = new JButton("Login");
        login.setBounds(70,180,130,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        login.setFont(new Font("Tahoma", Font.BOLD,15));
        add(login);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(210,180,130,30);
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD,15));
        add(cancel);
        
        setJMenuBar(mb);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        String msg = ae.getActionCommand();
        
        if(msg.equals("LOGIN")){
            new Login();
        }
                else if(ae.getSource() == login){
            String username = tfusername.getText();
            String password = tfpassword.getText();
            
            String query = "select * from login where username = '"+username+"' and password = '"+password+"'";
            
            try{
                Conn c= new Conn();
                ResultSet rs = c.s.executeQuery(query);
                
               
                if(rs.next()){
                    setVisible(false);
                    
                    new Project();
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                }
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
            
        }
            
        
        else{
            setVisible(false);
        }
        
    } 
    public static void main(String [] args){
        new Login1();
    }
}
