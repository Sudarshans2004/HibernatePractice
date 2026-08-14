package mapping.onetomanyormanytoone;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Question {
    @Id
    @Column (name = "question_id")
    private int questionId;
    @Column(name = "question")
    private String question;
// eager loading
    @OneToMany(mappedBy = "question",fetch = FetchType.EAGER)
    private List<Answer> answers = new ArrayList<>();

    public Question() {
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> list) {
        this.answers = list;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public Question(int questionId, List<Answer> list, String question) {
        this.questionId = questionId;
        this.answers = answers;
        this.question = question;
    }
}
