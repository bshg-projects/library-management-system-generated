package org.bshg.librarysystem.review.sprocess;

import org.bshg.librarysystem.book.services.BookService;
import org.bshg.librarysystem.book.sprocess.create.CreateBookProcess;
import org.bshg.librarysystem.book.sprocess.delete.DeleteBookProcess;
import org.bshg.librarysystem.book.sprocess.update.UpdateBookProcess;
import org.bshg.librarysystem.client.services.ClientService;
import org.bshg.librarysystem.client.sprocess.create.CreateClientProcess;
import org.bshg.librarysystem.client.sprocess.delete.DeleteClientProcess;
import org.bshg.librarysystem.client.sprocess.update.UpdateClientProcess;
import org.bshg.librarysystem.review.services.ReviewService;
import org.bshg.librarysystem.review.sprocess.create.CreateReviewProcess;
import org.bshg.librarysystem.review.sprocess.create.CreateReviewProcessImpl;
import org.bshg.librarysystem.review.sprocess.delete.DeleteReviewProcess;
import org.bshg.librarysystem.review.sprocess.delete.DeleteReviewProcessImpl;
import org.bshg.librarysystem.review.sprocess.update.UpdateReviewProcess;
import org.bshg.librarysystem.review.sprocess.update.UpdateReviewProcessImpl;
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