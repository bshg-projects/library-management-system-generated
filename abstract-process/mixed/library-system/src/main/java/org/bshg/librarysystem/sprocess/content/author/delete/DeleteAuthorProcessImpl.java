package org.bshg.librarysystem.sprocess.content.author.delete;

import org.bshg.librarysystem.entity.core.content.Author;
import org.bshg.librarysystem.services.content.author.AuthorService;
import org.bshg.librarysystem.services.content.authorbook.AuthorBookService;
import org.bshg.librarysystem.sprocess.content.authorbook.delete.DeleteAuthorBookProcess;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractDeleteProcessImpl;

public class DeleteAuthorProcessImpl extends AbstractDeleteProcessImpl<Author, AuthorService> implements DeleteAuthorProcess {
    public DeleteAuthorProcessImpl(AuthorService service, AuthorBookService authorBookService) {
        super(service);
        this.authorBookService = authorBookService;
    }

    @Override
    protected void process(Author item) {
// put your logic to apply before deleting the item
// like validation or something like that
    }

    @Override
    public void deleteAssociatedList(Author item) {
        deleteAuthorBookProcess.deleteByAuthor(item);
    }

    private AuthorBookService authorBookService;
    private DeleteAuthorBookProcess deleteAuthorBookProcess;

    public void setDeleteAuthorBookProcess(DeleteAuthorBookProcess value) {
        this.deleteAuthorBookProcess = value;
    }
}