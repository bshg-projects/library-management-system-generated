package org.bshg.librarysystem.magazine.sprocess.delete;
import org.bshg.librarysystem.magazine.Magazine;
import org.bshg.librarysystem.genre.Genre;
import org.bshg.librarysystem.publisher.Publisher;
import java.util.List;
public interface DeleteMagazineProcess {
void run(Magazine item);
void run(Long id);
void runByIds(List<Long> ids);
void run(List<Magazine> items);
void deleteByGenre(Genre genre);
void deleteByPublisher(Publisher publisher);
}