package org.bshg.librarysystem.services.library.loan;
import org.bshg.librarysystem.entity.core.library.Loan;
import org.bshg.librarysystem.repository.library.LoanDao;
import org.bshg.librarysystem.services.library.loan.LoanService;
import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.services.content.book.BookService;
import org.bshg.librarysystem.entity.core.user.Client;
import org.bshg.librarysystem.services.user.client.ClientService;
import org.bshg.librarysystem.entity.core.user.admin.Employee;
import org.bshg.librarysystem.services.user.admin.employee.EmployeeService;
import org.bshg.librarysystem.utils.service.ServiceHelper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.ArrayList;
@Service
public class LoanServiceImpl implements LoanService {
//--------------- FIND -------------------------------------
public Loan findById(Long id) {
return dao.findById(id).orElse(null);
}
public List<Loan> findAll() {
return dao.findAll();
}
public List<Loan> findAllOptimized() {
return dao.findAllOptimized();
}
//--------------- CREATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public Loan create(Loan item) {
if (item == null) return null;
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
public List<Loan> create(List<Loan> items) {
List<Loan> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(create(it)));
return result;
}
//--------------- UPDATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public Loan update(Loan item) {
if (item == null || item.getId() == null) return null;
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
public List<Loan> update(List<Loan> items) {
List<Loan> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(update(it)));
return result;
}
//--------------- DELETE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public void deleteById(Long id) {
Loan item = findById(id);
if (item != null) delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(Loan item) {
dao.delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(List<Loan> items) {
if (items == null || items.isEmpty()) return;
items.forEach(this::delete);
}
@Transactional(rollbackFor = Exception.class)
public void deleteByIdIn(List<Long> ids) {
dao.deleteByIdIn(ids);
}
//--------------- FIND AND DELETE BYs ----------------------
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
//----------------------------------------------------------
//----------------------------------------------------------
@Autowired private LoanDao dao;
@Lazy @Autowired private BookService bookService;
@Lazy @Autowired private ClientService clientService;
@Lazy @Autowired private EmployeeService employeeService;
}