package by.TestFireAlarm.entity;

import by.TestFireAlarm.dao.Status;
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
    @Enumerated(EnumType.ORDINAL)
    private Status status;

    @Column(name = "tickets")
    private String ListTickets;

    @Column(name = "answers")
    private String ListAnswers;

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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getListTickets() {
        return ListTickets;
    }

    public void setListTickets(String listTickets) {
        ListTickets = listTickets;
    }

    public String getListAnswers() {
        return ListAnswers;
    }

    public void setListAnswers(String listAnswers) {
        ListAnswers = listAnswers;
    }
}
