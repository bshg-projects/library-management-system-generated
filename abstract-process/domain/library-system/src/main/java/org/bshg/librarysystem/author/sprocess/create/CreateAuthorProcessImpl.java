package org.bshg.librarysystem.author.sprocess.create;

import org.bshg.librarysystem.author.Author;
import org.bshg.librarysystem.author.services.AuthorService;
import org.bshg.librarysystem.authorbook.AuthorBook;
import org.bshg.librarysystem.authorbook.services.AuthorBookService;
import org.bshg.librarysystem.authorbook.sprocess.create.CreateAuthorBookProcess;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractCreateProcessImpl;
import org.springframework.transaction.annotation.Transactional;

public class CreateAuthorProcessImpl extends AbstractCreateProcessImpl<Author, AuthorService> implements CreateAuthorProcess {
    public CreateAuthorProcessImpl(AuthorService service, AuthorBookService authorBookService) {
        super(service);
        this.authorBookService = authorBookService;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Author run(Author item) {
// Your Insert Logic For 'Author'
        item = service.create(item);
        createAssociatedList(item);
        return item;
    }

    @Override
    public void createAssociatedList(Author item) {
        if (item == null || item.getId() == null) return;
        ProcessHelper.createList(item, Author::getAuthorBook, AuthorBook::setAuthor, createAuthorBookProcess);
    }

    private AuthorBookService authorBookService;
    private CreateAuthorBookProcess createAuthorBookProcess;

    public void setCreateAuthorBookProcess(CreateAuthorBookProcess value) {
        this.createAuthorBookProcess = value;
    }
}