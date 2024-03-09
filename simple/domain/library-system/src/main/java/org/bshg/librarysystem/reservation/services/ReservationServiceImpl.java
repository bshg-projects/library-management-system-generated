package org.bshg.librarysystem.reservation.services;
import org.bshg.librarysystem.reservation.Reservation;
import org.bshg.librarysystem.reservation.ReservationDao;
import org.bshg.librarysystem.reservation.services.ReservationService;
import org.bshg.librarysystem.book.Book;
import org.bshg.librarysystem.book.services.BookService;
import org.bshg.librarysystem.client.Client;
import org.bshg.librarysystem.client.services.ClientService;
import org.bshg.librarysystem.utils.service.ServiceHelper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.ArrayList;
@Service
public class ReservationServiceImpl implements ReservationService {
//--------------- FIND -------------------------------------
public Reservation findById(Long id) {
return dao.findById(id).orElse(null);
}
public List<Reservation> findAll() {
return dao.findAll();
}
public List<Reservation> findAllOptimized() {
return dao.findAllOptimized();
}
//--------------- CREATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public Reservation create(Reservation item) {
if (item == null) return null;
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
public List<Reservation> create(List<Reservation> items) {
List<Reservation> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(create(it)));
return result;
}
//--------------- UPDATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public Reservation update(Reservation item) {
if (item == null || item.getId() == null) return null;
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
public List<Reservation> update(List<Reservation> items) {
List<Reservation> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(update(it)));
return result;
}
//--------------- DELETE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public void deleteById(Long id) {
Reservation item = findById(id);
if (item != null) delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(Reservation item) {
dao.delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(List<Reservation> items) {
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
public Reservation findByBookId(Long id){
return dao.findByBookId(id);
}
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByClientId(Long id){
if (id == null) return 0;
return dao.deleteByClientId(id);
}
@Override
public List<Reservation> findByClientId(Long id){
return dao.findByClientId(id);
}
//----------------------------------------------------------
//----------------------------------------------------------
@Autowired private ReservationDao dao;
@Lazy @Autowired private BookService bookService;
@Lazy @Autowired private ClientService clientService;
}