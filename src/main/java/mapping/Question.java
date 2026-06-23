package mapping;

import jakarta.persistence.*;

@Entity
public class Question {
    @Id
    @Column (name = "question_id")
    private int questionId;
    @Column(name = "question")
    private String question;

    @OneToOne
    @JoinColumn(name = "a_id")
    private Answer answer;

    public Question(int questionId, String question, Answer answer) {
        this.questionId = questionId;
        this.question = question;
        this.answer = answer;
    }

    public Question() {
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
