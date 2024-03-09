package org.bshg.librarysystem.repository.content;
import org.bshg.librarysystem.entity.core.content.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface GenreDao extends JpaRepository<Genre, Long> {
int deleteByIdIn(List<Long> ids);
@Query("SELECT NEW Genre(item.id,item.name) FROM Genre item")
List<Genre> findAllOptimized();
}