package com.ll.demo16;

import lombok.Getter;
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
    public String step(Model model, @RequestParam Map<String, String> param, @RequestParam(defaultValue = "1") int stepNo) {
        StepParam stepParam = new StepParam(param, stepNo);

        Long categoryItemId = stepParam.getCategoryItemId();

        List<SurveyQuestion> questions = surveyQuestionService.findByCategoryItemId(categoryItemId);

        model.addAttribute("questions", questions);
        model.addAttribute("stepParam", stepParam);

        return "usr/survey/step";
    }
}

@Getter
class StepParam {
    private final Map<String, String> param;
    private final int stepNo;
    private final int[] categoryItemIds;

    public StepParam(Map<String, String> param, int stepNo) {
        this.param = param;
        this.stepNo = stepNo;
        categoryItemIds = param
                .keySet()
                .stream()
                .filter(key -> key.startsWith("category_"))
                .mapToInt(key -> Integer.parseInt(key.replace("category_", "")))
                .sorted()
                .toArray();
    }

    public Long getCategoryItemId() {
        return (long) categoryItemIds[stepNo - 1];
    }
}
