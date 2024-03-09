package org.bshg.librarysystem.sprocess.content.authorbook.update;
import org.bshg.librarysystem.entity.core.content.AuthorBook;
import org.bshg.librarysystem.services.content.authorbook.AuthorBookService;
import org.bshg.librarysystem.sprocess.content.authorbook.update.UpdateAuthorBookProcess;
import org.bshg.librarysystem.services.content.book.BookService;
import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.sprocess.content.book.update.UpdateBookProcess;
import org.bshg.librarysystem.sprocess.content.book.delete.DeleteBookProcess;
import org.bshg.librarysystem.services.content.author.AuthorService;
import org.bshg.librarysystem.entity.core.content.Author;
import org.bshg.librarysystem.sprocess.content.author.update.UpdateAuthorProcess;
import org.bshg.librarysystem.sprocess.content.author.delete.DeleteAuthorProcess;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractUpdateProcessImpl;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
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