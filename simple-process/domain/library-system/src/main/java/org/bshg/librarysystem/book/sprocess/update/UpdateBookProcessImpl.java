package org.bshg.librarysystem.book.sprocess.update;
import org.bshg.librarysystem.book.Book;
import org.bshg.librarysystem.book.services.BookService;
import org.bshg.librarysystem.book.sprocess.update.UpdateBookProcess;
import org.bshg.librarysystem.authorbook.services.AuthorBookService;
import org.bshg.librarysystem.authorbook.AuthorBook;
import org.bshg.librarysystem.authorbook.sprocess.update.UpdateAuthorBookProcess;
import org.bshg.librarysystem.authorbook.sprocess.delete.DeleteAuthorBookProcess;
import org.bshg.librarysystem.bookgenre.services.BookGenreService;
import org.bshg.librarysystem.bookgenre.BookGenre;
import org.bshg.librarysystem.bookgenre.sprocess.update.UpdateBookGenreProcess;
import org.bshg.librarysystem.bookgenre.sprocess.delete.DeleteBookGenreProcess;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import java.util.List;
@Component
public class UpdateBookProcessImpl implements UpdateBookProcess {
@Transactional(rollbackFor = Exception.class)
public Book run(Book item) { // Your Logic To Update 'Book'
item = service.edit(item);
updateAssociatedList(item);
return item;
}
public List<Book> run(List<Book> items) {
items.forEach(this::run);
return items;
}
public void updateAssociatedList(Book item) {
if (item == null || item.getId() == null) return;
ProcessHelper.updateList(
item,
authorBookService.findByBookId(item.getId()),
item.getAuthorBook(),
AuthorBook::setBook,
updateAuthorBookProcess::run,
deleteAuthorBookProcess::run
);
ProcessHelper.updateList(
item,
bookGenreService.findByBookId(item.getId()),
item.getBookGenre(),
BookGenre::setBook,
updateBookGenreProcess::run,
deleteBookGenreProcess::run
);
}
@Autowired private BookService service;
@Autowired AuthorBookService authorBookService;
@Autowired @Lazy private UpdateAuthorBookProcess updateAuthorBookProcess;
@Autowired @Lazy private DeleteAuthorBookProcess deleteAuthorBookProcess;
@Autowired BookGenreService bookGenreService;
@Autowired @Lazy private UpdateBookGenreProcess updateBookGenreProcess;
@Autowired @Lazy private DeleteBookGenreProcess deleteBookGenreProcess;
}