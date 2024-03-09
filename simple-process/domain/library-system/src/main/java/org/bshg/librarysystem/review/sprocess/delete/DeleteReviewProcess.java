package org.bshg.librarysystem.review.sprocess.delete;
import org.bshg.librarysystem.review.Review;
import org.bshg.librarysystem.book.Book;
import org.bshg.librarysystem.client.Client;
import java.util.List;
public interface DeleteReviewProcess {
void run(Review item);
void run(Long id);
void runByIds(List<Long> ids);
void run(List<Review> items);
void deleteByBook(Book book);
void deleteByClient(Client client);
}