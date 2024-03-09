package org.bshg.librarysystem.author;
import org.bshg.librarysystem.author.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface AuthorDao extends JpaRepository<Author, Long> {
int deleteByIdIn(List<Long> ids);
}