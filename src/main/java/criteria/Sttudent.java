package criteria;

import java.io.Serializable;

public class Sttudent implements Serializable {

    private static final long serialVersionUID = 123L;

    int id;
    String name;

    public Sttudent(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "'}";
    }
}
