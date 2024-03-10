package org.bshg.librarysystem.author.sprocess.create;

import org.bshg.librarysystem.author.Author;
import org.bshg.librarysystem.author.services.AuthorService;
import org.bshg.librarysystem.authorbook.AuthorBook;
import org.bshg.librarysystem.authorbook.services.AuthorBookService;
import org.bshg.librarysystem.authorbook.sprocess.create.CreateAuthorBookProcess;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class CreateAuthorProcessImpl implements CreateAuthorProcess {
    @Transactional(rollbackFor = Exception.class)
    public Author run(Author item) {
// Your Creation Logic For 'Author'
        item = service.create(item);
        createAssociatedList(item);
        return item;
    }

    public List<Author> run(List<Author> items) {
        items.forEach(this::run);
        return items;
    }

    public void createAssociatedList(Author item) {
        if (item == null || item.getId() == null) return;
        ProcessHelper.createList(item, Author::getAuthorBook, AuthorBook::setAuthor, createAuthorBookProcess::run);
    }

    @Autowired
    private AuthorService service;
    @Autowired
    private AuthorBookService authorBookService;
    @Autowired
    @Lazy
    private CreateAuthorBookProcess createAuthorBookProcess;
}