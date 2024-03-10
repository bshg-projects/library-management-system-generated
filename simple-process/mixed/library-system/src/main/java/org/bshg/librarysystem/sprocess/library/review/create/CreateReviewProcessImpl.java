package org.bshg.librarysystem.sprocess.library.review.create;

import org.bshg.librarysystem.entity.core.library.Review;
import org.bshg.librarysystem.services.content.book.BookService;
import org.bshg.librarysystem.services.library.review.ReviewService;
import org.bshg.librarysystem.services.user.client.ClientService;
import org.bshg.librarysystem.sprocess.content.book.create.CreateBookProcess;
import org.bshg.librarysystem.sprocess.user.client.create.CreateClientProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class CreateReviewProcessImpl implements CreateReviewProcess {
    @Transactional(rollbackFor = Exception.class)
    public Review run(Review item) {
// Your Creation Logic For 'Review'
        item = service.create(item);
        return item;
    }

    public List<Review> run(List<Review> items) {
        items.forEach(this::run);
        return items;
    }

    @Autowired
    private ReviewService service;
    @Autowired
    private BookService bookService;
    @Autowired
    @Lazy
    private CreateBookProcess createBookProcess;
    @Autowired
    private ClientService clientService;
    @Autowired
    @Lazy
    private CreateClientProcess createClientProcess;
}