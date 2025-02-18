
package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class StudentFeeForm extends JFrame implements ActionListener{
    
    Choice crollno;
    JLabel labelname, labelfname, labeltotal;
    JComboBox cbcourse, cbbranch, cbsemester;
    JButton update, payfee, cancel;
    
    StudentFeeForm(){
        
        setSize(800,500);
        setLocation(400,150);
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fee.jpg"));
        Image i2 = i1.getImage().getScaledInstance(380,380, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,0,380,380);
        add(image);
        
        JLabel rollno = new JLabel("Select Roll no");
        rollno.setBounds(50,40,150,30);
        rollno.setFont(new Font("Tahoma",Font.BOLD,18));
        add(rollno);
        
        crollno = new Choice();
        crollno.setBounds(220,45,150,30);
        crollno.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(crollno);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            while(rs.next()){
                crollno.add(rs.getString("rollno"));
                
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50,80,150,30);
        lblname.setFont(new Font("Tahoma",Font.BOLD,18));
        add(lblname);
        
        labelname = new JLabel();
        labelname.setBounds(220,80,150,30);
        labelname.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(labelname);
        
        JLabel lblfname = new JLabel("Father's Name");
        lblfname.setBounds(50,120,150,30);
        lblfname.setFont(new Font("Tahoma",Font.BOLD,18));
        add(lblfname);
        
        labelfname = new JLabel();
        labelfname.setBounds(220,120,150,30);
        labelfname.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(labelfname);
        
        try {
            Conn c = new Conn();
            String query = "select * from student where rollno = '"+crollno.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                labelname.setText(rs.getString("name"));
                labelfname.setText(rs.getString("fname"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        crollno.addItemListener(new ItemListener(){
        public void itemStateChanged(ItemEvent ie){
         
            try {
                Conn c = new Conn();
                String query = "select * from student where rollno = '"+crollno.getSelectedItem()+"'";
                ResultSet rs = c.s.executeQuery(query);
                while(rs.next()){
                    labelname.setText(rs.getString("name"));
                    labelfname.setText(rs.getString("fname"));
                }
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        });
        JLabel lblcourse = new JLabel("Course");
        lblcourse.setBounds(50,160,150,30);
        lblcourse.setFont(new Font("Tahoma",Font.BOLD,18));
        add(lblcourse);
        
        String course[] = {"BCA", "BTech", "BBA", "BCom", "Bsc", "MCA", "MTech", "MBA", "MCom", "MSc"};
        cbcourse = new JComboBox(course);
        cbcourse.setBounds(220,160,150,30);
        cbcourse.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(cbcourse);
        
        JLabel lblbranch = new JLabel("Branch");
        lblbranch.setBounds(50,200,150,30);
        lblbranch.setFont(new Font("Tahoma",Font.BOLD,18));
        add(lblbranch);
        
        String branch[] = {"Mechanical", "Electrical", "Computer Science", "Civil"};
        cbbranch = new JComboBox(branch);
        cbbranch.setBounds(220,200,150,30);
        cbbranch.setFont(new Font("Tahoma", Font.PLAIN,15));
        add(cbbranch);
        
        JLabel lblsemester = new JLabel("Semester");
        lblsemester.setBounds(50,240,150,30);
        lblsemester.setFont(new Font("Tahoma",Font.BOLD,18));
        add(lblsemester);
        
        String semester[] = {"Semester1", "Semester2", "Semester3", "Semester4", "Semester5", "Semester6", "Semester7", "Semester8"};
        cbsemester = new JComboBox(semester);
        cbsemester.setBounds(220,240,150,30);
        cbsemester.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(cbsemester);
        
        JLabel lbltotal = new JLabel("Total Payable");
        lbltotal.setBounds(50,280,150,30);
        lbltotal.setFont(new Font("Tahoma",Font.BOLD,18));
        add(lbltotal);
        
        labeltotal = new JLabel();
        labeltotal.setBounds(220,280,150,30);
        labeltotal.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(labeltotal);
        
        update = new JButton("Update");
        update.setBounds(30,360,100,50);
        update.setForeground(Color.WHITE);
        update.setBackground(Color.BLACK);
        update.addActionListener(this);
        update.setFont(new Font("Serif",Font.BOLD,15));
        add(update);
        
        payfee = new JButton("Pay Fee");
        payfee.setBounds(150,360,100,50);
        payfee.setForeground(Color.WHITE);
        payfee.setBackground(Color.BLACK);
        payfee.addActionListener(this);
        payfee.setFont(new Font("Serif",Font.BOLD,15));
        add(payfee);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(270,360,100,50);
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma",Font.BOLD,15));
        add(cancel);
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == update){
            String course =(String) cbcourse.getSelectedItem();
            String semester =(String) cbsemester.getSelectedItem();
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from fee where course = '"+course+"'");
                while(rs.next()){
                    labeltotal.setText(rs.getString(semester));
                }
                
            }catch(Exception e){
                e.printStackTrace();
            }
        } else if(ae.getSource() == payfee){
            String rollno = (String) crollno.getSelectedItem();
            String course = (String) cbcourse.getSelectedItem();
            String branch = (String) cbbranch.getSelectedItem();
            String semester = (String) cbsemester.getSelectedItem();
            String total = (String) labeltotal.getText();
            
            try{
                Conn c = new Conn();
                String query = "insert into collegefee values('"+rollno+"', '"+course+"', '"+branch+"', '"+semester+"', '"+total+"')";
                
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Fee Paid Successfully");
                setVisible(false);
                
            }catch(Exception e){
                e.printStackTrace();
            }
        } else{
            setVisible(false);
        }
    }
    public static void main(String[] args){
        new StudentFeeForm();
    }
}
