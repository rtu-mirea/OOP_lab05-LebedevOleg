package JaLaba5.Interface;
import JaLaba5.Main;
import JaLaba5.User;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Reg extends JFrame {
    private JLabel lb1 = new JLabel("Name:");
    private JTextField txt1 = new JTextField("",10);
    private JLabel lb2 = new JLabel("Login:");
    private JTextField txt2 = new JTextField("",10);
    private JLabel lb3 = new JLabel("Password:");
    private JTextField txt3 = new JTextField("",10);
    private JButton but1 = new JButton("Add user");

    public Reg(){
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
        but1.addActionListener(new AddU());
        container.add(but1);

    }
    class AddU implements ActionListener{
        public void actionPerformed(ActionEvent e){
            User user = new User(txt1.getText(),txt2.getText(),txt3.getText());
            Main.users.add(user);
            JOptionPane.showMessageDialog(null,"Login:" + Main.users.get(Main.users.size()-1).getLogin() + "password: " + Main.users.get(Main.users.size()-1).getPassword(),"message",JOptionPane.PLAIN_MESSAGE);
        }
    }

}
