package org.bshg.librarysystem.services.impl.event;
import org.bshg.librarysystem.entity.core.event.Money;
import org.bshg.librarysystem.repository.event.MoneyDao;
import org.bshg.librarysystem.services.facade.event.MoneyService;
import org.bshg.librarysystem.utils.service.ServiceHelper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.ArrayList;
@Service
public class MoneyServiceImpl implements MoneyService {
//--------------- FIND -------------------------------------
public Money findById(Long id) {
return dao.findById(id).orElse(null);
}
public List<Money> findAll() {
return dao.findAll();
}
public List<Money> findAllOptimized() {
return dao.findAllOptimized();
}
//--------------- CREATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public Money create(Money item) {
if (item == null) return null;
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
public List<Money> create(List<Money> items) {
List<Money> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(create(it)));
return result;
}
//--------------- UPDATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public Money update(Money item) {
if (item == null || item.getId() == null) return null;
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
public List<Money> update(List<Money> items) {
List<Money> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(update(it)));
return result;
}
//--------------- DELETE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public void deleteById(Long id) {
Money item = findById(id);
if (item != null) delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(Money item) {
dao.delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(List<Money> items) {
if (items == null || items.isEmpty()) return;
items.forEach(this::delete);
}
@Transactional(rollbackFor = Exception.class)
public void deleteByIdIn(List<Long> ids) {
dao.deleteByIdIn(ids);
}
//--------------- FIND AND DELETE BYs ----------------------
//----------------------------------------------------------
//----------------------------------------------------------
@Autowired private MoneyDao dao;
}