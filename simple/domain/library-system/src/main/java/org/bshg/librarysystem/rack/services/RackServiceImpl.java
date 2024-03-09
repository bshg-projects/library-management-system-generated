package org.bshg.librarysystem.rack.services;
import org.bshg.librarysystem.rack.Rack;
import org.bshg.librarysystem.rack.RackDao;
import org.bshg.librarysystem.rack.services.RackService;
import org.bshg.librarysystem.book.Book;
import org.bshg.librarysystem.book.services.BookService;
import org.bshg.librarysystem.shelf.Shelf;
import org.bshg.librarysystem.shelf.services.ShelfService;
import org.bshg.librarysystem.utils.service.ServiceHelper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.ArrayList;
@Service
public class RackServiceImpl implements RackService {
//--------------- FIND -------------------------------------
public Rack findById(Long id) {
return dao.findById(id).orElse(null);
}
public List<Rack> findAll() {
return dao.findAll();
}
public List<Rack> findAllOptimized() {
return findAll();
}
//--------------- CREATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public Rack create(Rack item) {
if (item == null) return null;
Rack saved = dao.save(item);
createAssociatedList(saved);
return saved;
}
@Transactional(rollbackFor = Exception.class)
public List<Rack> create(List<Rack> items) {
List<Rack> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(create(it)));
return result;
}
//--------------- UPDATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public Rack update(Rack item) {
if (item == null || item.getId() == null) return null;
Rack saved = dao.save(item);
updateAssociatedList(saved);
return saved;
}
@Transactional(rollbackFor = Exception.class)
public List<Rack> update(List<Rack> items) {
List<Rack> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(update(it)));
return result;
}
//--------------- DELETE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public void deleteById(Long id) {
Rack item = findById(id);
if (item != null) delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(Rack item) {
deleteAssociated(item);
dao.delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(List<Rack> items) {
if (items == null || items.isEmpty()) return;
items.forEach(this::delete);
}
@Transactional(rollbackFor = Exception.class)
public void deleteByIdIn(List<Long> ids) {
ids.forEach(id -> {
Rack item = findById(id);
if (item != null) {
deleteAssociated(item);
}
});
dao.deleteByIdIn(ids);
}
//--------------- FIND AND DELETE BYs ----------------------
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByShelfId(Long id){
if (id == null) return 0;
List<Rack> found = findByShelfId(id);
if (found == null) return 0;
found.forEach(this::deleteAssociated);
return dao.deleteByShelfId(id);
}
@Override
public List<Rack> findByShelfId(Long id){
return dao.findByShelfId(id);
}
//----------------------------------------------------------
public void createAssociatedList(Rack item) {
if (item == null || item.getId() == null) return;
ServiceHelper.createList(item, Rack::getBooks, Book::setRack, bookService::create);
}
public void updateAssociatedList(Rack item) {
if (item == null || item.getId() == null) return;
ServiceHelper.updateList(
item, bookService.findByRackId(item.getId()),
item.getBooks(), Book::setRack,
bookService::update,
bookService::delete
);
}
@Transactional(rollbackFor = Exception.class)
public void deleteAssociated(Rack item) {
deleteAssociatedList(item);
}
public void deleteAssociatedList(Rack item) {
bookService.deleteByRackId(item.getId());
}
//----------------------------------------------------------
@Autowired private RackDao dao;
@Lazy @Autowired private BookService bookService;
@Lazy @Autowired private ShelfService shelfService;
}