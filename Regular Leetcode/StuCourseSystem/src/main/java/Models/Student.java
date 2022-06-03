package Models;

public class Student {

    private String name;
    private int ID;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Student(int ID, String name) {
        this.name = name;
        this.ID = ID;
    }

    @Override
    public String toString() {
        return this.getID() + ", " + this.getName();
    }
}
