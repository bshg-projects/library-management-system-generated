package org.bshg.librarysystem.sprocess.content.bookgenre.facade;
import org.bshg.librarysystem.entity.core.content.BookGenre;
import java.util.List;
public interface CreateBookGenreProcess {
BookGenre run(BookGenre item);
List<BookGenre> run(List<BookGenre> items);
}