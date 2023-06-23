package com.ll.demo16;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

@Configuration
public class NotProd {
    @Bean
    public ApplicationRunner init(SurveyCategoryService surveyCategoryService, SurveyQuestionService surveyQuestionService) {
        return new ApplicationRunner() {
            @Transactional
            @Override
            public void run(ApplicationArguments args) throws Exception {
                SurveyCategoryItem surveyCategoryItem1 = surveyCategoryService.create("눈");
                SurveyCategoryItem surveyCategoryItem2 = surveyCategoryService.create("면역력 / 항산화");
                SurveyCategoryItem surveyCategoryItem3 = surveyCategoryService.create("뼈, 관절 건강");

                surveyQuestionService.create(surveyCategoryItem1, "눈이 침침하거나 시력이 떨어졌나요?", "루테인, 지아잔틴, 아스타잔틴");
                surveyQuestionService.create(surveyCategoryItem1, "장시간 모니터를 보거나 전자기기를 사용하시나요?", "루테인,지아잔틴, 아스타잔틴");
                surveyQuestionService.create(surveyCategoryItem1, "어두울 때 잘 안보이시나요?", "비타민A, 베타카로틴");
                surveyQuestionService.create(surveyCategoryItem1, "해당사항은 없지만 눈 건강을 관리하고 싶어요", "루테인, 지아잔틴");

                surveyQuestionService.create(surveyCategoryItem2, "알러지 반응이 생기거나, 예전보다 증상이 심해졌나요?", "아연, 비타민 C");
                surveyQuestionService.create(surveyCategoryItem2, "평소와 비슷한 음식을 먹어도 배가 아픈 증상이 자주 나타나나요?", "아연, 비타민 C");
                surveyQuestionService.create(surveyCategoryItem2, "상처가 생기거나 부상을 입은 후, 회복 속도가 느려졌나요?", "아연, 비타민 C");
                surveyQuestionService.create(surveyCategoryItem2, "구내염, 혓바늘 등 호흡기관에 염증이 생기나요?", "프로폴리스");
                surveyQuestionService.create(surveyCategoryItem2, "해당사항은 없지만 면역력을 관리하고 싶어요", "비타민C, 비타민 D");

                surveyQuestionService.create(surveyCategoryItem3, "칼슘과 같이 먹으면 좋음", "마그네슘, 비타민 D, 비타민 K");
                surveyQuestionService.create(surveyCategoryItem3, "뼈가 약하다고 느끼시나요?", "칼슘, 마그네슘");
            }
        };
    }
}
