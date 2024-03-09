package org.bshg.librarysystem.services.impl.content;
import org.bshg.librarysystem.entity.core.content.Magazine;
import org.bshg.librarysystem.repository.content.MagazineDao;
import org.bshg.librarysystem.services.facade.content.MagazineService;
import org.bshg.librarysystem.entity.core.content.Genre;
import org.bshg.librarysystem.services.facade.content.GenreService;
import org.bshg.librarysystem.entity.core.content.Publisher;
import org.bshg.librarysystem.services.facade.content.PublisherService;
import org.bshg.librarysystem.utils.service.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
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
return dao.deleteByGenreId(id);
}
@Override
public List<Magazine> findByGenreId(Long id){
return dao.findByGenreId(id);
}
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByPublisherId(Long id){
return dao.deleteByPublisherId(id);
}
@Override
public List<Magazine> findByPublisherId(Long id){
return dao.findByPublisherId(id);
}
@Autowired private GenreService genreService;
@Autowired private PublisherService publisherService;
}