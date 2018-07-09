package codesquad.web;

import codesquad.domain.Question;
import codesquad.domain.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/questions")
public class QuestionController {
    @Autowired
    private QuestionRepository questionRepository;

    @PostMapping("")
    public String create(Question question) {
        question.setTime();
        questionRepository.save(question);
        return "redirect:/";
    }

    @GetMapping("/{index}")
    public String show(@PathVariable Long index, Model model) {
        model.addAttribute("question", questionRepository.findById(index).get());
        return "/qna/show";
    }

    @GetMapping("/{id}/form")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("question", questionRepository.findById(id).get());
        return "/qna/updateForm";
    }

    @PutMapping("/{id}/update")
    public String update(@PathVariable Long id, Question modifiedQuestion) {
        Question question = questionRepository.findById(id).get();
        question.update(modifiedQuestion);
        questionRepository.save(question);

        return "redirect:/questions/" + id;
    }

    @DeleteMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        Question question = questionRepository.findById(id).get();
        questionRepository.delete(question);

        return "redirect:/";
    }
}
