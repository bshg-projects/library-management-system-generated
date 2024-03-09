package org.bshg.librarysystem.services.event.money;
import org.bshg.librarysystem.entity.core.event.Money;
import org.bshg.librarysystem.repository.event.MoneyDao;
import org.bshg.librarysystem.services.event.money.MoneyService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class MoneyServiceImpl implements MoneyService {
@Autowired MoneyDao dao;
@Override
public Money findById(Long id) {
return dao.findById(id).orElse(null);
}
@Override
public List<Money> findAll() {
return dao.findAll();
}
public List<Money> findAllOptimized() {
return dao.findAllOptimized();
}
@Transactional(rollbackFor = Exception.class)
@Override
public Money create(Money item) {
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
@Override
public Money edit(Money item) {
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
@Override
public void deleteById(Long id) {
dao.deleteById(id);
}
@Transactional(rollbackFor = Exception.class)
@Override
public void delete(Money item) {
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
public void delete(List<Money> list) {
if (list != null) {
list.forEach(item -> deleteById(item.getId()));
}
}
}