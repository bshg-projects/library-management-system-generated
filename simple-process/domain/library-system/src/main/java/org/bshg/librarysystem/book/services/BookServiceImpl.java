package org.bshg.librarysystem.book.services;
import org.bshg.librarysystem.book.Book;
import org.bshg.librarysystem.book.BookDao;
import org.bshg.librarysystem.book.services.BookService;
import org.bshg.librarysystem.employee.Employee;
import org.bshg.librarysystem.employee.services.EmployeeService;
import org.bshg.librarysystem.publisher.Publisher;
import org.bshg.librarysystem.publisher.services.PublisherService;
import org.bshg.librarysystem.rack.Rack;
import org.bshg.librarysystem.rack.services.RackService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class BookServiceImpl implements BookService {
@Autowired BookDao dao;
@Override
public Book findById(Long id) {
return dao.findById(id).orElse(null);
}
@Override
public List<Book> findAll() {
return dao.findAll();
}
public List<Book> findAllOptimized() {
return dao.findAllOptimized();
}
@Transactional(rollbackFor = Exception.class)
@Override
public Book create(Book item) {
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
@Override
public Book edit(Book item) {
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
@Override
public void deleteById(Long id) {
dao.deleteById(id);
}
@Transactional(rollbackFor = Exception.class)
@Override
public void delete(Book item) {
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
public void delete(List<Book> list) {
if (list != null) {
list.forEach(item -> deleteById(item.getId()));
}
}
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByEmployeeId(Long id){
return dao.deleteByEmployeeId(id);
}
@Override
public List<Book> findByEmployeeId(Long id){
return dao.findByEmployeeId(id);
}
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByPublisherId(Long id){
return dao.deleteByPublisherId(id);
}
@Override
public List<Book> findByPublisherId(Long id){
return dao.findByPublisherId(id);
}
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByRackId(Long id){
return dao.deleteByRackId(id);
}
@Override
public List<Book> findByRackId(Long id){
return dao.findByRackId(id);
}
@Autowired private EmployeeService employeeService;
@Autowired private PublisherService publisherService;
@Autowired private RackService rackService;
}