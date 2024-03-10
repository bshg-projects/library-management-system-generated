package org.bshg.librarysystem.services.facade.library;

import org.bshg.librarysystem.entity.core.library.Review;
import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.entity.core.user.Client;

import java.util.List;

public interface ReviewService {
    Review findById(Long id);

    List<Review> findAllOptimized();

    List<Review> findAll();

    Review create(Review item);

    Review edit(Review item);

    void deleteById(Long id);

    void delete(Review item);

    void delete(List<Review> items);

    void deleteByIdIn(List<Long> ids);

    int deleteByBookId(Long id);

    Review findByBookId(Long id);

    int deleteByClientId(Long id);

    List<Review> findByClientId(Long id);
}