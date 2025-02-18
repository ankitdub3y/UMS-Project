package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class Project extends JFrame implements ActionListener{
   

Project(){

        setSize(1440, 920);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2= i1.getImage().getScaledInstance(1400, 820, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
        
        JMenuBar mb= new JMenuBar();
        
        // NEW INFORMATION
        
        JMenu newInformation= new JMenu("New Information");
        newInformation.setForeground(Color.BLUE);
        mb.add(newInformation);
        
        JMenuItem facultyinfo = new JMenuItem("Faculty Information");
        facultyinfo.setForeground(Color.BLACK);
        facultyinfo.addActionListener(this);
        newInformation.add(facultyinfo);
        
        JMenuItem studentinfo = new JMenuItem("Student Information");
        studentinfo.setForeground(Color.BLACK);
        studentinfo.addActionListener(this);
        newInformation.add(studentinfo);
        
        //VIEW DETAILS
        
        JMenu viewDetails = new JMenu("View Details");
        viewDetails.setForeground(Color.BLUE);
        mb.add(viewDetails);
        
        JMenuItem facultydetails = new JMenuItem("Faculty Details");
        facultydetails.setForeground(Color.BLACK);
        facultydetails.addActionListener(this);
        viewDetails.add(facultydetails);
        
        JMenuItem studentdetails= new JMenuItem("Student Details");
        studentdetails.setForeground(Color.BLACK);
        studentdetails.addActionListener(this);
        viewDetails.add(studentdetails);
        
        //LEAVE
        
        JMenu leave = new JMenu("Apply Leave ");
        leave.setForeground(Color.RED);
        mb.add(leave);
        
        JMenuItem facultyleave = new JMenuItem("Faculty Leave");
        facultyleave.setForeground(Color.BLACK);
        facultyleave.addActionListener(this);
        leave.add(facultyleave);
        
        JMenuItem studentleave = new JMenuItem("Student Leave");
        studentleave.setForeground(Color.BLACK);
        studentleave.addActionListener(this);
        leave.add(studentleave);
        
        // LEAVE DETAILS
        
        JMenu leaveDetails = new JMenu("Leave Details");
        leaveDetails.setForeground(Color.BLUE);
        mb.add(leaveDetails);
        
        JMenuItem facultyLeaveDetails = new JMenuItem("Faculty Leave Details");
        facultyLeaveDetails.setForeground(Color.BLACK);
        facultyLeaveDetails.addActionListener(this);
        leaveDetails.add(facultyLeaveDetails);

        JMenuItem studentLeaveDetails = new JMenuItem("Student Leave Details");
        studentLeaveDetails.setForeground(Color.BLACK);
        studentLeaveDetails.addActionListener(this);
        leaveDetails.add(studentLeaveDetails);
        
        //EXAM
        
        
        JMenu exam = new JMenu("Examination");
        exam.setForeground(Color.BLUE);
        mb.add(exam);
        
        JMenuItem examresults= new JMenuItem("Examination Results");
        examresults.setForeground(Color.BLACK);
        examresults.addActionListener(this);
        exam.add(examresults);

        JMenuItem entermarks = new JMenuItem("Enter Marks");
        entermarks.setForeground(Color.BLACK);
        entermarks.addActionListener(this);
        exam.add(entermarks);
        
        //UPDATE INFO
        
        JMenu updateinfo = new JMenu(" Update Details");
        updateinfo.setForeground(Color.GREEN);
        mb.add(updateinfo);
        
        JMenuItem updatefacultyinfo = new JMenuItem("Update Faculty Details");
        updatefacultyinfo.setForeground(Color.BLACK);
        updatefacultyinfo.addActionListener(this);
        updateinfo.add(updatefacultyinfo);
        
        JMenuItem updatestudentinfo = new JMenuItem("Update Student Details");
        updatestudentinfo.setForeground(Color.BLACK);
        updatestudentinfo.addActionListener(this);
        updateinfo.add(updatestudentinfo);
        
        //FEE
        
        JMenu fee = new JMenu("Fee Details");
        fee.setForeground(Color.BLUE);
        mb.add(fee);
        
        JMenuItem feestructure = new JMenuItem("Fee Structure");
        feestructure.setForeground(Color.BLACK);
        feestructure.addActionListener(this);
        fee.add(feestructure);
        
        JMenuItem feeform = new JMenuItem("Student Fee Form");
        feeform.setForeground(Color.BLACK);
        feeform.addActionListener(this);
        fee.add(feeform);
        
        //UTILITY
        
        JMenu utility = new JMenu("Utility");
        utility.setForeground(Color.BLUE);
        mb.add(utility);
        
        JMenuItem notepad= new JMenuItem("Notepad");
        notepad.setForeground(Color.BLACK);
        notepad.addActionListener(this);
        utility.add(notepad);
        
        JMenuItem calc=new JMenuItem("Calculator");
        calc.setForeground(Color.BLACK);
        calc.addActionListener(this);
        utility.add(calc);
        
        JMenu advancedutility= new JMenu("Advanced utility");
        advancedutility.setForeground(Color.BLUE);
        mb.add(advancedutility);
        
        JMenuItem mspaint= new JMenuItem("MS Paint");
        mspaint.setForeground(Color.BLACK);
        mspaint.addActionListener(this);
        advancedutility.add(mspaint);
        
        //About
        
        JMenu about = new JMenu("About");
        about.setForeground(Color.BLUE);
        mb.add(about);
        
        JMenuItem abot = new JMenuItem("About");
        abot.setForeground(Color.BLACK);
        abot.addActionListener(this);
        about.add(abot);
        
        
        //EXIT

        JMenu exit= new JMenu("Exit");
        exit.setForeground(Color.RED);
        mb.add(exit);
        
        JMenuItem confirm=new JMenuItem("Confirm");
        confirm.setForeground(Color.GREEN);
        confirm.addActionListener(this);
        exit.add(confirm);
     
        setJMenuBar(mb);

        
        setVisible(true);

}

public void actionPerformed(ActionEvent ae){
    
    String msg= ae.getActionCommand();
    
    if(msg.equals("Confirm")){
        
        setVisible(false);
    }else if(msg.equals("Calculator")){
        
     try{
         Runtime.getRuntime().exec("calc.exe");
         
     }   catch(Exception e) {
         
         }
    }    else if(msg.equals("Notepad")){
        
     try{
         Runtime.getRuntime().exec("notepad.exe");
         
     }   catch(Exception e) {
         
     }
    }  else if(msg.equals("MS Paint")){
        
     try{
         Runtime.getRuntime().exec("mspaint.exe") ;  
         
     }   catch(Exception e) {
         
         
}
    }else if(msg.equals("Faculty Information")){
        new AddTeacher();
    }else if(msg.equals("Student Information")){
        new AddStudent();
    }else if(msg.equals("Faculty Details")){
        new TeacherDetails();
    }else if(msg.equals("Student Details")){
        new StudentDetails();
}   else if (msg.equals("Faculty Leave")){
    new TeacherLeave();
}   else if(msg.equals("Student Leave")){
    new StudentLeave();
}   else if(msg.equals("Faculty Leave Details")){
    new TeacherLeaveDetails();
}   else if(msg.equals("Student Leave Details")){
    new StudentLeaveDetails();
}
    else if (msg.equals("Update Faculty Details")){
    new UpdateTeacher();
}   else if (msg.equals("Update Student Details")){
    new UpdateStudent();

}   else if(msg.equals("Enter Marks")){
    new EnterMarks();
}   else if(msg.equals("Examination Results")){
    new ExaminationDetails();
}   else if(msg.equals("Fee Structure")){
    new FeeStructure();
}   else if(msg.equals("Student Fee Form")){
    new StudentFeeForm();
}   
    else if(msg.equals("About")){
    new About();
}
}
public static void main(String args[]){
    
    new Project();
    
}
}