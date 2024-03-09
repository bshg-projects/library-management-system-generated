package org.bshg.librarysystem.genre.services;
import org.bshg.librarysystem.genre.Genre;
import org.bshg.librarysystem.bookgenre.BookGenre;
import org.bshg.librarysystem.magazine.Magazine;
import java.util.List;
public interface GenreService {
Genre findById(Long id);
List<Genre> findAllOptimized();
List<Genre> findAll();
Genre create(Genre item);
List<Genre> create(List<Genre> item);
Genre update(Genre item);
List<Genre> update(List<Genre> item);
void deleteById(Long id);
void delete(Genre item);
void delete(List<Genre> items);
void deleteByIdIn(List<Long> ids);
}