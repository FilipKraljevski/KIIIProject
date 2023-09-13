package mk.ukim.finki.kiiiproject.Web;

import mk.ukim.finki.kiiiproject.Service.UserActivityService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin/userActivity")
public class UserActivityController {

    private UserActivityService userActivityService;

    public UserActivityController(UserActivityService userActivityService) {
        this.userActivityService = userActivityService;
    }

    @GetMapping("/create")
    public String getCreateUserActivity(){
        return "addUser";
    }

    @PostMapping("/create")
    public String createUserActivity(@RequestParam String firstName,
                                     @RequestParam String lastName){
        userActivityService.createUserActivity(firstName, lastName);
        return "addUser";
    }
}
