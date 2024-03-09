package org.bshg.librarysystem.genre;
import org.bshg.librarysystem.genre.Genre;
import org.bshg.librarysystem.bookgenre.BookGenre;
import org.bshg.librarysystem.magazine.Magazine;
import org.bshg.librarysystem.utils.repository.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface GenreDao extends Repository<Genre, Long> {
@Query("SELECT NEW Genre(item.id,item.name) FROM Genre item")
List<Genre> findAllOptimized();
}