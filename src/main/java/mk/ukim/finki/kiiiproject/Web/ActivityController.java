package mk.ukim.finki.kiiiproject.Web;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.kiiiproject.Service.ActivityService;
import mk.ukim.finki.kiiiproject.Service.UserActivityService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/admin/activity")
public class ActivityController {

    private ActivityService activityService;
    private UserActivityService userActivityService;

    public ActivityController(ActivityService activityService, UserActivityService userActivityService) {
        this.activityService = activityService;
        this.userActivityService = userActivityService;
    }

    public String getActivities(@RequestParam(defaultValue = "") String from,
                                @RequestParam(defaultValue = "") String to,
                                @RequestParam(defaultValue = "-1") Long user,
                                @RequestParam(defaultValue = "1") Integer pageNum,
                                @RequestParam(defaultValue = "10") Integer results,
                                Model model){
        model.addAttribute("users", userActivityService.findAll());
        model.addAttribute("page", activityService.findWithFilter(from, to, user, pageNum, results));
        return "listActivities";
    }

    @GetMapping("/create")
    public String getCreateActivity(Model model){
        model.addAttribute("users", userActivityService.findAll());
        return "addActivity";
    }

    @PostMapping("/create")
    public String createActivity(@RequestParam  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date,
                                 @RequestParam Integer timeSpent,
                                 @RequestParam String description,
                                 @RequestParam Long user){
        activityService.createActivity(date, timeSpent, description, user);
        return "redirect:/admin/activity";
    }
}
