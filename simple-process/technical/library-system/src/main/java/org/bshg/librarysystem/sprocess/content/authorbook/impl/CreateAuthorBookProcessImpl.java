package org.bshg.librarysystem.sprocess.content.authorbook.impl;

import org.bshg.librarysystem.entity.core.content.AuthorBook;
import org.bshg.librarysystem.services.facade.content.AuthorBookService;
import org.bshg.librarysystem.services.facade.content.AuthorService;
import org.bshg.librarysystem.services.facade.content.BookService;
import org.bshg.librarysystem.sprocess.content.author.facade.CreateAuthorProcess;
import org.bshg.librarysystem.sprocess.content.authorbook.facade.CreateAuthorBookProcess;
import org.bshg.librarysystem.sprocess.content.book.facade.CreateBookProcess;
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