
package org.bshg.librarysystem.author.sprocess.delete;
import org.bshg.librarysystem.author.Author;
import org.bshg.librarysystem.author.services.AuthorService;
import org.bshg.librarysystem.author.sprocess.delete.DeleteAuthorProcess;
import org.bshg.librarysystem.authorbook.AuthorBook;
import org.bshg.librarysystem.authorbook.services.AuthorBookService;
import org.bshg.librarysystem.authorbook.sprocess.delete.DeleteAuthorBookProcess;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractDeleteProcessImpl;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
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