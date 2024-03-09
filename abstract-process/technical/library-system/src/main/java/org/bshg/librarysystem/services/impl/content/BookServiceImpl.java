package org.bshg.librarysystem.services.impl.content;
import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.repository.content.BookDao;
import org.bshg.librarysystem.services.facade.content.BookService;
import org.bshg.librarysystem.entity.core.user.admin.Employee;
import org.bshg.librarysystem.services.facade.user.admin.EmployeeService;
import org.bshg.librarysystem.entity.core.content.Publisher;
import org.bshg.librarysystem.services.facade.content.PublisherService;
import org.bshg.librarysystem.entity.core.storage.Rack;
import org.bshg.librarysystem.services.facade.storage.RackService;
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