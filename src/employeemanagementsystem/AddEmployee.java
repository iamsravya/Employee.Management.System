package employee.management.system;

import javax.swing.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;

import java.awt.event.*;
import java.util.*;

public class AddEmployee extends JFrame implements ActionListener {

    Random ran = new Random();
    int number = ran.nextInt(999999); //generate employee id

    JTextField  tfname, tffname, tfaddress, tfphone, tfssn, tfemail,tfsalary,tfdesignation;
    JDateChooser dcdob;
    JComboBox cbeducation;
    JLabel lblempid;
    JButton add,back;

    AddEmployee(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Add Employee Details");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD,25));
        add(heading);

        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50,150,150,30);
        labelname.setFont(new Font("serif", Font.PLAIN,20));
        add(labelname);

        tfname = new JTextField();
        tfname.setBounds(200,150,150,30);
        add(tfname);

        JLabel labelfname = new JLabel("Father's Name");
        labelfname.setBounds(400,150,150,30);
        labelfname.setFont(new Font("serif", Font.PLAIN,20));
        add(labelfname);

        tffname = new JTextField();
        tffname.setBounds(600,150,150,30);
        add(tffname);

        JLabel labeldob = new JLabel("Date Of Birth");
        labeldob.setBounds(50,200,150,30);
        labeldob.setFont(new Font("serif", Font.PLAIN,20));
        add(labeldob);

        dcdob = new JDateChooser(); //date chooser
        dcdob.setBounds(200,200,150,30);
        add(dcdob);

        JLabel labelsalary = new JLabel("Salary");
        labelsalary.setBounds(400,200,150,30);
        labelsalary.setFont(new Font("serif", Font.PLAIN,20));
        add(labelsalary);

        tfsalary = new JTextField();
        tfsalary.setBounds(600,200,150,30);
        add(tfsalary);

        JLabel labeladdress = new JLabel("Address");
        labeladdress.setBounds(50,250,150,30);
        labeladdress.setFont(new Font("serif", Font.PLAIN,20));
        add(labeladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(200,250,150,30);
        add(tfaddress);

        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(400,250,150,30);
        labelphone.setFont(new Font("serif", Font.PLAIN,20));
        add(labelphone);

        tfphone = new JTextField();
        tfphone.setBounds(600,250,150,30);
        add(tfphone);

        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50,300,150,30);
        labelemail.setFont(new Font("serif", Font.PLAIN,20));
        add(labelemail);

        tfemail = new JTextField();
        tfemail.setBounds(200,300,150,30);
        add(tfemail);

        JLabel labeleducation = new JLabel("Highest Education");
        labeleducation.setBounds(400,300,150,30);
        labeleducation.setFont(new Font("serif", Font.PLAIN,20));
        add(labeleducation);

        //dropdown using combobox
        String courses[] = {"BBA","BCA","BA","BSC","BTECH","MBA","MCA","MA","MTECH","MSC","PHD"};
        cbeducation = new JComboBox(courses);
        cbeducation.setBackground(Color.WHITE);
        cbeducation.setBounds(600,300,150,30);
        add(cbeducation);


        JLabel labeldesignation = new JLabel("Designation");
        labeldesignation.setBounds(50,350,150,30);
        labeldesignation.setFont(new Font("serif", Font.PLAIN,20));
        add(labeldesignation);

        tfdesignation = new JTextField();
        tfdesignation.setBounds(200,350,150,30);
        add(tfdesignation);

        JLabel labelssn = new JLabel("SSN");
        labelssn.setBounds(400,350,150,30);
        labelssn.setFont(new Font("serif", Font.PLAIN,20));
        add(labelssn);

        tfssn = new JTextField();
        tfssn.setBounds(600,350,150,30);
        add(tfssn);


        JLabel labelempid = new JLabel("Employee ID");
        labelempid.setBounds(50,400,150,30);
        labelempid.setFont(new Font("serif", Font.PLAIN,20));
        add(labelempid);

        lblempid = new JLabel("" + number);
        lblempid.setBounds(200,400,150,30);
        lblempid.setFont(new Font("serif", Font.PLAIN,20));
        add(lblempid);

        add = new JButton("Add Details");
        add.setBounds(250,550,150,40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.white);
        add(add);

        back = new JButton("BACK");
        back.setBounds(450,550,150,40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        add(back);


        setSize(900,700);
        setLocation(300,50);
        setVisible(true);

    }

    public void  actionPerformed(ActionEvent actionEvent){
        if (actionEvent.getSource() == add){
            String name = tfname.getText();
            String fname = tffname.getText();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String salary = tfsalary.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String education = (String) cbeducation.getSelectedItem();
            String ssn = tfssn.getText();
            String designation = tfdesignation.getText();
            String empid = lblempid.getText();

            try{
                Conn conn = new Conn();
                String query = "insert into employee values('"+name+"','"+fname+"', '"+dob+"', '"+salary+"', '"+address+"', '"+phone+"', '"+email+"', '"+education+"', '"+designation+"', '"+ssn+"', '"+empid+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null," Details added successsfully");
                setVisible(false);
                new Home();

            } catch (Exception e){
                e.printStackTrace();
            }

        } else{
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new AddEmployee();
    }
}
