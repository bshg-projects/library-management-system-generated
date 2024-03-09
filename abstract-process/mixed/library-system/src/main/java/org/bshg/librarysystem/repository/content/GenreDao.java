package org.bshg.librarysystem.repository.content;
import org.bshg.librarysystem.entity.core.content.Genre;
import org.bshg.librarysystem.entity.core.content.BookGenre;
import org.bshg.librarysystem.entity.core.content.Magazine;
import org.bshg.librarysystem.utils.repository.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface GenreDao extends Repository<Genre, Long> {
@Query("SELECT NEW Genre(item.id,item.name) FROM Genre item")
List<Genre> findAllOptimized();
}