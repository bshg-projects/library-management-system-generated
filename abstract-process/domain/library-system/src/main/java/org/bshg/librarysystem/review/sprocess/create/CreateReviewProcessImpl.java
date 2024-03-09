package org.bshg.librarysystem.review.sprocess.create;
import org.bshg.librarysystem.review.Review;
import org.bshg.librarysystem.review.services.ReviewService;
import org.bshg.librarysystem.review.sprocess.create.CreateReviewProcess;
import org.bshg.librarysystem.book.services.BookService;
import org.bshg.librarysystem.book.sprocess.create.CreateBookProcess;
import org.bshg.librarysystem.client.services.ClientService;
import org.bshg.librarysystem.client.sprocess.create.CreateClientProcess;
import org.bshg.librarysystem.book.Book;
import org.bshg.librarysystem.client.Client;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractCreateProcessImpl;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
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