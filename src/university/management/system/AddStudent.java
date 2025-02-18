package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;


public class AddStudent extends JFrame implements ActionListener {
    
    JDateChooser dcdob;
    JTextField tfname, tffname, tfaddress, tfphone, tfemail,tfxmarks, tfxiimarks, tfaadhar;
    JLabel labelrollno;
    JComboBox cbbranch, cbcourse;
    JButton submit, cancel;
    
    
    AddStudent(){
        
        Random ran = new Random();
        long first4= Math.abs(ran.nextLong() % 9000L)+ 1000L;
        
        setSize(900, 700);
        setLocation(350,50);
        
        setLayout(null);
        
        JLabel heading = new JLabel("New Student Information");
        heading.setBounds(310,30, 700, 50);
        heading.setFont(new Font("serif", Font.BOLD, 30 ));
        add(heading);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60, 50, 550, 200);
        lblname.setFont(new Font("Serif", Font.BOLD, 20));
        add(lblname);
        
         tfname = new JTextField();
        tfname.setBounds(200, 140, 150, 30);
        tfname.setFont(new Font("Serif", Font.PLAIN, 18));
        add(tfname);
        
        JLabel lblfname = new JLabel("Father's Name ");
        lblfname.setBounds(450, 140, 150, 30);
        lblfname.setFont(new Font("Serif", Font.BOLD, 20));
        add(lblfname);
        
        tffname = new JTextField();
        tffname.setBounds(640, 140, 150, 30);
        tffname.setFont(new Font("Serif", Font.PLAIN, 18));
        add(tffname);
        
        JLabel lblrollno = new JLabel("Roll Number");
        lblrollno.setBounds(60, 210, 150, 30);
        lblrollno.setFont(new Font("Serif", Font.BOLD, 20));
        add(lblrollno);
        
        labelrollno = new JLabel("3315"+first4);
        labelrollno.setBounds(200, 210, 150, 30);
        labelrollno.setFont(new Font("Serif",Font.BOLD, 20));
        add(labelrollno);
        
        JLabel lbldob = new JLabel("Date of Birth");
        lbldob.setBounds(450, 210, 150, 30);
        lbldob.setFont(new Font("Serif", Font.BOLD, 20));
        add(lbldob);
        
        dcdob = new JDateChooser();
        dcdob.setBounds(640, 210, 150, 30);
        dcdob.setFont(new Font("Serif", Font.PLAIN, 18));
        add(dcdob);
        
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(60, 280, 150, 30);
        lbladdress.setFont(new Font("Serif", Font.BOLD, 20));
        add(lbladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(200, 280, 150, 30 );
        tfaddress.setFont(new Font("Serif", Font.PLAIN, 18));
        add(tfaddress);
        
        JLabel lblphone = new JLabel("Phone No.");
        lblphone.setBounds(450, 280, 150, 30);
        lblphone.setFont(new Font("Serif", Font.BOLD, 20));
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(640, 280, 150, 30);
        tfphone.setFont(new Font("Serif", Font.PLAIN, 18));
        add(tfphone);
        
        JLabel lblemail = new JLabel("Email ID");
        lblemail.setBounds(60, 350, 150, 30);
        lblemail.setFont(new Font("Serif", Font.BOLD,20));
        add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(200, 350, 150, 30);
        tfemail.setFont(new Font("Serif", Font.PLAIN, 18));
        add(tfemail);
        
        JLabel lbl10 = new JLabel("X Marks (%)");
        lbl10.setBounds(450, 350, 150, 30);
        lbl10.setFont(new Font("Serif",Font.BOLD,20));
        add(lbl10);
        
        tfxmarks = new JTextField();
        tfxmarks.setBounds(640, 350, 150, 30);
        tfxmarks.setFont(new Font("Serif", Font.PLAIN, 18));
        add(tfxmarks);
        
        JLabel lbl12marks = new JLabel("XII Marks(%)");
        lbl12marks.setBounds(60, 420, 150, 30);
        lbl12marks.setFont(new Font("Serif", Font.BOLD, 20));
        add(lbl12marks);
        
        tfxiimarks = new JTextField();
        tfxiimarks.setBounds(200,420, 150, 30);
        tfxiimarks.setFont(new Font("Serif", Font.PLAIN, 18));
        add(tfxiimarks);
        
        JLabel lblaadhar = new JLabel("Aadhar");
        lblaadhar.setBounds(450, 420, 150, 30);
        lblaadhar.setFont(new Font("Serif", Font.BOLD, 20));
        add(lblaadhar);
        
        tfaadhar = new JTextField();
        tfaadhar.setBounds(640, 420, 150, 30);
        tfaadhar.setFont(new Font("Serif", Font.PLAIN, 18));
        add(tfaadhar);
        
        JLabel lblbranch = new JLabel("Branch");
        lblbranch.setBounds(60, 490, 150, 30);
        lblbranch.setFont(new Font("Serif", Font.BOLD, 20));
        add(lblbranch);
        
        String branch[]= {"Mechanical", "Computer Science", "Civil", "Electronics"};
        cbbranch = new JComboBox(branch);
        cbbranch.setBounds(200,490,150,30);
        cbbranch.setFont(new Font("Serif", Font.PLAIN, 15));
        add(cbbranch);
        
        JLabel lblcourse = new JLabel("Course");
        lblcourse.setBounds(450, 490, 150, 30);
        lblcourse.setFont(new Font ("Serif",Font.BOLD, 20));
        add(lblcourse);
        
        String course[]= {"BCA","BTech", "BBA", "BCom", "BSc", "MCA", "MTech","MBA", "MCom", "MSc"};
        cbcourse = new JComboBox(course);
        cbcourse.setBounds(640, 490, 150, 30);
        cbcourse.setFont(new Font("Serif", Font.PLAIN, 15));
        add(cbcourse);
        
        submit = new JButton("Submit");
        submit.setBounds(300, 580, 90, 30);
        submit.setForeground(Color.WHITE);
        submit.setBackground(Color.BLACK);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma",Font.BOLD,15));
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(440, 580, 90, 30);
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);
        
        
        
        
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == submit){
            
            String name = tfname.getText();
            String fname = tffname.getText();
            String rollno = labelrollno.getText();
            String dob =( (JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String xmarks = tfxmarks.getText();
            String xiimarks = tfxiimarks.getText();
            String aadhar = tfaadhar.getText();
            String branch = (String) cbbranch.getSelectedItem();
            String course = (String) cbcourse.getSelectedItem();
            
            try{
                
                String query= "insert into student values('"+name+"', '"+fname+"','"+rollno+"', '"+dob+"', '"+address+"', '"+phone+"', '"+email+"', '"+xmarks+"', '"+xiimarks+"', '"+aadhar+"', '"+branch+"', '"+course+"')";
                Conn con = new Conn();
                
                con.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Student Details Inserted Successfully");
                
                setVisible(false);
                
            }catch(Exception e){
                
                e.printStackTrace();
            }
        }else {
            
            setVisible(false);
        }
    }
    
    public static void main(String args[]){
        
        
        
        new AddStudent();
        
    }
    
    
}
