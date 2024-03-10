package org.bshg.librarysystem.sprocess.library.review.delete;

import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.entity.core.library.Review;
import org.bshg.librarysystem.entity.core.user.Client;
import org.bshg.librarysystem.utils.sprocess.facade.IDeleteProcess;

public interface DeleteReviewProcess extends IDeleteProcess<Review> {
    void deleteByBook(Book book);

    void deleteByClient(Client client);
}