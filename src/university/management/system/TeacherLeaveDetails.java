package university.management.system;

import javax.swing.*;
import java.awt.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;
import java.sql.*;

public class TeacherLeaveDetails extends JFrame implements ActionListener {
    
    Choice cempid;
    JButton search, print, cancel;
    JTable table;
    
    TeacherLeaveDetails(){
        
        getContentPane().setBackground(Color.WHITE);
        
        JLabel heading = new JLabel("Search by Employee ID");
        heading.setBounds(20,20,220,20);
        heading.setFont(new Font("Tahoma",Font.BOLD,16));
        add(heading);
        
        cempid = new Choice();
        cempid.setBounds(240,20,150,20);
        add(cempid);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from teacher");
            
            while(rs.next()){
                cempid.add(rs.getString("empid"));
            }
        }catch(Exception e ){
            e.printStackTrace();
        }
        
        table = new JTable();
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from teacherleave");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            
            e.printStackTrace();
        }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,100,900,600);
        add(jsp);
        
        search = new JButton("Search");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(search);
        
        print = new JButton("print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);
        
        cancel = new JButton("CANCEL");
        cancel.setBounds(220,70,120,20);
        cancel.addActionListener(this);
        add(cancel);
        
        
        setSize(900,700);
        setLocation(300,100);
        setLayout(null);
        setVisible(true);
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == search){
            
            String query = "select * from teacherleave where empid = '"+cempid.getSelectedItem()+"'";
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e ){
                e.printStackTrace();
            }
        }else if(ae.getSource() == print){
            try{
                table.print();
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else if(ae.getSource() == cancel){
            
            setVisible(false);
        }
    }
    
    public static void main(String[] args){
        
        new TeacherLeaveDetails();
    }
    
}
