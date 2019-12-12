package JaLaba5;

import java.io.Serializable;

 public class  Project implements Serializable {
     public User user;
     private String name;
     private int point;

    public Project(){
        user = new User();
        name = "";
        point = 0;
    }
    public Project(User u,String n,int p){
        user = u;
        name = n;
        point = p;
    }

    public int getPoint() {
        return point;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}