
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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import java.util.List;
@Component
public class DeleteAuthorBookProcessImpl implements DeleteAuthorBookProcess {
private void process(AuthorBook item) {
// put your logic to apply before deleting the item
// like validation or something like that
}
@Transactional(rollbackFor = Exception.class)
public void run(AuthorBook item) {
process(item);
service.delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void run(Long id) {
AuthorBook item = service.findById(id);
if (item != null) run(item);
}
@Transactional(rollbackFor = Exception.class)
public void runByIds(List<Long> ids) {
ids.forEach(id -> {
AuthorBook item = service.findById(id);
if (item != null) {
process(item);
}
});
service.deleteByIdIn(ids);
}
@Transactional(rollbackFor = Exception.class)
public void run(List<AuthorBook> items) {
items.forEach(this::process);
service.delete(items);
}
@Transactional(rollbackFor = Exception.class)
public void deleteByAuthor(Author author) {
if (author != null && author.getId() != null){
service.deleteByAuthorId(author.getId());
}
}
@Transactional(rollbackFor = Exception.class)
public void deleteByBook(Book book) {
if (book != null && book.getId() != null){
service.deleteByBookId(book.getId());
}
}
@Autowired private AuthorBookService service;
@Autowired @Lazy private BookService bookService;
@Autowired @Lazy private AuthorService authorService;
@Autowired @Lazy private DeleteAuthorProcess deleteAuthorProcess;
@Autowired @Lazy private DeleteBookProcess deleteBookProcess;
}