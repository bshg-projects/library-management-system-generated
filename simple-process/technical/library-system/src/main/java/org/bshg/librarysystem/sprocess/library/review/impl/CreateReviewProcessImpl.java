package org.bshg.librarysystem.sprocess.library.review.impl;
import org.bshg.librarysystem.entity.core.library.Review;
import org.bshg.librarysystem.services.facade.library.ReviewService;
import org.bshg.librarysystem.sprocess.library.review.facade.CreateReviewProcess;
import org.bshg.librarysystem.services.facade.content.BookService;
import org.bshg.librarysystem.sprocess.content.book.facade.CreateBookProcess;
import org.bshg.librarysystem.services.facade.user.ClientService;
import org.bshg.librarysystem.sprocess.user.client.facade.CreateClientProcess;
import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.entity.core.user.Client;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
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
@Autowired private ReviewService service;
@Autowired private BookService bookService;
@Autowired @Lazy private CreateBookProcess createBookProcess;
@Autowired private ClientService clientService;
@Autowired @Lazy private CreateClientProcess createClientProcess;
}