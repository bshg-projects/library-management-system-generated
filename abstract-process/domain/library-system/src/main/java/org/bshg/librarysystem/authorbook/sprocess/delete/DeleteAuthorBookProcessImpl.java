
package org.bshg.librarysystem.authorbook.sprocess.delete;
import org.bshg.librarysystem.authorbook.AuthorBook;
import org.bshg.librarysystem.authorbook.services.AuthorBookService;
import org.bshg.librarysystem.authorbook.sprocess.delete.DeleteAuthorBookProcess;
import org.bshg.librarysystem.book.Book;
import org.bshg.librarysystem.book.services.BookService;
import org.bshg.librarysystem.author.Author;
import org.bshg.librarysystem.author.services.AuthorService;
import org.bshg.librarysystem.author.sprocess.delete.DeleteAuthorProcess;
import org.bshg.librarysystem.book.sprocess.delete.DeleteBookProcess;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractDeleteProcessImpl;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
public class DeleteAuthorBookProcessImpl extends AbstractDeleteProcessImpl<AuthorBook, AuthorBookService> implements DeleteAuthorBookProcess {
public DeleteAuthorBookProcessImpl(AuthorBookService service, BookService bookService, AuthorService authorService) {
super(service);
this.bookService = bookService;
this.authorService = authorService;
}
@Override
protected void process(AuthorBook item) {
// put your logic to apply before deleting the item
// like validation or something like that
}
public void deleteByAuthor(Author author) {
if (author != null && author.getId() != null){
service.deleteByAuthorId(author.getId());
}
}
public void deleteByBook(Book book) {
if (book != null && book.getId() != null){
service.deleteByBookId(book.getId());
}
}
private BookService bookService;
private AuthorService authorService;
private DeleteAuthorProcess deleteAuthorProcess;
public void setDeleteAuthorProcess(DeleteAuthorProcess value) {
this.deleteAuthorProcess = value;
}
private DeleteBookProcess deleteBookProcess;
public void setDeleteBookProcess(DeleteBookProcess value) {
this.deleteBookProcess = value;
}
}