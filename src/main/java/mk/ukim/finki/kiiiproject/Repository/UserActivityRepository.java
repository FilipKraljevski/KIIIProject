package mk.ukim.finki.kiiiproject.Repository;

import mk.ukim.finki.kiiiproject.Model.UserActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserActivityRepository extends JpaRepository<UserActivity, Long> {
}
