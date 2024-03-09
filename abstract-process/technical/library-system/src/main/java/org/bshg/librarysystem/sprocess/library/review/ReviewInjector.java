package org.bshg.librarysystem.sprocess.library.review;
import org.bshg.librarysystem.services.facade.library.ReviewService;
import org.bshg.librarysystem.sprocess.library.review.facade.CreateReviewProcess;
import org.bshg.librarysystem.sprocess.library.review.facade.UpdateReviewProcess;
import org.bshg.librarysystem.sprocess.library.review.facade.DeleteReviewProcess;
import org.bshg.librarysystem.sprocess.library.review.impl.CreateReviewProcessImpl;
import org.bshg.librarysystem.sprocess.library.review.impl.UpdateReviewProcessImpl;
import org.bshg.librarysystem.sprocess.library.review.impl.DeleteReviewProcessImpl;
import org.bshg.librarysystem.services.facade.content.BookService;
import org.bshg.librarysystem.sprocess.content.book.facade.CreateBookProcess;
import org.bshg.librarysystem.sprocess.content.book.facade.UpdateBookProcess;
import org.bshg.librarysystem.services.facade.user.ClientService;
import org.bshg.librarysystem.sprocess.user.client.facade.CreateClientProcess;
import org.bshg.librarysystem.sprocess.user.client.facade.UpdateClientProcess;
import org.bshg.librarysystem.sprocess.content.book.facade.DeleteBookProcess;
import org.bshg.librarysystem.sprocess.user.client.facade.DeleteClientProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
* Inject Review Processes (Create, Update, Delete).
*/
@Configuration
public class ReviewInjector {
@Bean
public CreateReviewProcess createReviewProcess (ReviewService service,BookService bookService,ClientService clientService) {
var bean = new CreateReviewProcessImpl(service, bookService, clientService);
bean.setCreateBookProcess(this.createBookProcess);
bean.setCreateClientProcess(this.createClientProcess);
return bean;
}
@Bean
public UpdateReviewProcess updateReviewProcess (ReviewService service,BookService bookService,ClientService clientService) {
var bean = new UpdateReviewProcessImpl(service,bookService,clientService);
bean.setUpdateBookProcess(this.updateBookProcess);
bean.setDeleteBookProcess(this.deleteBookProcess);
bean.setUpdateClientProcess(this.updateClientProcess);
bean.setDeleteClientProcess(this.deleteClientProcess);
return bean;
}
@Bean
public DeleteReviewProcess deleteReviewProcess(ReviewService service,BookService bookService,ClientService clientService) {
var bean = new DeleteReviewProcessImpl(service,bookService,clientService);
bean.setDeleteBookProcess(this.deleteBookProcess);
bean.setDeleteClientProcess(this.deleteClientProcess);
return bean;
}
@Autowired @Lazy private CreateBookProcess createBookProcess;
@Autowired @Lazy private UpdateBookProcess updateBookProcess;
@Autowired @Lazy private CreateClientProcess createClientProcess;
@Autowired @Lazy private UpdateClientProcess updateClientProcess;
@Autowired @Lazy private DeleteBookProcess deleteBookProcess;
@Autowired @Lazy private DeleteClientProcess deleteClientProcess;
}