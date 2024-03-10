package org.bshg.librarysystem.sprocess.library.review.delete;

import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.entity.core.library.Review;
import org.bshg.librarysystem.entity.core.user.Client;
import org.bshg.librarysystem.services.content.book.BookService;
import org.bshg.librarysystem.services.library.review.ReviewService;
import org.bshg.librarysystem.services.user.client.ClientService;
import org.bshg.librarysystem.sprocess.content.book.delete.DeleteBookProcess;
import org.bshg.librarysystem.sprocess.user.client.delete.DeleteClientProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class DeleteReviewProcessImpl implements DeleteReviewProcess {
    private void process(Review item) {
// put your logic to apply before deleting the item
// like validation or something like that
    }

    @Transactional(rollbackFor = Exception.class)
    public void run(Review item) {
        process(item);
        service.delete(item);
    }

    @Transactional(rollbackFor = Exception.class)
    public void run(Long id) {
        Review item = service.findById(id);
        if (item != null) run(item);
    }

    @Transactional(rollbackFor = Exception.class)
    public void runByIds(List<Long> ids) {
        ids.forEach(id -> {
            Review item = service.findById(id);
            if (item != null) {
                process(item);
            }
        });
        service.deleteByIdIn(ids);
    }

    @Transactional(rollbackFor = Exception.class)
    public void run(List<Review> items) {
        items.forEach(this::process);
        service.delete(items);
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteByBook(Book book) {
        if (book != null && book.getId() != null) {
            service.deleteByBookId(book.getId());
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteByClient(Client client) {
        if (client != null && client.getId() != null) {
            service.deleteByClientId(client.getId());
        }
    }

    @Autowired
    private ReviewService service;
    @Autowired
    @Lazy
    private BookService bookService;
    @Autowired
    @Lazy
    private ClientService clientService;
    @Autowired
    @Lazy
    private DeleteBookProcess deleteBookProcess;
    @Autowired
    @Lazy
    private DeleteClientProcess deleteClientProcess;
}