package mk.ukim.finki.kiiiproject.Service;

import mk.ukim.finki.kiiiproject.Model.Activity;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;

public interface ActivityService {

    Page<Activity> findWithFilter(String from , String to, Long userId, Integer page, Integer size);

    void createActivity(LocalDateTime dateTime, Integer timeSpent, String description, Long userId);
}
