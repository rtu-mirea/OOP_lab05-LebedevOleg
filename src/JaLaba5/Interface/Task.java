package JaLaba5.Interface;
import JaLaba5.Main;
import JaLaba5.Project;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;


public class Task extends JFrame {
    String[] headers = {"Логин","Название проекта", "Баллы", "Приз"};
    String[][] data = new String[Main.projects.size()][4];
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
                    String x1 = String.valueOf(project.get(x).getUser().getPrice());
                    String x2 = String.valueOf(project.get(x).getPoint());
                    data[x][0] = project.get(x).getUser().getLogin();
                    data[x][1] = project.get(x).getName();
                    data[x][2] = x2;
                    data[x][3] = x1;
                }
                else
                    break;
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
