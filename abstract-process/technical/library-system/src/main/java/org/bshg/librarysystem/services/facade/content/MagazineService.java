package org.bshg.librarysystem.services.facade.content;
import org.bshg.librarysystem.entity.core.content.Magazine;
import org.bshg.librarysystem.entity.core.content.Genre;
import org.bshg.librarysystem.entity.core.content.Publisher;
import org.bshg.librarysystem.utils.service.IService;
import java.util.List;
public interface MagazineService extends IService<Magazine> {
int deleteByGenreId(Long id);
List<Magazine> findByGenreId(Long id);
int deleteByPublisherId(Long id);
List<Magazine> findByPublisherId(Long id);
}