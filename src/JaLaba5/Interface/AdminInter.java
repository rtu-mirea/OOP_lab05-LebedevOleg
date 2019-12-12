package JaLaba5.Interface;

import JaLaba5.Main;
import JaLaba5.Project;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class AdminInter extends JFrame{
    private JButton but1 = new JButton("Запустить конкурс");
    private JButton but2 = new JButton("Изменить данные участника ");
    private JTextField txt1 = new JTextField("",5);
    String[] headers = {"Логин","Название проекта", "Баллы", "Приз"};
    String[][] data = new String[Main.projects.size()][4];
    private JTable table;
    public static Project user = new Project();

    public AdminInter(){
        setTitle("User window");
        setSize(680,460);
        setLocationByPlatform(true);
        setVisible(true);
        Container container = getContentPane();
        container.setLayout(new GridLayout(4,2,2,2));
        but1.addActionListener(new start());
        but2.addActionListener(new correct());
        if (Main.projects.size() != 0) {
            for (int x = 0; x < Main.projects.size(); x++) {
                String x1 = String.valueOf(Main.projects.get(x).getPoint());
                String x2 = String.valueOf(Main.projects.get(x).getUser().getPrice());
                data[x][0] = Main.projects.get(x).getUser().getLogin();
                data[x][1] = Main.projects.get(x).getName();
                data[x][2] = x1;
                data[x][3] = x2;
            }
        }
        table = new JTable(data,headers);
        table.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        table.setForeground(Color.blue);
        table.setAlignmentX(Component.LEFT_ALIGNMENT);
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        table.setFillsViewportHeight(true);
        JScrollPane sp = new JScrollPane(table);
        container.add(but1);
        container.add(but2);
        container.add(txt1);
        container.add(table);

    }
    class start implements ActionListener{
        public void actionPerformed(ActionEvent e){
            JaLaba5.Interface.start st = new JaLaba5.Interface.start();
        }
    }
    class correct implements ActionListener{
        public void actionPerformed(ActionEvent e){
            user = Main.projects.get(Integer.parseInt(txt1.getText()));
            Change2 change2 = new Change2(Integer.parseInt(txt1.getText()));

        }
    }
}
