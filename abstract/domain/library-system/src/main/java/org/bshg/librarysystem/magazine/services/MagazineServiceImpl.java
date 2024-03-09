
package org.bshg.librarysystem.magazine.services;
import org.bshg.librarysystem.magazine.Magazine;
import org.bshg.librarysystem.magazine.MagazineDao;
import org.bshg.librarysystem.magazine.services.MagazineService;
import org.bshg.librarysystem.genre.Genre;
import org.bshg.librarysystem.genre.services.GenreService;
import org.bshg.librarysystem.publisher.Publisher;
import org.bshg.librarysystem.publisher.services.PublisherService;
import org.bshg.librarysystem.utils.service.ServiceImpl;
import org.bshg.librarysystem.utils.service.ServiceHelper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class MagazineServiceImpl extends ServiceImpl<Magazine, MagazineDao> implements MagazineService {
public MagazineServiceImpl(MagazineDao dao) {
super(dao);
}
@Override
public List<Magazine> findAllOptimized() {
return dao.findAllOptimized();
}
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByGenreId(Long id){
if (id == null) return 0;
return dao.deleteByGenreId(id);
}
@Override
public List<Magazine> findByGenreId(Long id){
return dao.findByGenreId(id);
}
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByPublisherId(Long id){
if (id == null) return 0;
return dao.deleteByPublisherId(id);
}
@Override
public List<Magazine> findByPublisherId(Long id){
return dao.findByPublisherId(id);
}
@Lazy @Autowired private GenreService genreService;
@Lazy @Autowired private PublisherService publisherService;
}