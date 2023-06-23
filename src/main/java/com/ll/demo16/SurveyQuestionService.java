package com.ll.demo16;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SurveyQuestionService {
    private final SurveyQuestionRepository surveyQuestionRepository;

    @Transactional
    public SurveyQuestion create(SurveyCategoryItem categoryItem, String content, String recommendSupplements) {
        SurveyQuestion surveyQuestion = SurveyQuestion
                .builder()
                .categoryItem(categoryItem)
                .content(content)
                .recommendSupplements(recommendSupplements)
                .build();

        categoryItem.addQuestion(surveyQuestion);

        return surveyQuestion;
    }

    public List<SurveyQuestion> findByCategoryItemId(Long categoryItemId) {
        return surveyQuestionRepository.findByCategoryItemId(categoryItemId);
    }
}
