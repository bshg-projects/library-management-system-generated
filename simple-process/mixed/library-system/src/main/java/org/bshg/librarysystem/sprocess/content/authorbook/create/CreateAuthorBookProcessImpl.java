package org.bshg.librarysystem.sprocess.content.authorbook.create;

import org.bshg.librarysystem.entity.core.content.AuthorBook;
import org.bshg.librarysystem.services.content.authorbook.AuthorBookService;
import org.bshg.librarysystem.sprocess.content.authorbook.create.CreateAuthorBookProcess;
import org.bshg.librarysystem.services.content.book.BookService;
import org.bshg.librarysystem.sprocess.content.book.create.CreateBookProcess;
import org.bshg.librarysystem.services.content.author.AuthorService;
import org.bshg.librarysystem.sprocess.content.author.create.CreateAuthorProcess;
import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.entity.core.content.Author;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

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