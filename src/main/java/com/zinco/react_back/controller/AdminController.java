package com.zinco.react_back.controller;

import com.zinco.react_back.entity.Recommend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private RecommendationService recommendationService;

    @PostMapping("/recommend")
    public String recommendMusic(@ModelAttribute Recommend recommend) {
        recommendationService.recommendMusic(recommend);
        return "redirect:/admin/recommendations";
    }

    @GetMapping("/recommendations")
    public String viewRecommendations(Model model) {
        List<Recommend> recommendations = recommendationService.getAllRecommendations();
        model.addAttribute("recommendations", recommendations);
        return "recommendationsView";
    }
}