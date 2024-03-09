package org.bshg.librarysystem.services.facade.content;
import org.bshg.librarysystem.entity.core.content.Author;
import org.bshg.librarysystem.entity.core.content.AuthorBook;
import java.util.List;
public interface AuthorService {
Author findById(Long id);
List<Author> findAllOptimized();
List<Author> findAll();
Author create(Author item);
Author edit(Author item);
void deleteById(Long id);
void delete(Author item);
void delete(List<Author> items);
void deleteByIdIn(List<Long> ids);
}