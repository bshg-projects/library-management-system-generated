
package org.bshg.librarysystem.sprocess.content.authorbook.impl;
import org.bshg.librarysystem.entity.core.content.AuthorBook;
import org.bshg.librarysystem.services.facade.content.AuthorBookService;
import org.bshg.librarysystem.sprocess.content.authorbook.facade.DeleteAuthorBookProcess;
import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.services.facade.content.BookService;
import org.bshg.librarysystem.entity.core.content.Author;
import org.bshg.librarysystem.services.facade.content.AuthorService;
import org.bshg.librarysystem.sprocess.content.author.facade.DeleteAuthorProcess;
import org.bshg.librarysystem.sprocess.content.book.facade.DeleteBookProcess;
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