package org.bshg.librarysystem.services.impl.content;

import org.bshg.librarysystem.entity.core.content.AuthorBook;
import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.entity.core.content.BookGenre;
import org.bshg.librarysystem.repository.content.BookDao;
import org.bshg.librarysystem.services.facade.content.AuthorBookService;
import org.bshg.librarysystem.services.facade.content.BookGenreService;
import org.bshg.librarysystem.services.facade.content.BookService;
import org.bshg.librarysystem.services.facade.content.PublisherService;
import org.bshg.librarysystem.services.facade.library.LoanService;
import org.bshg.librarysystem.services.facade.library.ReservationService;
import org.bshg.librarysystem.services.facade.library.ReviewService;
import org.bshg.librarysystem.services.facade.storage.RackService;
import org.bshg.librarysystem.services.facade.user.admin.EmployeeService;
import org.bshg.librarysystem.utils.service.ServiceHelper;
import org.bshg.librarysystem.utils.service.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookServiceImpl extends ServiceImpl<Book, BookDao> implements BookService {
    public BookServiceImpl(BookDao dao) {
        super(dao);
    }

    @Override
    public List<Book> findAllOptimized() {
        return dao.findAllOptimized();
    }

    @Override
    public void deleteAssociatedList(Book item) {
        if (item == null || item.getId() == null) return;
        authorBookService.deleteByBookId(item.getId());
        bookGenreService.deleteByBookId(item.getId());
    }

    @Override
    public void deleteAssociatedObjects(Book item) {
        if (item == null || item.getId() == null) return;
        loanService.deleteByBookId(item.getId());
        reservationService.deleteByBookId(item.getId());
        reviewService.deleteByBookId(item.getId());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteByEmployeeId(Long id) {
        if (id == null) return 0;
        List<Book> found = findByEmployeeId(id);
        if (found == null) return 0;
        found.forEach(this::deleteAssociated);
        return dao.deleteByEmployeeId(id);
    }

    @Override
    public List<Book> findByEmployeeId(Long id) {
        return dao.findByEmployeeId(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteByPublisherId(Long id) {
        if (id == null) return 0;
        List<Book> found = findByPublisherId(id);
        if (found == null) return 0;
        found.forEach(this::deleteAssociated);
        return dao.deleteByPublisherId(id);
    }

    @Override
    public List<Book> findByPublisherId(Long id) {
        return dao.findByPublisherId(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteByRackId(Long id) {
        if (id == null) return 0;
        List<Book> found = findByRackId(id);
        if (found == null) return 0;
        found.forEach(this::deleteAssociated);
        return dao.deleteByRackId(id);
    }

    @Override
    public List<Book> findByRackId(Long id) {
        return dao.findByRackId(id);
    }

    @Override
    public void createAssociatedList(Book item) {
        if (item == null || item.getId() == null) return;
        ServiceHelper.createList(item, Book::getAuthorBook, AuthorBook::setBook, authorBookService);
        ServiceHelper.createList(item, Book::getBookGenre, BookGenre::setBook, bookGenreService);
    }

    @Override
    public void updateAssociatedList(Book item) {
        if (item == null || item.getId() == null) return;
        ServiceHelper.updateList(item, authorBookService::findByBookId, Book::getAuthorBook, AuthorBook::setBook, authorBookService);
        ServiceHelper.updateList(item, bookGenreService::findByBookId, Book::getBookGenre, BookGenre::setBook, bookGenreService);
    }

    @Lazy
    @Autowired
    private AuthorBookService authorBookService;
    @Lazy
    @Autowired
    private BookGenreService bookGenreService;
    @Lazy
    @Autowired
    private EmployeeService employeeService;
    @Lazy
    @Autowired
    private PublisherService publisherService;
    @Lazy
    @Autowired
    private RackService rackService;
    @Lazy
    @Autowired
    private LoanService loanService;
    @Lazy
    @Autowired
    private ReservationService reservationService;
    @Lazy
    @Autowired
    private ReviewService reviewService;
}