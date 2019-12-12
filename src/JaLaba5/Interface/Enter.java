package JaLaba5.Interface;
import JaLaba5.Main;
import JaLaba5.User;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class Enter extends JFrame {
    private JLabel lb2 = new JLabel("Login:");
    private JTextField txt2 = new JTextField("",5);
    private JLabel lb3 = new JLabel("Password:");
    private JTextField txt3 = new JTextField("",5);
    private JButton but1 = new JButton("Login");

    public Enter(){
        setTitle("Enter");
        setSize(380,240);
        setLocationByPlatform(true);
        setVisible(true);
        Container container = getContentPane();
        container.setLayout(new GridLayout(3,2,2,2));
        container.add(lb2);
        container.add(txt2);
        container.add(lb3);
        container.add(txt3);
        but1.addActionListener(new login());
        container.add(but1);
    }
    class login implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int c = 0;
            for(User i : Main.users) {
                if (txt2.getText().equals("admin") && txt3.getText().equals("1111")) {
                    AdminInter adminInter = new AdminInter();
                    c = 1;
                    break;
                } else if (i.getLogin().equals(txt2.getText()) && i.getPassword().equals(txt3.getText())) {
                    int temp = Main.users.indexOf(i);
                    UserInter userInter = new UserInter(i, temp);
                    c = 1;
                    break;
                }
            }
            if(c == 0){
                JOptionPane.showMessageDialog(null,"Аккаунт не найден","message",JOptionPane.PLAIN_MESSAGE);
            }

        }
    }
}
