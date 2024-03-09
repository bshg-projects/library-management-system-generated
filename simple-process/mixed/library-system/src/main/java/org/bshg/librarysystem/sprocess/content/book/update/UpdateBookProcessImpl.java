package org.bshg.librarysystem.sprocess.content.book.update;
import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.services.content.book.BookService;
import org.bshg.librarysystem.sprocess.content.book.update.UpdateBookProcess;
import org.bshg.librarysystem.services.content.authorbook.AuthorBookService;
import org.bshg.librarysystem.entity.core.content.AuthorBook;
import org.bshg.librarysystem.sprocess.content.authorbook.update.UpdateAuthorBookProcess;
import org.bshg.librarysystem.sprocess.content.authorbook.delete.DeleteAuthorBookProcess;
import org.bshg.librarysystem.services.content.bookgenre.BookGenreService;
import org.bshg.librarysystem.entity.core.content.BookGenre;
import org.bshg.librarysystem.sprocess.content.bookgenre.update.UpdateBookGenreProcess;
import org.bshg.librarysystem.sprocess.content.bookgenre.delete.DeleteBookGenreProcess;
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