package org.bshg.librarysystem.sprocess.library.review.impl;

import org.bshg.librarysystem.entity.core.library.Review;
import org.bshg.librarysystem.services.facade.library.ReviewService;
import org.bshg.librarysystem.sprocess.library.review.facade.UpdateReviewProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class UpdateReviewProcessImpl implements UpdateReviewProcess {
    @Transactional(rollbackFor = Exception.class)
    public Review run(Review item) { // Your Logic To Update 'Review'
        item = service.edit(item);
        return item;
    }

    public List<Review> run(List<Review> items) {
        items.forEach(this::run);
        return items;
    }

    @Autowired
    private ReviewService service;
}