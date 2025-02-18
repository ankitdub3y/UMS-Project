package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class AddTeacher extends JFrame implements ActionListener {
    
    JDateChooser dcdob;
    JTextField tfname, tffname, tfaddress, tfphone, tfemail, tfxmarks, tfxiimarks, tfaadhar;
    JLabel labelempid;
    JComboBox cbdepartment, cbqualification;
    JButton submit, cancel;
    
    AddTeacher(){
        
        Random ran = new Random();
        long first4= Math.abs(ran.nextLong() % 9000L)+ 1000L;
        
        setSize(900, 700);
        setLocation(350,50);
        
        setLayout(null);
        
        JLabel heading = new JLabel("New Teacher Information");
        heading.setBounds(310,30, 700, 50);
        heading.setFont(new Font("Serif", Font.BOLD, 20));
        add(heading);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60,50,550,200);
        lblname.setFont(new Font("Serif", Font.BOLD, 20));
        add(lblname);
        
        tfname= new JTextField();
        tfname.setBounds(200,140,150,30);
        tfname.setFont(new Font("Serif", Font.PLAIN, 18));
        add(tfname);
        
        JLabel lblfname = new JLabel("Father's Name");
        lblfname.setBounds(450,140,150,30);
        lblfname.setFont(new Font("Serif",Font.BOLD,20));
        add(lblfname);
        
        tffname = new JTextField();
        tffname.setBounds(640,140,150,30);
        tffname.setFont(new Font("Serif", Font.PLAIN, 18));
        add(tffname);
        
        JLabel lblempid = new JLabel("Employee ID");
        lblempid.setBounds(60,210,150,30);
        lblempid.setFont(new Font("Serif",Font.BOLD,20));
        add(lblempid);
        
        labelempid= new JLabel("101"+first4);
        labelempid.setBounds(200,210,150,30);
        labelempid.setFont(new Font("Serif",Font.BOLD,20));
        add(labelempid);
        
        JLabel lbldob = new JLabel("Date of Birth");
        lbldob.setBounds(450,210,150,30);
        lbldob.setFont(new Font("Serif",Font.BOLD,20));
        add(lbldob);
        
        dcdob = new JDateChooser();
        dcdob.setBounds(640,210,150,30);
        dcdob.setFont(new Font("Serif", Font.PLAIN, 18));
        add(dcdob);
        
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(60,280,150,30);
        lbladdress.setFont(new Font("Serif",Font.BOLD,20));
        add(lbladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(200,280,150,30);
        tfaddress.setFont(new Font("Serif", Font.PLAIN, 18));
        add(tfaddress);
        
        JLabel lblphone = new JLabel("Phone no.");
        lblphone.setBounds(450,280,150,30);
        lblphone.setFont(new Font("Serif",Font.BOLD,20));
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(640,280,150,30);
        tfphone.setFont(new Font("Serif", Font.PLAIN, 18));
        add(tfphone);
        
        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(60,350,250,30);
        lblemail.setFont(new Font("Serif",Font.BOLD,20));
        add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(200,350,150,30);
        tfemail.setFont(new Font("Serif", Font.PLAIN, 18));
        add(tfemail);
        
        JLabel lblxmarks = new JLabel("X Marks(%)");
        lblxmarks.setBounds(450,350,150,30);
        lblxmarks.setFont(new Font("Serif",Font.BOLD,20));
        add(lblxmarks);
        
        tfxmarks = new JTextField();
        tfxmarks.setBounds(640,350,150,30);
        tfxmarks.setFont(new Font("Serif", Font.PLAIN, 18));
        add(tfxmarks);
        
        JLabel lblxiimarks = new JLabel("XII Marks(%)");
        lblxiimarks.setBounds(60,420,150,30);
        lblxiimarks.setFont(new Font("Serif",Font.BOLD,20));
        add(lblxiimarks);
       
        tfxiimarks = new JTextField();
        tfxiimarks.setBounds(200,420,150,30);
        tfxiimarks.setFont(new Font("Serif", Font.PLAIN, 18));
        add(tfxiimarks);
        
        JLabel lblaadhar = new JLabel("Aadhar");
        lblaadhar.setBounds(450,420,150,30);
        lblaadhar.setFont(new Font("Serif",Font.BOLD,20));
        add(lblaadhar);
        
        tfaadhar = new JTextField();
        tfaadhar.setBounds(640,420,150,30);
        tfaadhar.setFont(new Font("Serif", Font.PLAIN, 18));
        add(tfaadhar);
        
        JLabel lblqualification = new JLabel("Qualification");
        lblqualification.setBounds(60,490,150,30);
        lblqualification.setFont(new Font("Serif",Font.BOLD,20));
        add(lblqualification);
        
        String qualification[]={"BCA","BTech", "BBA", "BCom", "BSc", "MCA", "MTech","MBA", "MCom", "MSc"};
        cbqualification = new JComboBox(qualification);
        cbqualification.setBounds(200,490,150,30);
        cbqualification.setFont(new Font("Serif", Font.PLAIN, 15));
        add(cbqualification);
        
        JLabel lbldepartment = new JLabel("Department");
        lbldepartment.setBounds(450,490,150,30);
        lbldepartment.setFont(new Font("Serif",Font.BOLD,20));
        add(lbldepartment);
        
        String department[] = {"Mechanical","Computer Science","Civil","Electronics"};
        cbdepartment = new JComboBox(department);
        cbdepartment.setBounds(640,490,150,30);
        cbdepartment.setFont(new Font("Serif", Font.PLAIN, 15));
        add(cbdepartment);
        
        submit = new JButton("Submit");
        submit.setBounds(300,580, 90, 30);
        submit.setForeground(Color.WHITE);
        submit.setBackground(Color.BLACK);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma",Font.BOLD,15));
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(440,580,90,30);
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma",Font.BOLD,15));
        add(cancel);
        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == submit){
            
            String name = tfname.getText();
            String fname = tffname.getText();
            String empid = labelempid.getText();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String xmarks = tfxmarks.getText();
            String xiimarks = tfxiimarks.getText();
            String aadhar = tfaadhar.getText();
            String qualification = (String) cbqualification.getSelectedItem();
            String department = (String) cbdepartment.getSelectedItem();
            
            
            try{
                String query = "insert into teacher values('"+name+"', '"+fname+"', '"+empid+"', '"+dob+"', '"+address+"', '"+phone+"', '"+email+"', '"+xmarks+"', '"+xiimarks+"', '"+aadhar+"', '"+qualification+"', '"+department+"')";
                Conn con = new Conn();
                
                
                con.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Teacher details Inserted Successfully");
                
                setVisible(false);
                
            }catch(Exception e){
                
                e.printStackTrace();
                
                 }
        }else {
            
            setVisible(false);
            
        }
    }
    
    public static void main(String args[]){
        
        new AddTeacher();
    }
    
}
