package JaLaba5.Interface;
import JaLaba5.Main;
import JaLaba5.User;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class UserInter extends JFrame {
    private JButton but1 = new JButton("Оставить заявку");
    private JButton but2 = new JButton("Изменить личные данные");
    public static User us;
    private static int num;
    public static int index;


    public UserInter(User user, int temp){
        us = user;
        num = temp;
        setTitle("User window");
        setSize(680,460);
        setLocationByPlatform(true);
        setVisible(true);
        Container container = getContentPane();
        container.setLayout(new GridLayout(4,1,2,2));
        but1.addActionListener(new form());
        but2.addActionListener(new change());
        container.add(but1);
        container.add(but2);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }
            @Override
            public void windowClosing(WindowEvent e) {
                Main.users.set(temp,us);
                setVisible(false);
            }
            @Override
            public void windowClosed(WindowEvent e) {

            }
            @Override
            public void windowIconified(WindowEvent e) {

            }
            @Override
            public void windowDeiconified(WindowEvent e) {

            }
            @Override
            public void windowActivated(WindowEvent e) {

            }
            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
    }
    class form implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            Request request = new Request(num);
        }
    }
    class change implements ActionListener{
        public void actionPerformed(ActionEvent e){
            Change change = new Change();
        }
    }
}