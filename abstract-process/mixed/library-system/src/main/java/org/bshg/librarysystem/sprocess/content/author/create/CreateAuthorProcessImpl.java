package org.bshg.librarysystem.sprocess.content.author.create;

import org.bshg.librarysystem.entity.core.content.Author;
import org.bshg.librarysystem.entity.core.content.AuthorBook;
import org.bshg.librarysystem.services.content.author.AuthorService;
import org.bshg.librarysystem.services.content.authorbook.AuthorBookService;
import org.bshg.librarysystem.sprocess.content.authorbook.create.CreateAuthorBookProcess;
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