package org.bshg.librarysystem.sprocess.library.review.impl;

import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.entity.core.library.Review;
import org.bshg.librarysystem.entity.core.user.Client;
import org.bshg.librarysystem.services.facade.content.BookService;
import org.bshg.librarysystem.services.facade.library.ReviewService;
import org.bshg.librarysystem.services.facade.user.ClientService;
import org.bshg.librarysystem.sprocess.content.book.facade.DeleteBookProcess;
import org.bshg.librarysystem.sprocess.library.review.facade.DeleteReviewProcess;
import org.bshg.librarysystem.sprocess.user.client.facade.DeleteClientProcess;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractDeleteProcessImpl;
import org.springframework.transaction.annotation.Transactional;

public class DeleteReviewProcessImpl extends AbstractDeleteProcessImpl<Review, ReviewService> implements DeleteReviewProcess {
    public DeleteReviewProcessImpl(ReviewService service, BookService bookService, ClientService clientService) {
        super(service);
        this.bookService = bookService;
        this.clientService = clientService;
    }

    @Override
    protected void process(Review item) {
// put your logic to apply before deleting the item
// like validation or something like that
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteByBook(Book book) {
        if (book != null && book.getId() != null) {
            service.deleteByBookId(book.getId());
        }
    }

    public void deleteByClient(Client client) {
        if (client != null && client.getId() != null) {
            service.deleteByClientId(client.getId());
        }
    }

    private BookService bookService;
    private ClientService clientService;
    private DeleteBookProcess deleteBookProcess;

    public void setDeleteBookProcess(DeleteBookProcess value) {
        this.deleteBookProcess = value;
    }

    private DeleteClientProcess deleteClientProcess;

    public void setDeleteClientProcess(DeleteClientProcess value) {
        this.deleteClientProcess = value;
    }
}