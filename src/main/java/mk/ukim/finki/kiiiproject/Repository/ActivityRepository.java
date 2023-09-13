package mk.ukim.finki.kiiiproject.Repository;

import mk.ukim.finki.kiiiproject.Model.Activity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {

    Page<Activity> findByDateTimeIsBetweenAndUserActivityId(LocalDate from, LocalDate to, Long userIdm, Pageable pageable);

    Page<Activity> findByDateTimeAfterAndUserActivityId(LocalDate from, Long userId, Pageable pageable);

    Page<Activity> findByDateTimeBeforeAndUserActivityId(LocalDate to, Long userId, Pageable pageable);

    Page<Activity> findByUserActivityId(Long userId, Pageable pageable);

    Page<Activity> findByDateTimeIsBetween(LocalDate from, LocalDate to, Pageable pageable);

    Page<Activity> findByDateTimeAfter(LocalDate from, Pageable pageable);

    Page<Activity> findByDateTimeBefore(LocalDate to, Pageable pageable);
}
