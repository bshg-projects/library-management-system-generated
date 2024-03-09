package org.bshg.librarysystem.bookgenre;
import org.bshg.librarysystem.bookgenre.BookGenre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface BookGenreDao extends JpaRepository<BookGenre, Long> {
int deleteByIdIn(List<Long> ids);
int deleteByBookId(Long id);
List<BookGenre> findByBookId(Long id);
int deleteByGenreId(Long id);
List<BookGenre> findByGenreId(Long id);
}