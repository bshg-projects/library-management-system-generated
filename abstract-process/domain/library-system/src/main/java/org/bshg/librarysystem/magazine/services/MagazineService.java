package org.bshg.librarysystem.magazine.services;
import org.bshg.librarysystem.magazine.Magazine;
import org.bshg.librarysystem.genre.Genre;
import org.bshg.librarysystem.publisher.Publisher;
import org.bshg.librarysystem.utils.service.IService;
import java.util.List;
public interface MagazineService extends IService<Magazine> {
int deleteByGenreId(Long id);
List<Magazine> findByGenreId(Long id);
int deleteByPublisherId(Long id);
List<Magazine> findByPublisherId(Long id);
}