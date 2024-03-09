package org.bshg.librarysystem.repository.content;
import org.bshg.librarysystem.entity.core.content.Author;
import org.bshg.librarysystem.entity.core.content.AuthorBook;
import org.bshg.librarysystem.utils.repository.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface AuthorDao extends Repository<Author, Long> {
}