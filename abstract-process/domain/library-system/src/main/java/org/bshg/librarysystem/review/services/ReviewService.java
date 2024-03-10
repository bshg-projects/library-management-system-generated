package org.bshg.librarysystem.review.services;

import org.bshg.librarysystem.review.Review;
import org.bshg.librarysystem.utils.service.IService;

import java.util.List;

public interface ReviewService extends IService<Review> {
    int deleteByBookId(Long id);

    Review findByBookId(Long id);

    int deleteByClientId(Long id);

    List<Review> findByClientId(Long id);
}