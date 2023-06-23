package com.ll.demo16;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SurveyCategoryService {
    private final SurveyCategoryItemRepository surveyCategoryItemRepository;

    public List<SurveyCategoryItem> findAll() {
        return surveyCategoryItemRepository.findAll();
    }

    public void create(String name) {
        SurveyCategoryItem surveyCategoryItem = SurveyCategoryItem
                .builder()
                .name(name)
                .build();

        surveyCategoryItemRepository.save(surveyCategoryItem);
    }
}
