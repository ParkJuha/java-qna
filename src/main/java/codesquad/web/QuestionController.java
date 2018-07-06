package codesquad.web;

import codesquad.domain.Question;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class QuestionController {
    List<Question> questionList = new ArrayList<>();

    @GetMapping("/questions/{index}")
    public String show(@PathVariable int index, Model model) {
        model.addAttribute("question", questionList.get(index));
        return "/question/show";
    }

    @PostMapping("/questions")
    public String create(Question question) {
        long currentTime = System.currentTimeMillis();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        question.setTime(format.format(new Date(currentTime)));
        questionList.add(question);
        return "redirect:/";
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("questionList", questionList);
        return "/question/index";
    }


//    @PostMapping("/users")  // form에서 action
//    public String create(User user) {
//        users.add(user);
//        return "redirect:/users";
//    }
//
//    @GetMapping("/users")  // form에서 action
//    public String list(Model model) {
//        model.addAttribute("users", users);
//        return "/user/list";
//    }
}
