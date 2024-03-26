package by.TestFireAlarm.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Table(name = "logs")
public class LogsTest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private Users users;

    @Column(name="start")
    @CreationTimestamp
    private Timestamp testStart;

    @Column(name = "end")
    @CreationTimestamp
    private Timestamp testEnd;

    @Column(name="status")
    private String status;

    @Column(name = "tickets")
    private String tickets;

    @Column(name = "answers")
    private String answers;

    @Column(name = "answer_origin")
    private String answerOrigin;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Timestamp getTestStart() {
        return testStart;
    }

    public void setTestStart(Timestamp testStart) {
        this.testStart = testStart;
    }

    public Timestamp getTestEnd() {
        return testEnd;
    }

    public void setTestEnd(Timestamp testEnd) {
        this.testEnd = testEnd;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTickets() {
        return tickets;
    }

    public String getAnswerOrigin() {
        return answerOrigin;
    }

    public void setAnswerOrigin(String answerOrigin) {
        this.answerOrigin = answerOrigin;
    }

    public void setTickets(String tickets) {
        this.tickets = tickets;
    }

    public String getAnswers() {
        return answers;
    }

    public void setAnswers(String answers) {
        this.answers = answers;
    }
}
