package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateStudent extends JFrame implements ActionListener {

    JLabel lblname, labelname, lblfname, labelfname, lblrollno, labelrollno,lblrollnumber, lbldob, labeldob, lbladdress, lblphone, lblemail,lblxmarks,labelxmarks,lblxiimarks,labelxiimarks, lblaadhar, labelaadhar, lblbranch, lblcourse;
    JTextField tfemail, tfphone, tfaddress, tfbranch, tfcourse;
    JButton update,cancel;
    Choice crollno;
    
    UpdateStudent(){
        setSize(900,700);
        setLocation(350,50);
        
        JLabel heading = new JLabel("Update Student Information");
        heading.setBounds(50,10,500,50);
        heading.setFont(new Font("Serif", Font.BOLD,30));
        add(heading);
        
        JLabel lblrollnumber = new JLabel("Select Roll Number");
        lblrollnumber.setBounds(50,100,200,20);
        lblrollnumber.setFont(new Font("serif",Font.PLAIN,20));
        add(lblrollnumber);
        
        crollno = new Choice();
        crollno.setBounds(250,100,200,30);
        add(crollno);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            while(rs.next()){
                crollno.add(rs.getString("rollno"));
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
        
        lblrollno = new JLabel("Roll no");
        lblrollno.setBounds(60,210,150,30);
        lblrollno.setFont(new Font("Serif",Font.BOLD,20));
        add(lblrollno);
        
        labelrollno = new JLabel();
        labelrollno.setBounds(200,210,150,30);
        labelrollno.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(labelrollno);
        
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
        
        lblbranch = new JLabel("Branch");
        lblbranch.setBounds(60,490,150,30);
        lblbranch.setFont(new Font("Serif",Font.BOLD,20));
        add(lblbranch);
        
        tfbranch = new JTextField();
        tfbranch.setBounds(200,490,150,30);
        tfbranch.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(tfbranch);
        
        lblcourse = new JLabel("Course");
        lblcourse.setBounds(450,490,150,30);
        lblcourse.setFont(new Font("Tahoma",Font.BOLD,18));
        add(lblcourse);
        
        tfcourse = new JTextField();
        tfcourse.setBounds(640,490,150,30);
        tfcourse.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(tfcourse);
        
        try{
            Conn c = new Conn();
            String query = "select * from student where rollno = '"+crollno.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                labelname.setText(rs.getString("name"));
                labelfname.setText(rs.getString("fname"));
                labelrollno.setText(rs.getString("rollno"));
                labeldob.setText(rs.getString("dob"));
                labeldob.setText(rs.getString("dob"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                labelxmarks.setText(rs.getString("class_xmarks"));
                labelxiimarks.setText(rs.getString("class_xiimarks"));
                labelaadhar.setText(rs.getString("aadhar"));
                tfbranch.setText(rs.getString("branch"));
                tfcourse.setText(rs.getString("course"));
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        crollno.addItemListener(new ItemListener(){
        
        public void itemStateChanged(ItemEvent ie){

        try{
        Conn c = new Conn();
        String query = "select * from student where rollno = '"+crollno.getSelectedItem()+"'";
        ResultSet rs = c.s.executeQuery(query);
        while(rs.next()){
        labelname.setText(rs.getString("name"));
        labelfname.setText(rs.getString("fname"));
        labelrollno.setText(rs.getString("rollno"));
        labeldob.setText(rs.getString("dob"));
        tfaddress.setText(rs.getString("address"));
        tfphone.setText(rs.getString("phone"));
        tfemail.setText(rs.getString("email"));
        labelxmarks.setText(rs.getString("class_xmarks"));
        labelxiimarks.setText(rs.getString("class_xiimarks"));
        labelaadhar.setText(rs.getString("aadhar"));
        tfbranch.setText(rs.getString("branch"));
        tfcourse.setText(rs.getString("course"));
                
        
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
    
    String rollno = labelrollno.getText();    
    String address = tfaddress.getText();
    String phone = tfphone.getText();
    String email = tfemail.getText();
    String branch = tfbranch.getText();
    String course = tfcourse.getText();
    
    try{
    String query = "update student set address='"+address+"', phone='"+phone+"', email='"+email+"', branch='"+branch+"', course='"+course+"' where rollno = '"+rollno+"'";
    Conn c = new Conn();
    c.s.executeUpdate(query);
    JOptionPane.showMessageDialog(null, "Students Details Updated Successfully");
    setVisible(false);

    }catch(Exception e){
    e.printStackTrace();
}
    
    }
    }
    public static void main(String[] args){
     
    
    new UpdateStudent();
    }
}
