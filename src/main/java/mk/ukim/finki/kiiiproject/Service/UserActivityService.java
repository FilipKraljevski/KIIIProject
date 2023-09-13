package mk.ukim.finki.kiiiproject.Service;

import mk.ukim.finki.kiiiproject.Model.UserActivity;

import java.util.List;

public interface UserActivityService {

    List<UserActivity> findAll();

    void createUserActivity(String firstName, String lastName);
}
