package org.bshg.librarysystem.magazine.services;
import org.bshg.librarysystem.magazine.Magazine;
import org.bshg.librarysystem.genre.Genre;
import org.bshg.librarysystem.publisher.Publisher;
import java.util.List;
public interface MagazineService {
Magazine findById(Long id);
List<Magazine> findAllOptimized();
List<Magazine> findAll();
Magazine create(Magazine item);
Magazine edit(Magazine item);
void deleteById(Long id);
void delete(Magazine item);
void delete(List<Magazine> items);
void deleteByIdIn(List<Long> ids);
int deleteByGenreId(Long id);
List<Magazine> findByGenreId(Long id);
int deleteByPublisherId(Long id);
List<Magazine> findByPublisherId(Long id);
}