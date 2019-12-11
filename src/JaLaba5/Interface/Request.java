package JaLaba5.Interface;
import JaLaba5.Main;
import JaLaba5.Project;
import JaLaba5.User;
import JaLaba5.Interface.UserInter;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class Request extends JFrame{
    private JLabel lb1 = new JLabel("Название");
    private JTextField txt1 = new JTextField("",5);
    private JLabel lb2 = new JLabel("Колличество баллов");
    private JTextField txt2 = new JTextField("",5);
    private JButton but1 = new JButton("Оставить заявку");
    private static int temp;

    public Request(int num){
        temp = num;
        setTitle("request");
        setSize(380,240);
        setLocationByPlatform(true);
        setVisible(true);
        Container container = getContentPane();
        container.setLayout(new GridLayout(3,2,2,2));
        container.add(lb1);
        container.add(txt1);
        container.add(lb2);
        container.add(txt2);
        but1.addActionListener(new work());
        container.add(but1);
    }
    class work implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try{
                Project project = new Project(Main.users.get(temp),txt1.getText(),Integer.parseInt(txt2.getText()));
                Main.projects.add(project);
            }
            catch (Exception a){
                JOptionPane.showMessageDialog(null,"Вы ввели неправлиные данные","message",JOptionPane.PLAIN_MESSAGE);
            }
        }
    }
}
