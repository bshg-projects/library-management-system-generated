package org.bshg.librarysystem.sprocess.content.authorbook.impl;

import org.bshg.librarysystem.entity.core.content.AuthorBook;
import org.bshg.librarysystem.services.facade.content.AuthorBookService;
import org.bshg.librarysystem.services.facade.content.AuthorService;
import org.bshg.librarysystem.services.facade.content.BookService;
import org.bshg.librarysystem.sprocess.content.author.facade.DeleteAuthorProcess;
import org.bshg.librarysystem.sprocess.content.author.facade.UpdateAuthorProcess;
import org.bshg.librarysystem.sprocess.content.authorbook.facade.UpdateAuthorBookProcess;
import org.bshg.librarysystem.sprocess.content.book.facade.DeleteBookProcess;
import org.bshg.librarysystem.sprocess.content.book.facade.UpdateBookProcess;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractUpdateProcessImpl;
import org.springframework.transaction.annotation.Transactional;

public class UpdateAuthorBookProcessImpl extends AbstractUpdateProcessImpl<AuthorBook, AuthorBookService> implements UpdateAuthorBookProcess {
    public UpdateAuthorBookProcessImpl(AuthorBookService service, BookService bookService, AuthorService authorService) {
        super(service);
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public AuthorBook run(AuthorBook item) {
// Your Update Logic For 'AuthorBook'
        item = service.edit(item);
        return item;
    }

    private BookService bookService;
    private UpdateBookProcess updateBookProcess;
    private DeleteBookProcess deleteBookProcess;

    public void setUpdateBookProcess(UpdateBookProcess value) {
        this.updateBookProcess = value;
    }

    public void setDeleteBookProcess(DeleteBookProcess value) {
        this.deleteBookProcess = value;
    }

    private AuthorService authorService;
    private UpdateAuthorProcess updateAuthorProcess;
    private DeleteAuthorProcess deleteAuthorProcess;

    public void setUpdateAuthorProcess(UpdateAuthorProcess value) {
        this.updateAuthorProcess = value;
    }

    public void setDeleteAuthorProcess(DeleteAuthorProcess value) {
        this.deleteAuthorProcess = value;
    }
}