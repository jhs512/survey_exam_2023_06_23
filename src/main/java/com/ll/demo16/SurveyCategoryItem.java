package com.ll.demo16;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SurveyCategoryItem {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "categoryItem", orphanRemoval = true, cascade = CascadeType.ALL)
    @Builder.Default
    private List<SurveyQuestion> questions = new ArrayList<>();

    public void addQuestion(SurveyQuestion surveyQuestion) {
        questions.add(surveyQuestion);
        surveyQuestion.setCategoryItem(this);
    }
}
