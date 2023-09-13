package mk.ukim.finki.kiiiproject.Service.Imp;

import mk.ukim.finki.kiiiproject.Model.Activity;
import mk.ukim.finki.kiiiproject.Model.UserActivity;
import mk.ukim.finki.kiiiproject.Repository.ActivityRepository;
import mk.ukim.finki.kiiiproject.Repository.UserActivityRepository;
import mk.ukim.finki.kiiiproject.Service.ActivityService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ActivityServiceImp implements ActivityService {

    private ActivityRepository activityRepository;
    private UserActivityRepository userActivityRepository;

    public ActivityServiceImp(ActivityRepository activityRepository, UserActivityRepository userActivityRepository) {
        this.activityRepository = activityRepository;
        this.userActivityRepository = userActivityRepository;
    }

    public Page<Activity> findAll(PageRequest pageRequest) {
        return activityRepository.findAll(pageRequest);
    }

    @Override
    public Page<Activity> findWithFilter(String from, String to, Long userId, Integer page, Integer size) {
        PageRequest pageRequest = PageRequest.of(page-1, size);
        if(userId != -1){
            if(!from.isEmpty() && !to.isEmpty()){
                return activityRepository.findByDateTimeIsBetweenAndUserActivityId(LocalDateTime.parse(from), LocalDateTime.parse(to),
                        userId, pageRequest);
            } else if(!from.isEmpty()){
                return activityRepository.findByDateTimeAfterAndUserActivityId(LocalDateTime.parse(from), userId, pageRequest);
            } else if(!to.isEmpty()){
                return activityRepository.findByDateTimeBeforeAndUserActivityId(LocalDateTime.parse(to), userId, pageRequest);
            }
            return activityRepository.findByUserActivityId(userId, pageRequest);
        }
        else{
            if(!from.isEmpty() && !to.isEmpty()){
                return activityRepository.findByDateTimeIsBetween(LocalDateTime.parse(from), LocalDateTime.parse(to), pageRequest);
            } else if(!from.isEmpty()){
                return activityRepository.findByDateTimeAfter(LocalDateTime.parse(from), pageRequest);
            } else if(!to.isEmpty()){
                return activityRepository.findByDateTimeBefore(LocalDateTime.parse(to), pageRequest);
            }
            return findAll(pageRequest);
        }
    }

    @Override
    public void createActivity(LocalDateTime dateTime, Integer timeSpent, String description, Long userId) {
        UserActivity userActivity = userActivityRepository.findById(userId).orElseThrow();
        activityRepository.save(new Activity(dateTime, timeSpent, description, userActivity));
    }
}
