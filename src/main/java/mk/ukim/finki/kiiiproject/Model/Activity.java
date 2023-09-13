package mk.ukim.finki.kiiiproject.Model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "activities")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dateTime;

    private Integer timeSpent;

    private String description;

    @ManyToOne
    private UserActivity userActivity;

    public Activity(LocalDate dateTime, Integer timeSpent, String description, UserActivity userActivity) {
        this.dateTime = dateTime;
        this.timeSpent = timeSpent;
        this.description = description;
        this.userActivity = userActivity;
    }
}
