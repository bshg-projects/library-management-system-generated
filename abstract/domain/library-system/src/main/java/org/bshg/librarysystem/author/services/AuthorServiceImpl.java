package org.bshg.librarysystem.author.services;

import org.bshg.librarysystem.author.Author;
import org.bshg.librarysystem.author.AuthorDao;
import org.bshg.librarysystem.authorbook.AuthorBook;
import org.bshg.librarysystem.authorbook.services.AuthorBookService;
import org.bshg.librarysystem.utils.service.ServiceHelper;
import org.bshg.librarysystem.utils.service.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl extends ServiceImpl<Author, AuthorDao> implements AuthorService {
    public AuthorServiceImpl(AuthorDao dao) {
        super(dao);
    }

    @Override
    public void deleteAssociatedList(Author item) {
        if (item == null || item.getId() == null) return;
        authorBookService.deleteByAuthorId(item.getId());
    }

    @Override
    public void createAssociatedList(Author item) {
        if (item == null || item.getId() == null) return;
        ServiceHelper.createList(item, Author::getAuthorBook, AuthorBook::setAuthor, authorBookService);
    }

    @Override
    public void updateAssociatedList(Author item) {
        if (item == null || item.getId() == null) return;
        ServiceHelper.updateList(item, authorBookService::findByAuthorId, Author::getAuthorBook, AuthorBook::setAuthor, authorBookService);
    }

    @Lazy
    @Autowired
    private AuthorBookService authorBookService;
}