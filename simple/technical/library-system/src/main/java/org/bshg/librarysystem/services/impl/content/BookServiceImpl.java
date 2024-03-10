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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    //--------------- FIND -------------------------------------
    public Book findById(Long id) {
        return dao.findById(id).orElse(null);
    }

    public List<Book> findAll() {
        return dao.findAll();
    }

    public List<Book> findAllOptimized() {
        return dao.findAllOptimized();
    }

    //--------------- CREATE -----------------------------------
    @Transactional(rollbackFor = Exception.class)
    public Book create(Book item) {
        if (item == null) return null;
        Book saved = dao.save(item);
        createAssociatedList(saved);
        return saved;
    }

    @Transactional(rollbackFor = Exception.class)
    public List<Book> create(List<Book> items) {
        List<Book> result = new ArrayList<>();
        if (items == null || items.isEmpty()) return result;
        items.forEach(it -> result.add(create(it)));
        return result;
    }

    //--------------- UPDATE -----------------------------------
    @Transactional(rollbackFor = Exception.class)
    public Book update(Book item) {
        if (item == null || item.getId() == null) return null;
        Book saved = dao.save(item);
        updateAssociatedList(saved);
        return saved;
    }

    @Transactional(rollbackFor = Exception.class)
    public List<Book> update(List<Book> items) {
        List<Book> result = new ArrayList<>();
        if (items == null || items.isEmpty()) return result;
        items.forEach(it -> result.add(update(it)));
        return result;
    }

    //--------------- DELETE -----------------------------------
    @Transactional(rollbackFor = Exception.class)
    public void deleteById(Long id) {
        Book item = findById(id);
        if (item != null) delete(item);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(Book item) {
        deleteAssociated(item);
        dao.delete(item);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Book> items) {
        if (items == null || items.isEmpty()) return;
        items.forEach(this::delete);
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteByIdIn(List<Long> ids) {
        ids.forEach(id -> {
            Book item = findById(id);
            if (item != null) {
                deleteAssociated(item);
            }
        });
        dao.deleteByIdIn(ids);
    }

    //--------------- FIND AND DELETE BYs ----------------------
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

    //----------------------------------------------------------
    public void createAssociatedList(Book item) {
        if (item == null || item.getId() == null) return;
        ServiceHelper.createList(item, Book::getAuthorBook, AuthorBook::setBook, authorBookService::create);
        ServiceHelper.createList(item, Book::getBookGenre, BookGenre::setBook, bookGenreService::create);
    }

    public void updateAssociatedList(Book item) {
        if (item == null || item.getId() == null) return;
        ServiceHelper.updateList(
                item, authorBookService.findByBookId(item.getId()),
                item.getAuthorBook(), AuthorBook::setBook,
                authorBookService::update,
                authorBookService::delete
        );
        ServiceHelper.updateList(
                item, bookGenreService.findByBookId(item.getId()),
                item.getBookGenre(), BookGenre::setBook,
                bookGenreService::update,
                bookGenreService::delete
        );
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteAssociated(Book item) {
        deleteAssociatedList(item);
        deleteAssociatedObjects(item);
    }

    public void deleteAssociatedList(Book item) {
        authorBookService.deleteByBookId(item.getId());
        bookGenreService.deleteByBookId(item.getId());
    }

    public void deleteAssociatedObjects(Book item) {
        loanService.deleteByBookId(item.getId());
        reservationService.deleteByBookId(item.getId());
        reviewService.deleteByBookId(item.getId());
    }

    //----------------------------------------------------------
    @Autowired
    private BookDao dao;
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