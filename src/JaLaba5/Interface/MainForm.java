package JaLaba5.Interface;
import JaLaba5.FileClass;
import JaLaba5.Main;
import JaLaba5.User;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;

public class MainForm  extends JFrame {
    private  JButton but1 = new JButton("Войти");
    private  JButton but2 = new JButton("Зарегистрироваться");
    private JButton but3 = new JButton("Читать список с текста");
    private  JButton but4 = new JButton("Запись");

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
        but3.addActionListener(new Read());
        container.add(but3);
    }
    class Login implements ActionListener{
        public void actionPerformed(ActionEvent e){
            Enter login = new Enter();
        }
    }
    class Registration implements ActionListener{
        public void actionPerformed(ActionEvent e){
            Reg window = new Reg();
        }
    }
    class Read implements ActionListener{
        public void actionPerformed(ActionEvent e){
            JFileChooser fileChooser = new JFileChooser("C:/Users/gnus/Documents/Институт/Java/JaLaba5");
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int res = fileChooser.showOpenDialog(fileChooser);
            String name = fileChooser.getSelectedFile().getName();
            FileClass file = new FileClass();
            try {
                Main.projects = file.reading(name);
            }
            catch (Exception a){
                System.out.println(a.getMessage());
                //JOptionPane.showMessageDialog(null, "error", "message",JOptionPane.PLAIN_MESSAGE);
            }

        }
    }
}
