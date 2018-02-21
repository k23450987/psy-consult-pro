package com.tom.controller;

import com.tom.model.Article;
import com.tom.model.Question;
import com.tom.model.Quiz;
import com.tom.service.ArticleService;
import com.tom.service.QuestionService;
import com.tom.service.QuizService;
import com.tom.service.UserService;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CommonsLog
public class IndexController {

    @Autowired
    private UserService userService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private QuestionService questionService;
    @Autowired
    private QuizService quizService;

    @RequestMapping("/")
    public String index(Model model, Principal principal) {
        if (principal != null) {
            model.addAttribute("username", userService.findByUsername(principal.getName()).getName());
        }
        List<Article> articles = articleService.findArticles();
        if (articles.size() > 0) {
            model.addAttribute("articles", articles);
        }
        return "pages/frontend/index";
    }

    @GetMapping("/login")
    public String login(HttpSession session, Model model, Principal principal) {
        // 未登录
        if (principal != null) {
            return "redirect:/";
        // 已登录
        } else {
            // 提取登录错误信息，并从 session 中删除（为了只显示一次错误信息）
            Object lastException = session.getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
            if (lastException != null) {
                model.addAttribute("error", "error");
                session.removeAttribute("SPRING_SECURITY_LAST_EXCEPTION");
            }
            return "pages/login";
        }
    }

    /**
     * 文章页面
     * @param id 文章 ID
     */
    @GetMapping("/read/article/{id}")
    public String readArticle(@PathVariable String id, Model model, Principal principal){
        if (principal != null) {
            model.addAttribute("username", userService.findByUsername(principal.getName()).getName());
        }
        model.addAttribute("id", id);
        // 点击数增加
        Article article = articleService.get(Integer.valueOf(id));
        Integer clickTime = article.getClickTime();
        article.setClickTime(++clickTime);
        articleService.update(article);
        return "pages/frontend/article";
    }

    /**
     * 我的问题
     */
    @GetMapping("/read/question")
    public String readQuestion(Model model, Principal principal){
        if (principal != null) {
            model.addAttribute("username", userService.findByUsername(principal.getName()).getName());
        }
        Question vo = new Question();
        vo.setUserId(userService.findByUsername(principal.getName()).getId());
        List<Question> questions = questionService.findQuestionsWithParam(vo);
        if (questions.size() > 0) {
            model.addAttribute("questions", questions);
        }
        return "pages/frontend/question";
    }

    /**
     * 提出问题
     */
    @ResponseBody
    @PostMapping("/askQuestion")
    public Map<String, Object> askQuestion(Question question, Principal principal) {
        Map<String, Object> map = new HashMap<>();
        try {
            question.setUserId(userService.findByUsername(principal.getName()).getId());
            questionService.insert(question);
            map.put("success", true);
            map.put("id", question.getId());
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
        }
        return map;
    }

    /**
     * 心理测试
     */
    @GetMapping("/psytest")
    public String psytest(Model model, Principal principal){
        if (principal != null) {
            model.addAttribute("username", userService.findByUsername(principal.getName()).getName());
        }
        Quiz quiz = new Quiz();
        quiz.setFlag(true);
        List<Quiz> quizs = quizService.findQuizs(quiz);
        if (quizs.size() > 0) {
            // 级联查询问题加选项
            Quiz completeQuiz = quizService.getQuiz(quizs.get(0).getId());
            model.addAttribute("quiz", completeQuiz);
        }
        return "pages/frontend/psytest";
    }

    @GetMapping("/psytest/{id}")
    public String psytest(@PathVariable String id, Model model, Principal principal){
        if (principal != null) {
            model.addAttribute("username", userService.findByUsername(principal.getName()).getName());
        }
        Quiz completeQuiz = quizService.getQuiz(Integer.valueOf(id));
        model.addAttribute("quiz", completeQuiz);
        return "pages/frontend/psytest";
    }

}
