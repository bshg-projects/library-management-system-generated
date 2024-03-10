package org.bshg.librarysystem.sprocess.library.review;

import org.bshg.librarysystem.services.content.book.BookService;
import org.bshg.librarysystem.services.library.review.ReviewService;
import org.bshg.librarysystem.services.user.client.ClientService;
import org.bshg.librarysystem.sprocess.content.book.create.CreateBookProcess;
import org.bshg.librarysystem.sprocess.content.book.delete.DeleteBookProcess;
import org.bshg.librarysystem.sprocess.content.book.update.UpdateBookProcess;
import org.bshg.librarysystem.sprocess.library.review.create.CreateReviewProcess;
import org.bshg.librarysystem.sprocess.library.review.create.CreateReviewProcessImpl;
import org.bshg.librarysystem.sprocess.library.review.delete.DeleteReviewProcess;
import org.bshg.librarysystem.sprocess.library.review.delete.DeleteReviewProcessImpl;
import org.bshg.librarysystem.sprocess.library.review.update.UpdateReviewProcess;
import org.bshg.librarysystem.sprocess.library.review.update.UpdateReviewProcessImpl;
import org.bshg.librarysystem.sprocess.user.client.create.CreateClientProcess;
import org.bshg.librarysystem.sprocess.user.client.delete.DeleteClientProcess;
import org.bshg.librarysystem.sprocess.user.client.update.UpdateClientProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * Inject Review Processes (Create, Update, Delete).
 */
@Configuration
public class ReviewInjector {
    @Bean
    public CreateReviewProcess createReviewProcess(ReviewService service, BookService bookService, ClientService clientService) {
        var bean = new CreateReviewProcessImpl(service, bookService, clientService);
        bean.setCreateBookProcess(this.createBookProcess);
        bean.setCreateClientProcess(this.createClientProcess);
        return bean;
    }

    @Bean
    public UpdateReviewProcess updateReviewProcess(ReviewService service, BookService bookService, ClientService clientService) {
        var bean = new UpdateReviewProcessImpl(service, bookService, clientService);
        bean.setUpdateBookProcess(this.updateBookProcess);
        bean.setDeleteBookProcess(this.deleteBookProcess);
        bean.setUpdateClientProcess(this.updateClientProcess);
        bean.setDeleteClientProcess(this.deleteClientProcess);
        return bean;
    }

    @Bean
    public DeleteReviewProcess deleteReviewProcess(ReviewService service, BookService bookService, ClientService clientService) {
        var bean = new DeleteReviewProcessImpl(service, bookService, clientService);
        bean.setDeleteBookProcess(this.deleteBookProcess);
        bean.setDeleteClientProcess(this.deleteClientProcess);
        return bean;
    }

    @Autowired
    @Lazy
    private CreateBookProcess createBookProcess;
    @Autowired
    @Lazy
    private UpdateBookProcess updateBookProcess;
    @Autowired
    @Lazy
    private CreateClientProcess createClientProcess;
    @Autowired
    @Lazy
    private UpdateClientProcess updateClientProcess;
    @Autowired
    @Lazy
    private DeleteBookProcess deleteBookProcess;
    @Autowired
    @Lazy
    private DeleteClientProcess deleteClientProcess;
}