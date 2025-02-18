package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;
import java.sql.*;

public class TeacherLeave extends JFrame implements ActionListener {
    
    Choice cempid, ctime;
    JDateChooser dcdate;
    JButton submit, cancel;
    
    TeacherLeave(){
        
        setSize(500, 550);
        setLocation(500, 100);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel heading = new JLabel("Apply Leave (Faculty)");
        heading.setBounds(40,50,300,30);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        add(heading);
        
        JLabel lblempid = new JLabel("Search by Employee ID");
        lblempid.setBounds(60,100, 150, 20);
        lblempid.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(lblempid);
        
        cempid = new Choice();
        cempid.setBounds(60,130,200,20);
        add(cempid);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from teacher");
            while(rs.next()){
                cempid.add(rs.getString("empid"));
                
            }
            
        }catch(Exception e){
            
            e.printStackTrace();
        }
        
        JLabel lbldate = new JLabel("Date");
        lbldate.setBounds(60,180,200,20);
        lbldate.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(lbldate);
        
        dcdate = new JDateChooser();
        dcdate.setBounds(60, 210, 200, 20);
        add(dcdate);
        
        JLabel lbltime = new JLabel("Time Duration");
        lbltime.setBounds(60, 260, 200, 20);
        lbltime.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(lbltime);
        
        ctime = new Choice();
        ctime.setBounds(60, 290, 200, 20);
        ctime.add("Half Day");
        ctime.add("Full Day");
        add(ctime);
        //60,350,100,25    200,350,100,25
        submit = new JButton("Submit");
        submit.setBounds(60,350,100,25);
        submit.setForeground(Color.WHITE);
        submit.setBackground(Color.BLACK);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma",Font.BOLD,15));
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(200, 350, 100, 25);
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma",Font.BOLD,15));
        add(cancel);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == submit){
            
            String empid = cempid.getSelectedItem();
            String date = ((JTextField) dcdate.getDateEditor().getUiComponent()).getText();
            String duration = ctime.getSelectedItem();
            
            String query = "Insert into teacherleave values('"+empid+"', '"+date+"', '"+duration+"')";
            
            try {
                Conn c = new Conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Leave Confirmed");
                
                setVisible(false);
                
            }catch(Exception e ){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
        }
        
    }
    
    
    public static void main(String[] args){
        
        new TeacherLeave();
    }
    
}
