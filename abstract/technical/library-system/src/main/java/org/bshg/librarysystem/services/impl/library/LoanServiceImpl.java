
package org.bshg.librarysystem.services.impl.library;
import org.bshg.librarysystem.entity.core.library.Loan;
import org.bshg.librarysystem.repository.library.LoanDao;
import org.bshg.librarysystem.services.facade.library.LoanService;
import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.services.facade.content.BookService;
import org.bshg.librarysystem.entity.core.user.Client;
import org.bshg.librarysystem.services.facade.user.ClientService;
import org.bshg.librarysystem.entity.core.user.admin.Employee;
import org.bshg.librarysystem.services.facade.user.admin.EmployeeService;
import org.bshg.librarysystem.utils.service.ServiceImpl;
import org.bshg.librarysystem.utils.service.ServiceHelper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class LoanServiceImpl extends ServiceImpl<Loan, LoanDao> implements LoanService {
public LoanServiceImpl(LoanDao dao) {
super(dao);
}
@Override
public List<Loan> findAllOptimized() {
return dao.findAllOptimized();
}
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByBookId(Long id){
return dao.deleteByBookId(id);
}
@Override
public Loan findByBookId(Long id){
return dao.findByBookId(id);
}
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByClientId(Long id){
if (id == null) return 0;
return dao.deleteByClientId(id);
}
@Override
public List<Loan> findByClientId(Long id){
return dao.findByClientId(id);
}
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByEmployeeId(Long id){
if (id == null) return 0;
return dao.deleteByEmployeeId(id);
}
@Override
public List<Loan> findByEmployeeId(Long id){
return dao.findByEmployeeId(id);
}
@Lazy @Autowired private BookService bookService;
@Lazy @Autowired private ClientService clientService;
@Lazy @Autowired private EmployeeService employeeService;
}