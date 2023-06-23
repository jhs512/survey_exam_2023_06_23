package com.ll.demo16;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SurveyCategoryService {
    private final SurveyCategoryItemRepository surveyCategoryItemRepository;

    public List<SurveyCategoryItem> findAll() {
        return surveyCategoryItemRepository.findAll();
    }

    @Transactional
    public SurveyCategoryItem create(String name) {
        SurveyCategoryItem surveyCategoryItem = SurveyCategoryItem
                .builder()
                .name(name)
                .build();

        return surveyCategoryItemRepository.save(surveyCategoryItem);
    }
}
