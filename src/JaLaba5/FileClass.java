package JaLaba5;

import java.io.*;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class FileClass implements Serializable {
    private String fname = "";
    private ArrayList<Project> temp;

    public void write(ArrayList<Project> carts,String name) throws Exception {
        fname = name;
        FileOutputStream out = new FileOutputStream(fname);
        ObjectOutputStream oos = new ObjectOutputStream(out);
        oos.writeObject(carts);
    }

    public ArrayList<Project> reading(String naming) throws Exception  {
        fname = naming;
        FileInputStream in = new FileInputStream(fname);
        ObjectInputStream oin = new ObjectInputStream(in);
        temp = (ArrayList) oin.readObject();
        return temp;
    }
}