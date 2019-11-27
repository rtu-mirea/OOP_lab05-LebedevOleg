package JaLaba5.Interface;
import JaLaba5.User;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;

public class MainForm  extends JFrame {
    private  JButton but1 = new JButton("Войти");
    private  JButton but2 = new JButton("Зарегистрироваться");

    public MainForm(){
        setTitle("JaLaba5");
        setBounds(500,500,380,240);
        setVisible(true);
        //this.setBounds(100,100,250,100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(2,1,2,2));
        but1.addActionListener(new Login());
        container.add(but1);
        but2.addActionListener(new Registration());
        container.add(but2);
    }
    class Login implements ActionListener{
        public void actionPerformed(ActionEvent e){
            JOptionPane.showMessageDialog(null,"kek","rer",JOptionPane.PLAIN_MESSAGE);
        }
    }
    class Registration implements ActionListener{
        public void actionPerformed(ActionEvent e){
            Reg window = new Reg();
        }
    }
}
