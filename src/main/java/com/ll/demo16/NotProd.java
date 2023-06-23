package com.ll.demo16;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotProd {
    @Bean
    public ApplicationRunner init(SurveyCategoryService surveyCategoryService) {
        return args -> {
            surveyCategoryService.create("눈");
            surveyCategoryService.create("면역력 / 항산화");
            surveyCategoryService.create("뼈, 관절 건강");
        };
    }
}
