package mk.ukim.finki.kiiiproject.Model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "person_activities")
public class UserActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    public UserActivity(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
