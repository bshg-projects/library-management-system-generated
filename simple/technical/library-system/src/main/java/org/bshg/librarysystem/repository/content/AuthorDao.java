package org.bshg.librarysystem.repository.content;
import org.bshg.librarysystem.entity.core.content.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface AuthorDao extends JpaRepository<Author, Long> {
int deleteByIdIn(List<Long> ids);
}