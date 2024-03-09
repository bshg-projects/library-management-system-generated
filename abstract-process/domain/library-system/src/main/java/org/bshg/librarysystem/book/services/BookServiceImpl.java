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
import org.bshg.librarysystem.utils.service.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class BookServiceImpl extends ServiceImpl<Book, BookDao> implements BookService {
public BookServiceImpl(BookDao dao) {
super(dao);
}
@Override
public List<Book> findAllOptimized() {
return dao.findAllOptimized();
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