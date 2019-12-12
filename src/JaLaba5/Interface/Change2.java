package JaLaba5.Interface;
import JaLaba5.Main;
import JaLaba5.User;
import JaLaba5.Project;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import JaLaba5.Interface.AdminInter;

public class Change2  extends JFrame{
    private JLabel lb1 = new JLabel("User Name:");
    private JTextField txt1 = new JTextField(AdminInter.user.getUser().getName(),10);
    private JLabel lb2 = new JLabel("User Login:");
    private JTextField txt2 = new JTextField(AdminInter.user.getUser().getLogin(),10);
    private JLabel lb3 = new JLabel("User Password:");
    private JTextField txt3 = new JTextField(AdminInter.user.getUser().getPassword(),10);
    private JLabel lb4 = new JLabel("Project name:");
    private JTextField txt4 = new JTextField(AdminInter.user.getName(),10);
    private JLabel lb5 = new JLabel("Project score:");
    private JTextField txt5 = new JTextField(String.valueOf(AdminInter.user.getPoint()),10);
    private JButton but1 = new JButton("Change");
    private int n;
    public Change2(int us){
        n= us;
        setTitle("Registration");
        setSize(380,240);
        setLocationByPlatform(true);
        setVisible(true);
        //setDefaultCloseOperation(JFrame.C);
        Container container = getContentPane();
        container.setLayout(new GridLayout(6,2,2,2));
        container.add(lb4);
        container.add(txt4);
        container.add(lb5);
        container.add(txt5);
        container.add(lb1);
        container.add(txt1);
        container.add(lb2);
        container.add(txt2);
        container.add(lb3);
        container.add(txt3);
        but1.addActionListener(new ChangeU());
        container.add(but1);
    }
    class ChangeU  implements ActionListener{
        public void actionPerformed(ActionEvent e){
            User user = new User(txt1.getText(),txt2.getText(),txt3.getText());
            try {
                Project project = new Project(user, txt4.getText(), Integer.parseInt(txt5.getText()));
                Main.projects.set(n,project);
            }
            catch (Exception a){
                JOptionPane.showMessageDialog(null,"Введенны неверные данные","message",JOptionPane.PLAIN_MESSAGE);
            }
        }
    }

}
