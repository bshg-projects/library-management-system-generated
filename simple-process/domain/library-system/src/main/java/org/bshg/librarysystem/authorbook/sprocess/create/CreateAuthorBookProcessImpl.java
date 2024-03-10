package org.bshg.librarysystem.authorbook.sprocess.create;

import org.bshg.librarysystem.author.services.AuthorService;
import org.bshg.librarysystem.author.sprocess.create.CreateAuthorProcess;
import org.bshg.librarysystem.authorbook.AuthorBook;
import org.bshg.librarysystem.authorbook.services.AuthorBookService;
import org.bshg.librarysystem.book.services.BookService;
import org.bshg.librarysystem.book.sprocess.create.CreateBookProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class CreateAuthorBookProcessImpl implements CreateAuthorBookProcess {
    @Transactional(rollbackFor = Exception.class)
    public AuthorBook run(AuthorBook item) {
// Your Creation Logic For 'AuthorBook'
        item = service.create(item);
        return item;
    }

    public List<AuthorBook> run(List<AuthorBook> items) {
        items.forEach(this::run);
        return items;
    }

    @Autowired
    private AuthorBookService service;
    @Autowired
    private BookService bookService;
    @Autowired
    @Lazy
    private CreateBookProcess createBookProcess;
    @Autowired
    private AuthorService authorService;
    @Autowired
    @Lazy
    private CreateAuthorProcess createAuthorProcess;
}