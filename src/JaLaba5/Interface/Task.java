package JaLaba5.Interface;
import JaLaba5.Main;
import JaLaba5.Project;
import JaLaba5.User;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;


public class Task extends JFrame {
    Object[] headers = {"Логин","Название проекта", "Баллы", "Приз"};
    Object[][] data = new Object[4][Main.projects.size()];
    private JTable jTable;

    public Task(int budjet,int min_summ){

        ArrayList<Project> project = Main.projects;
        project.sort(new Comparator<Project>() {
            @Override
            public int compare(Project o1, Project o2) {
                if (o1.getPoint() < o2.getPoint())
                    return 1;
                else if (o1.getPoint() > o2.getPoint())
                    return -1;
                else
                    return 0;
            }
        });//
        if (budjet > 0) {
            int i = 0, k = 9;
            while (i <= 2 && i < project.size()) {
                switch (i) {
                    case 0:
                        project.get(i).getUser().setPrice(budjet / 100 * 60);
                        break;
                    case 1:
                        project.get(i).getUser().setPrice(budjet / 100 * 15);
                        break;
                    case 2:
                        project.get(i).getUser().setPrice(budjet / 100 * 10);
                        break;
                }
                i++;
            }
            budjet = budjet / 100 * 15;
            while (i < project.size() && k > 0) {
                project.get(i).getUser().setPrice(budjet / 100 * k);
                i++;
                k--;
            }
            for (int x = 0; x < project.size(); x++) {
                if (project.get(x).getUser().getPrice() >= min_summ){
                    data[0][x] = project.get(x).getUser().getLogin();
                    data[1][x] = project.get(x).getName();
                    data[2][x] = project.get(x).getUser().getPrice();
                }
            }
        }

        setTitle("Task");
        setSize(400,300);
        setLocationByPlatform(true);
        setVisible(true);
        Container container = getContentPane();
        container.setLayout(new GridLayout(1,1,2,2));
        jTable = new JTable(data,headers);
        JScrollPane jScrollPane = new JScrollPane(jTable);
        jTable.setPreferredScrollableViewportSize(new Dimension(380,280));
        container.add(jTable);


    }
}
