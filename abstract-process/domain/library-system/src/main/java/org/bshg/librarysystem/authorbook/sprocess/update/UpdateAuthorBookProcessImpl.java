package org.bshg.librarysystem.authorbook.sprocess.update;
import org.bshg.librarysystem.authorbook.AuthorBook;
import org.bshg.librarysystem.authorbook.services.AuthorBookService;
import org.bshg.librarysystem.authorbook.sprocess.update.UpdateAuthorBookProcess;
import org.bshg.librarysystem.book.services.BookService;
import org.bshg.librarysystem.book.Book;
import org.bshg.librarysystem.book.sprocess.update.UpdateBookProcess;
import org.bshg.librarysystem.book.sprocess.delete.DeleteBookProcess;
import org.bshg.librarysystem.author.services.AuthorService;
import org.bshg.librarysystem.author.Author;
import org.bshg.librarysystem.author.sprocess.update.UpdateAuthorProcess;
import org.bshg.librarysystem.author.sprocess.delete.DeleteAuthorProcess;
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