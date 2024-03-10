package org.bshg.librarysystem.sprocess.library.review.impl;

import org.bshg.librarysystem.entity.core.library.Review;
import org.bshg.librarysystem.services.facade.content.BookService;
import org.bshg.librarysystem.services.facade.library.ReviewService;
import org.bshg.librarysystem.services.facade.user.ClientService;
import org.bshg.librarysystem.sprocess.content.book.facade.CreateBookProcess;
import org.bshg.librarysystem.sprocess.library.review.facade.CreateReviewProcess;
import org.bshg.librarysystem.sprocess.user.client.facade.CreateClientProcess;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractCreateProcessImpl;
import org.springframework.transaction.annotation.Transactional;

public class CreateReviewProcessImpl extends AbstractCreateProcessImpl<Review, ReviewService> implements CreateReviewProcess {
    public CreateReviewProcessImpl(ReviewService service, BookService bookService, ClientService clientService) {
        super(service);
        this.bookService = bookService;
        this.clientService = clientService;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Review run(Review item) {
// Your Insert Logic For 'Review'
        item = service.create(item);
        return item;
    }

    private BookService bookService;
    private CreateBookProcess createBookProcess;

    public void setCreateBookProcess(CreateBookProcess value) {
        this.createBookProcess = value;
    }

    private ClientService clientService;
    private CreateClientProcess createClientProcess;

    public void setCreateClientProcess(CreateClientProcess value) {
        this.createClientProcess = value;
    }
}