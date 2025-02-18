package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateTeacher extends JFrame implements ActionListener {

    JLabel lblname, labelname, lblfname, labelfname, lblempid, labelempid,lblrollnumber, lbldob, labeldob, lbladdress, lblphone, lblemail,lblxmarks,labelxmarks,lblxiimarks,labelxiimarks, lblaadhar, labelaadhar, lbldepartment, lblqualification;
    JTextField tfemail, tfphone, tfaddress, tfdepartment, tfqualification;
    JButton update,cancel;
    Choice cempid;
    
    UpdateTeacher(){
        setSize(900,700);
        setLocation(350,50);
        
        JLabel heading = new JLabel("Update Teacher Information");
        heading.setBounds(50,10,500,50);
        heading.setFont(new Font("Serif", Font.BOLD,30));
        add(heading);
        
        JLabel lblrollnumber = new JLabel("Select Employee ID");
        lblrollnumber.setBounds(50,100,200,20);
        lblrollnumber.setFont(new Font("serif",Font.PLAIN,20));
        add(lblrollnumber);
        
        cempid = new Choice();
        cempid.setBounds(250,100,200,30);
        add(cempid);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from teacher");
            while(rs.next()){
                cempid.add(rs.getString("empid"));
            }
            
        } catch(Exception e ){
            e.printStackTrace();
        }
        
        lblname = new JLabel("Name");
        lblname.setBounds(60,50,550,200);
        lblname.setFont(new Font("Serif",Font.BOLD,20));
        add(lblname);
        
        labelname = new JLabel();
        labelname.setBounds(200,140,150,30);
        labelname.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(labelname);
        
        lblfname = new JLabel("Father's name");
        lblfname.setBounds(450,140,150,30);
        lblfname.setFont(new Font("Serif",Font.BOLD,20));
        add(lblfname);
        
        labelfname = new JLabel();
        labelfname.setBounds(640,140,150,30);
        labelfname.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(labelfname);
        
        lblempid = new JLabel("Employee ID");
        lblempid.setBounds(60,210,150,30);
        lblempid.setFont(new Font("Serif",Font.BOLD,20));
        add(lblempid);
        
        labelempid = new JLabel();
        labelempid.setBounds(200,210,150,30);
        labelempid.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(labelempid);
        
        lbldob = new JLabel("Date of Birth");
        lbldob.setBounds(450,210,150,30);
        lbldob.setFont(new Font("Serif",Font.BOLD, 20));
        add(lbldob);
        
        labeldob = new JLabel();
        labeldob.setBounds(640,210,150,30);
        labeldob.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(labeldob);
        
        lbladdress = new JLabel("Address");
        lbladdress.setBounds(60,280,150,30);
        lbladdress.setFont(new Font("Serif",Font.BOLD,20));
        add(lbladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(200,280,150,30);
        tfaddress.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(tfaddress);
        
        lblphone = new JLabel("Phone No.");
        lblphone.setBounds(450,280,150,30);
        lblphone.setFont(new Font("serif",Font.BOLD,20));
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(640,280,150,30);
        tfphone.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(tfphone);
        
        lblemail = new JLabel("Email");
        lblemail.setBounds(60,350,150,30);
        lblemail.setFont(new Font("Serif",Font.BOLD,20));
        add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(200,350,150,30);
        tfemail.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(tfemail);
        
        lblxmarks = new JLabel("X Marks (%)");
        lblxmarks.setBounds(450,350,150,30);
        lblxmarks.setFont(new Font("Serif",Font.BOLD,20));
        add(lblxmarks);
        
        labelxmarks = new JLabel();
        labelxmarks.setBounds(640,350,150,30);
        labelxmarks.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(labelxmarks);
        
        lblxiimarks = new JLabel("XII Marks (%)");
        lblxiimarks.setBounds(60,420,150,30);
        lblxiimarks.setFont(new Font("Serif",Font.BOLD,20));
        add(lblxiimarks);
        
        labelxiimarks = new JLabel();
        labelxiimarks.setBounds(200,420,150,30);
        labelxiimarks.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(labelxiimarks);
        
        lblaadhar = new JLabel("Aadhar");
        lblaadhar.setBounds(450,420,150,30);
        lblaadhar.setFont(new Font("Serif",Font.BOLD,20));
        add(lblaadhar);
        
        labelaadhar = new JLabel();
        labelaadhar.setBounds(640,420,150,30);
        labelaadhar.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(labelaadhar);
        
        lbldepartment = new JLabel("Department");
        lbldepartment.setBounds(60,490,150,30);
        lbldepartment.setFont(new Font("Serif",Font.BOLD,20));
        add(lbldepartment);
        
        tfdepartment = new JTextField();
        tfdepartment.setBounds(200,490,150,30);
        tfdepartment.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(tfdepartment);
        
        lblqualification = new JLabel("Qualification");
        lblqualification.setBounds(450,490,150,30);
        lblqualification.setFont(new Font("Tahoma",Font.BOLD,18));
        add(lblqualification);
        
        tfqualification = new JTextField();
        tfqualification.setBounds(640,490,150,30);
        tfqualification.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(tfqualification);
        
        try{
            Conn c = new Conn();
            String query = "select * from teacher where empid = '"+cempid.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                labelname.setText(rs.getString("name"));
                labelfname.setText(rs.getString("fname"));
                labelempid.setText(rs.getString("empid"));
                labeldob.setText(rs.getString("dob"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                labelxmarks.setText(rs.getString("class_xmarks"));
                labelxiimarks.setText(rs.getString("class_xiimarks"));
                labelaadhar.setText(rs.getString("aadhar"));
                tfdepartment.setText(rs.getString("department"));
                tfqualification.setText(rs.getString("qualification"));
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        cempid.addItemListener(new ItemListener(){
        
        public void itemStateChanged(ItemEvent ie){

        try{
        Conn c = new Conn();
        String query = "select * from teacher where empid = '"+cempid.getSelectedItem()+"'";
        ResultSet rs = c.s.executeQuery(query);
        while(rs.next()){
        labelname.setText(rs.getString("name"));
        labelfname.setText(rs.getString("fname"));
        labelempid.setText(rs.getString("empid"));
        labeldob.setText(rs.getString("dob"));
        tfaddress.setText(rs.getString("address"));
        tfphone.setText(rs.getString("phone"));
        tfemail.setText(rs.getString("email"));
        labelxmarks.setText(rs.getString("class_xmarks"));
        labelxiimarks.setText(rs.getString("class_xiimarks"));
        labelaadhar.setText(rs.getString("aadhar"));
        tfdepartment.setText(rs.getString("department"));
        tfqualification.setText(rs.getString("qualification"));
                
        
}
}catch(Exception e){
    e.printStackTrace();
}
    } });
        
        //making two buttons update & cancel
        
        update = new JButton("Update");
        update.setBounds(300,580,90,30);
        update.setForeground(Color.WHITE);
        update.setBackground(Color.BLACK);
        update.addActionListener(this);
        update.setFont(new Font("Tahoma",Font.BOLD,15));
        add(update);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(440,580,90,30);
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma",Font.BOLD,15));
        add(cancel);
        
        
        
        setLayout(null);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
    
    if(ae.getSource()  ==  update){
    
    String empid = labelempid.getText();    
    String address = tfaddress.getText();
    String phone = tfphone.getText();
    String email = tfemail.getText();
    String department = tfdepartment.getText();
    String qualification = tfqualification.getText();
    
    try{
    String query = "update teacher set address='"+address+"', phone='"+phone+"', email='"+email+"', department='"+department+"', qualification='"+qualification+"' where empid = '"+empid+"'";
    Conn c = new Conn();
    c.s.executeUpdate(query);
    JOptionPane.showMessageDialog(null, "teacher Details Updated Successfully");
    setVisible(false);

    }catch(Exception e){
    e.printStackTrace();
}
    
    }
    }
    public static void main(String[] args){
     
    
    new UpdateTeacher();
    }
}
