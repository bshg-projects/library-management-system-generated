package org.bshg.librarysystem.review;
import org.bshg.librarysystem.review.Review;
import org.bshg.librarysystem.book.Book;
import org.bshg.librarysystem.client.Client;
import org.bshg.librarysystem.utils.repository.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface ReviewDao extends Repository<Review, Long> {
int deleteByBookId(Long id);
Review findByBookId(Long id);
int deleteByClientId(Long id);
List<Review> findByClientId(Long id);
@Query("SELECT NEW Review(item.id,item.name) FROM Review item")
List<Review> findAllOptimized();
}