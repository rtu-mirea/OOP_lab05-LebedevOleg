package JaLaba5;

public class Project {
    private User user = null;
    private String name;
    private int point;

    public Project(){
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