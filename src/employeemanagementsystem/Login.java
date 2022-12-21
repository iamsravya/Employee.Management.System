package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JTextField tfusername, tfpassword;

    Login(){

        getContentPane().setBackground(Color.WHITE); //to change color of frame
        setLayout(null);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40,20,100,30);
        add(lblusername);

        //for text field(horizontal box for input by user) behind user name and password
        tfusername = new JTextField(); //object of class
        tfusername.setBounds(150,20,150,30);
        add(tfusername);

        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(40,70,100,30);
        add(lblpassword);

        tfpassword = new JTextField(); //object of class
        tfpassword.setBounds(150,70,150,30);
        add(tfpassword);

        JButton login = new JButton("LOGIN");
        login.setBounds(150,140,150,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,0,200,200);
        add(image);


        setSize(600,300);
        setLocation(450,200);
        setVisible(true);
    }


    public void actionPerformed(ActionEvent actionEvent) {
        try{
            String username = tfusername.getText(); //admin
            String password = tfpassword.getText(); //admin

            Conn c = new Conn();

            String query = "select * from login where username = '" +username + "' and password = '"+password+"'";

            ResultSet rs = c.s.executeQuery(query);
            if (rs.next()){
                setVisible(false); //if value is there then next class
                new Home();
            }
            else {
                JOptionPane.showMessageDialog(null,"Invalid username or password");
                setVisible(false);
            }

        } catch (Exception e){
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        new Login();
    }
}
