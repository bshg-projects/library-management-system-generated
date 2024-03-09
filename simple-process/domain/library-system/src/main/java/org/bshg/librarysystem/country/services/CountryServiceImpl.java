package org.bshg.librarysystem.country.services;
import org.bshg.librarysystem.country.Country;
import org.bshg.librarysystem.country.CountryDao;
import org.bshg.librarysystem.country.services.CountryService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class CountryServiceImpl implements CountryService {
@Autowired CountryDao dao;
@Override
public Country findById(Long id) {
return dao.findById(id).orElse(null);
}
@Override
public List<Country> findAll() {
return dao.findAll();
}
public List<Country> findAllOptimized() {
return dao.findAllOptimized();
}
@Transactional(rollbackFor = Exception.class)
@Override
public Country create(Country item) {
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
@Override
public Country edit(Country item) {
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
@Override
public void deleteById(Long id) {
dao.deleteById(id);
}
@Transactional(rollbackFor = Exception.class)
@Override
public void delete(Country item) {
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
public void delete(List<Country> list) {
if (list != null) {
list.forEach(item -> deleteById(item.getId()));
}
}
}