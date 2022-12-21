package employee.management.system;

import javax.swing.*; //for jframe
import java.awt.*; //for color
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Splash extends JFrame implements ActionListener {
    Splash(){
        getContentPane().setBackground(Color.WHITE); //for color use this function
        setLayout(null);

        JLabel heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        heading.setBounds(80,30,1200,60);
        heading.setFont(new Font("serif",Font.PLAIN,60));
        heading.setForeground(Color.RED);
        add(heading);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1100,700,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(50,100,1050,500);
        add(image);

        JButton clickHereToContinue = new JButton("CLICK HERE TO CONTINUE");
        clickHereToContinue.setBounds(400,400,300,70);
        clickHereToContinue.setBackground(Color.BLACK);
        clickHereToContinue.setForeground(Color.white);
        clickHereToContinue.addActionListener(this); //after clicking button click event is performed

        image.add(clickHereToContinue);

        setSize(1170,650);
        setLocation(200,50);
        setVisible(true);

        //for dipper
        while(true){
            heading.setVisible(false);
            try {
                Thread.sleep(500); //for how much time it will stop dipper in milliseconds

            } catch (Exception e){

            }

            heading.setVisible(true);
            try {
                Thread.sleep(500); //for how much time it will stop dipper in milliseconds

            } catch (Exception e){

            }
        }

    }

    //override a method in Actionlistner
    public void actionPerformed(ActionEvent actionEvent){
        setVisible(false); //it will close current frame
        new Login(); //to connect with login page

    }


    public static void main(String[] args) {
        new Splash();
    }

}
