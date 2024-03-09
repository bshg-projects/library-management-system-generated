package org.bshg.librarysystem.magazine.services;
import org.bshg.librarysystem.magazine.Magazine;
import org.bshg.librarysystem.magazine.MagazineDao;
import org.bshg.librarysystem.magazine.services.MagazineService;
import org.bshg.librarysystem.genre.Genre;
import org.bshg.librarysystem.genre.services.GenreService;
import org.bshg.librarysystem.publisher.Publisher;
import org.bshg.librarysystem.publisher.services.PublisherService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class MagazineServiceImpl implements MagazineService {
@Autowired MagazineDao dao;
@Override
public Magazine findById(Long id) {
return dao.findById(id).orElse(null);
}
@Override
public List<Magazine> findAll() {
return dao.findAll();
}
public List<Magazine> findAllOptimized() {
return dao.findAllOptimized();
}
@Transactional(rollbackFor = Exception.class)
@Override
public Magazine create(Magazine item) {
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
@Override
public Magazine edit(Magazine item) {
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
@Override
public void deleteById(Long id) {
dao.deleteById(id);
}
@Transactional(rollbackFor = Exception.class)
@Override
public void delete(Magazine item) {
if (item == null)
return;
dao.deleteById(item.getId());
}
@Transactional(rollbackFor = Exception.class)
@Override
public void deleteByIdIn(List<Long> ids) {
dao.deleteByIdIn(ids);
}
@Transactional(rollbackFor = Exception.class)
@Override
public void delete(List<Magazine> list) {
if (list != null) {
list.forEach(item -> deleteById(item.getId()));
}
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