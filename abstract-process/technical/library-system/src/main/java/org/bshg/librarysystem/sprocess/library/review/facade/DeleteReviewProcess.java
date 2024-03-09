package org.bshg.librarysystem.sprocess.library.review.facade;
import org.bshg.librarysystem.entity.core.library.Review;
import org.bshg.librarysystem.utils.sprocess.facade.IDeleteProcess;
import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.entity.core.user.Client;
public interface DeleteReviewProcess extends IDeleteProcess<Review> {
void deleteByBook(Book book);
void deleteByClient(Client client);
}