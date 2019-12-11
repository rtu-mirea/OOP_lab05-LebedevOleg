package JaLaba5;
import JaLaba5.Interface.MainForm;

import java.util.ArrayList;

public class Main {
    public static ArrayList<User> users = new ArrayList<>();
    public static ArrayList<Project> projects = new ArrayList<>();


    public static void main(String[] args) {
        User admin = new User();
        users.add(admin);
	    MainForm app = new MainForm();


    }
}
