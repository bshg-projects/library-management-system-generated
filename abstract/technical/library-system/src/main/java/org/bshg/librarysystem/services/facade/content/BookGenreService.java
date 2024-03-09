package org.bshg.librarysystem.services.facade.content;
import org.bshg.librarysystem.entity.core.content.BookGenre;
import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.entity.core.content.Genre;
import org.bshg.librarysystem.utils.service.IService;
import java.util.List;
public interface BookGenreService extends IService<BookGenre> {
int deleteByBookId(Long id);
List<BookGenre> findByBookId(Long id);
int deleteByGenreId(Long id);
List<BookGenre> findByGenreId(Long id);
}