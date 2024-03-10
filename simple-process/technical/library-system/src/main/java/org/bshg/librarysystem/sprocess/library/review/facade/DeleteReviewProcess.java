package org.bshg.librarysystem.sprocess.library.review.facade;

import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.entity.core.library.Review;
import org.bshg.librarysystem.entity.core.user.Client;

import java.util.List;

public interface DeleteReviewProcess {
    void run(Review item);

    void run(Long id);

    void runByIds(List<Long> ids);

    void run(List<Review> items);

    void deleteByBook(Book book);

    void deleteByClient(Client client);
}