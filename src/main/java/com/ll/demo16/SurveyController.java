package com.ll.demo16;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/usr/survey")
@RequiredArgsConstructor
public class SurveyController {
    private final SurveyCategoryService surveyCategoryService;
    private final SurveyQuestionService surveyQuestionService;

    @GetMapping("/start")
    public String start(Model model) {
        List<SurveyCategoryItem> categoryItems = surveyCategoryService.findAll();
        model.addAttribute("categoryItems", categoryItems);

        return "usr/survey/start";
    }

    @GetMapping("/step")
    public String step(Model model, @RequestParam Map<String, String> param, int stepNo) {


        return "usr/survey/step";
    }
}
