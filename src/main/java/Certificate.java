import jakarta.persistence.*;

@Embeddable
@Table(name = "certificate")
public class Certificate {
    @Column(name = "course")
    private String course;

    @Column(name = "duration")
    private String duration;

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Certificate() {
        super();
    }

    public Certificate(String duration, String course) {
        this.duration = duration;
        this.course = course;
    }
}
