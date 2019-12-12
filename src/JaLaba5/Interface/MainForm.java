package JaLaba5.Interface;
import JaLaba5.FileClass;
import JaLaba5.Main;
import JaLaba5.Project;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

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
        but2.addActionListener(new Registration());
        but3.addActionListener(new Read());
        but4.addActionListener(new Write());
        container.add(but1);
        container.add(but2);
        container.add(but3);
        container.add(but4);
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
            JFileChooser fileChooser = new JFileChooser("C:/Git/OOP_lab05-LebedevOleg");
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int res = fileChooser.showOpenDialog(fileChooser);
            String name = fileChooser.getSelectedFile().getPath();
            FileClass file = new FileClass();
            try {
                Main.projects = file.reading(name);
                for(Project i : Main.projects){
                    Main.users.add(i.getUser());
                }
            }
            catch (Exception a){
                System.out.println(a);
                //JOptionPane.showMessageDialog(null, "error", "message",JOptionPane.PLAIN_MESSAGE);
            }

        }
    }
    class Write implements ActionListener{
        public void actionPerformed(ActionEvent e){
            JFileChooser fileChooser = new JFileChooser("C:/Git/OOP_lab05-LebedevOleg");
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int res = fileChooser.showOpenDialog(fileChooser);
            String name = fileChooser.getSelectedFile().getAbsolutePath();
            //File selectedFile = fileChooser.getSelectedFile();
            FileClass file = new FileClass();
            try{
                file.write(Main.projects,name);
            }
            catch (Exception a){
                System.out.println(a);
            }
        }
    }
}
