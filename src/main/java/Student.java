import jakarta.persistence.*;

//This tells Hibernate "Hey, this Java class is a database table".
//Without this, Hibernate ignores the class completely.
@Entity

@Table(name = "student") // gives table name which table name to use in my sql
public class Student {

    @Id //This tells Hibernate "id is the Primary Key" of the table.

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //hibernate will automatically generate values for that using
                                                        //an internal sequence
    private int id;

    @Column(name = "name") //this maps java var name to my sql column name
    private String name;
    @Embedded
    private Certificate certi;
    public Certificate getCerti() { return certi; }
    public void setCerti(Certificate certi) { this.certi = certi; }


    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "'}";
    }

//    @Transient = this tells hibernate not to save fields
//    @Temporal() = over a date field tell us hibernate the format in which the date needs to be saved
//    @Lob = tells hibernate that this is a large data not a simple Object
}