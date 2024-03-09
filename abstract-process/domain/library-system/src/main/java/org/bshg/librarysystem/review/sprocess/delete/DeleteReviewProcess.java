package org.bshg.librarysystem.review.sprocess.delete;
import org.bshg.librarysystem.review.Review;
import org.bshg.librarysystem.utils.sprocess.facade.IDeleteProcess;
import org.bshg.librarysystem.book.Book;
import org.bshg.librarysystem.client.Client;
public interface DeleteReviewProcess extends IDeleteProcess<Review> {
void deleteByBook(Book book);
void deleteByClient(Client client);
}