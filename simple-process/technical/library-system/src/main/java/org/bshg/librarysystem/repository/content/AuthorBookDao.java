package org.bshg.librarysystem.repository.content;
import org.bshg.librarysystem.entity.core.content.AuthorBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface AuthorBookDao extends JpaRepository<AuthorBook, Long> {
int deleteByIdIn(List<Long> ids);
int deleteByAuthorId(Long id);
List<AuthorBook> findByAuthorId(Long id);
int deleteByBookId(Long id);
List<AuthorBook> findByBookId(Long id);
}