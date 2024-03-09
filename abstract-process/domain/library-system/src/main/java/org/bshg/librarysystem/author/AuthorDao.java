package org.bshg.librarysystem.author;
import org.bshg.librarysystem.author.Author;
import org.bshg.librarysystem.authorbook.AuthorBook;
import org.bshg.librarysystem.utils.repository.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface AuthorDao extends Repository<Author, Long> {
}