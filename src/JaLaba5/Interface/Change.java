package JaLaba5.Interface;
import JaLaba5.Main;
import JaLaba5.User;
import JaLaba5.Interface.UserInter;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Change extends JFrame{
    private JLabel lb1 = new JLabel("Name:");
    private JTextField txt1 = new JTextField(UserInter.us.getName(),10);
    private JLabel lb2 = new JLabel("Login:");
    private JTextField txt2 = new JTextField(UserInter.us.getLogin(),10);
    private JLabel lb3 = new JLabel("Password:");
    private JTextField txt3 = new JTextField(UserInter.us.getPassword(),10);
    private JButton but1 = new JButton("Change");

    public Change(){
        setTitle("Registration");
        setSize(380,240);
        setLocationByPlatform(true);
        setVisible(true);
        //setDefaultCloseOperation(JFrame.C);
        Container container = getContentPane();
        container.setLayout(new GridLayout(4,2,2,2));
        container.add(lb1);
        container.add(txt1);
        container.add(lb2);
        container.add(txt2);
        container.add(lb3);
        container.add(txt3);
        but1.addActionListener(new changeU());
        container.add(but1);
    }
    class changeU implements ActionListener{
        public void actionPerformed(ActionEvent e){
            User user = new User(txt1.getText(),txt2.getText(),txt3.getText());
            UserInter.us = user;
        }
    }
}
