package org.bshg.librarysystem.review.services;
import org.bshg.librarysystem.review.Review;
import org.bshg.librarysystem.book.Book;
import org.bshg.librarysystem.client.Client;
import java.util.List;
public interface ReviewService {
Review findById(Long id);
List<Review> findAllOptimized();
List<Review> findAll();
Review create(Review item);
List<Review> create(List<Review> item);
Review update(Review item);
List<Review> update(List<Review> item);
void deleteById(Long id);
void delete(Review item);
void delete(List<Review> items);
void deleteByIdIn(List<Long> ids);
int deleteByBookId(Long id);
Review findByBookId(Long id);
int deleteByClientId(Long id);
List<Review> findByClientId(Long id);
}