package org.bshg.librarysystem.repository.content;
import org.bshg.librarysystem.entity.core.content.BookGenre;
import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.entity.core.content.Genre;
import org.bshg.librarysystem.utils.repository.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface BookGenreDao extends Repository<BookGenre, Long> {
int deleteByBookId(Long id);
List<BookGenre> findByBookId(Long id);
int deleteByGenreId(Long id);
List<BookGenre> findByGenreId(Long id);
}