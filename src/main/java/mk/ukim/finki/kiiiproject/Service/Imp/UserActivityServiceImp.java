package mk.ukim.finki.kiiiproject.Service.Imp;

import mk.ukim.finki.kiiiproject.Model.UserActivity;
import mk.ukim.finki.kiiiproject.Repository.UserActivityRepository;
import mk.ukim.finki.kiiiproject.Service.UserActivityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserActivityServiceImp implements UserActivityService {

    private UserActivityRepository userActivityRepository;

    public UserActivityServiceImp(UserActivityRepository userActivityRepository) {
        this.userActivityRepository = userActivityRepository;
    }

    @Override
    public List<UserActivity> findAll() {
        return userActivityRepository.findAll();
    }

    @Override
    public void createUserActivity(String firstName, String lastName) {
        userActivityRepository.save(new UserActivity(firstName, lastName));
    }
}
