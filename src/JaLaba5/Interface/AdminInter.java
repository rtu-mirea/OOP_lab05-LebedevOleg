package JaLaba5.Interface;
import JaLaba5.Main;
import JaLaba5.User;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class AdminInter extends JFrame{
    private JButton but1 = new JButton("Запустить конкурс");
    private JTable table = new JTable();

    public AdminInter(){
        setTitle("User window");
        setSize(680,460);
        setLocationByPlatform(true);
        setVisible(true);
        Container container = getContentPane();
        container.setLayout(new GridLayout(4,1,2,2));
        but1.addActionListener(new start());
        container.add(but1);
    }
    class start implements ActionListener{
        public void actionPerformed(ActionEvent e){
            JaLaba5.Interface.start st = new JaLaba5.Interface.start();

        }
    }
}
