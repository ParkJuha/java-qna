package codesquad.web;

import codesquad.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    private List<User> users = new ArrayList<>();

    @GetMapping("/users/{index}")
    public String show(@PathVariable int index, Model model) {
        model.addAttribute("user", users.get(index));
        return "/user/profile";
    }

    @PostMapping("/users")  // form에서 action
    public String create(User user) {
        users.add(user);
        return "redirect:/users";
    }

    @GetMapping("/users")  // form에서 action
    public String list(Model model) {
        model.addAttribute("users", users);
        return "/user/list";
    }

//    @PostMapping("/users")  // form에서 action
//    public String create(String userId,
//                         String password,
//                         String name,
//                         String email, Model model) {
//        users.add(new User(userId, password, name, email));
//        model.addAttribute("users", users);
//        return "/user/list";
//    }
}
