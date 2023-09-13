package mk.ukim.finki.kiiiproject.Repository;

import mk.ukim.finki.kiiiproject.Model.Activity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {

    Page<Activity> findByDateTimeIsBetweenAndUserActivityId(LocalDateTime from, LocalDateTime to, Long userIdm, Pageable pageable);

    Page<Activity> findByDateTimeAfterAndUserActivityId(LocalDateTime from, Long userId, Pageable pageable);

    Page<Activity> findByDateTimeBeforeAndUserActivityId(LocalDateTime to, Long userId, Pageable pageable);

    Page<Activity> findByUserActivityId(Long userId, Pageable pageable);

    Page<Activity> findByDateTimeIsBetween(LocalDateTime from, LocalDateTime to, Pageable pageable);

    Page<Activity> findByDateTimeAfter(LocalDateTime from, Pageable pageable);

    Page<Activity> findByDateTimeBefore(LocalDateTime to, Pageable pageable);
}
