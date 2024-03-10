package org.bshg.librarysystem.sprocess.content.author.create;

import org.bshg.librarysystem.entity.core.content.Author;
import org.bshg.librarysystem.entity.core.content.AuthorBook;
import org.bshg.librarysystem.services.content.author.AuthorService;
import org.bshg.librarysystem.services.content.authorbook.AuthorBookService;
import org.bshg.librarysystem.sprocess.content.authorbook.create.CreateAuthorBookProcess;
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