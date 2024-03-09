package org.bshg.librarysystem.services.library.review;
import org.bshg.librarysystem.entity.core.library.Review;
import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.entity.core.user.Client;
import org.bshg.librarysystem.utils.service.IService;
import java.util.List;
public interface ReviewService extends IService<Review> {
int deleteByBookId(Long id);
Review findByBookId(Long id);
int deleteByClientId(Long id);
List<Review> findByClientId(Long id);
}