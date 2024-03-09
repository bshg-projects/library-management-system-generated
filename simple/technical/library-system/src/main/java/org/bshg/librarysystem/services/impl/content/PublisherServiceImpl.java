package org.bshg.librarysystem.services.impl.content;
import org.bshg.librarysystem.entity.core.content.Publisher;
import org.bshg.librarysystem.repository.content.PublisherDao;
import org.bshg.librarysystem.services.facade.content.PublisherService;
import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.services.facade.content.BookService;
import org.bshg.librarysystem.entity.core.content.Magazine;
import org.bshg.librarysystem.services.facade.content.MagazineService;
import org.bshg.librarysystem.entity.core.library.Address;
import org.bshg.librarysystem.services.facade.library.AddressService;
import org.bshg.librarysystem.utils.service.ServiceHelper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.ArrayList;
@Service
public class PublisherServiceImpl implements PublisherService {
//--------------- FIND -------------------------------------
public Publisher findById(Long id) {
return dao.findById(id).orElse(null);
}
public List<Publisher> findAll() {
return dao.findAll();
}
public List<Publisher> findAllOptimized() {
return dao.findAllOptimized();
}
//--------------- CREATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public Publisher create(Publisher item) {
if (item == null) return null;
Publisher saved = dao.save(item);
createAssociatedList(saved);
return saved;
}
@Transactional(rollbackFor = Exception.class)
public List<Publisher> create(List<Publisher> items) {
List<Publisher> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(create(it)));
return result;
}
//--------------- UPDATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public Publisher update(Publisher item) {
if (item == null || item.getId() == null) return null;
Publisher saved = dao.save(item);
updateAssociatedList(saved);
return saved;
}
@Transactional(rollbackFor = Exception.class)
public List<Publisher> update(List<Publisher> items) {
List<Publisher> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(update(it)));
return result;
}
//--------------- DELETE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public void deleteById(Long id) {
Publisher item = findById(id);
if (item != null) delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(Publisher item) {
deleteAssociated(item);
dao.delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(List<Publisher> items) {
if (items == null || items.isEmpty()) return;
items.forEach(this::delete);
}
@Transactional(rollbackFor = Exception.class)
public void deleteByIdIn(List<Long> ids) {
ids.forEach(id -> {
Publisher item = findById(id);
if (item != null) {
deleteAssociated(item);
}
});
dao.deleteByIdIn(ids);
}
//--------------- FIND AND DELETE BYs ----------------------
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByAddressId(Long id){
Publisher found = findByAddressId(id);
if (found == null) return 0;
this.deleteAssociated(found);
return dao.deleteByAddressId(id);
}
@Override
public Publisher findByAddressId(Long id){
return dao.findByAddressId(id);
}
//----------------------------------------------------------
public void createAssociatedList(Publisher item) {
if (item == null || item.getId() == null) return;
ServiceHelper.createList(item, Publisher::getBooks, Book::setPublisher, bookService::create);
ServiceHelper.createList(item, Publisher::getMagazines, Magazine::setPublisher, magazineService::create);
}
public void updateAssociatedList(Publisher item) {
if (item == null || item.getId() == null) return;
ServiceHelper.updateList(
item, bookService.findByPublisherId(item.getId()),
item.getBooks(), Book::setPublisher,
bookService::update,
bookService::delete
);
ServiceHelper.updateList(
item, magazineService.findByPublisherId(item.getId()),
item.getMagazines(), Magazine::setPublisher,
magazineService::update,
magazineService::delete
);
}
@Transactional(rollbackFor = Exception.class)
public void deleteAssociated(Publisher item) {
deleteAssociatedList(item);
}
public void deleteAssociatedList(Publisher item) {
bookService.deleteByPublisherId(item.getId());
magazineService.deleteByPublisherId(item.getId());
}
//----------------------------------------------------------
@Autowired private PublisherDao dao;
@Lazy @Autowired private BookService bookService;
@Lazy @Autowired private MagazineService magazineService;
@Lazy @Autowired private AddressService addressService;
}