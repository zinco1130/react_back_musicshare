package com.zinco.react_back.controller;

import com.zinco.react_back.entity.Comment;
import com.zinco.react_back.entity.Tab;
import com.zinco.react_back.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private TabService tabService;

    @GetMapping("/register")
    public String showRegistrationForm() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user) {
        userService.registerUser(user);
        return "redirect:/user/login";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String userId, @RequestParam String password, Model model) {
        User user = userService.loginUser(userId, password);
        if (user != null) {
            model.addAttribute("user", user);
            return "userHome";
        } else {
            model.addAttribute("error", "Invalid credentials");
            return "login";
        }
    }

    @PostMapping("/comment")
    public String addComment(@ModelAttribute Comment comment) {
        commentService.addComment(comment);
        return "redirect:/tab/" + comment.getTab().getTabId();
    }

    @GetMapping("/tab/{tabId}")
    public String showTab(@PathVariable int tabId, Model model) {
        Tab tab = tabService.getTab(tabId);
        model.addAttribute("tab", tab);
        return "tabView";
    }

    @GetMapping("/tab/{tabId}/comments")
    public String showComments(@PathVariable int tabId, Model model) {
        List<Comment> comments = commentService.getCommentsByTabId(tabId);
        model.addAttribute("comments", comments);
        return "commentsView";
    }
}
