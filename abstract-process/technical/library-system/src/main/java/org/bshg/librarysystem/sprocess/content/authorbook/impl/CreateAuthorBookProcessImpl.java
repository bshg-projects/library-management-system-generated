package org.bshg.librarysystem.sprocess.content.authorbook.impl;

import org.bshg.librarysystem.entity.core.content.AuthorBook;
import org.bshg.librarysystem.services.facade.content.AuthorBookService;
import org.bshg.librarysystem.services.facade.content.AuthorService;
import org.bshg.librarysystem.services.facade.content.BookService;
import org.bshg.librarysystem.sprocess.content.author.facade.CreateAuthorProcess;
import org.bshg.librarysystem.sprocess.content.authorbook.facade.CreateAuthorBookProcess;
import org.bshg.librarysystem.sprocess.content.book.facade.CreateBookProcess;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractCreateProcessImpl;
import org.springframework.transaction.annotation.Transactional;

public class CreateAuthorBookProcessImpl extends AbstractCreateProcessImpl<AuthorBook, AuthorBookService> implements CreateAuthorBookProcess {
    public CreateAuthorBookProcessImpl(AuthorBookService service, BookService bookService, AuthorService authorService) {
        super(service);
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public AuthorBook run(AuthorBook item) {
// Your Insert Logic For 'AuthorBook'
        item = service.create(item);
        return item;
    }

    private BookService bookService;
    private CreateBookProcess createBookProcess;

    public void setCreateBookProcess(CreateBookProcess value) {
        this.createBookProcess = value;
    }

    private AuthorService authorService;
    private CreateAuthorProcess createAuthorProcess;

    public void setCreateAuthorProcess(CreateAuthorProcess value) {
        this.createAuthorProcess = value;
    }
}