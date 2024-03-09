package org.bshg.librarysystem.address.services;
import org.bshg.librarysystem.address.Address;
import org.bshg.librarysystem.address.AddressDao;
import org.bshg.librarysystem.address.services.AddressService;
import org.bshg.librarysystem.country.Country;
import org.bshg.librarysystem.country.services.CountryService;
import org.bshg.librarysystem.employee.Employee;
import org.bshg.librarysystem.employee.services.EmployeeService;
import org.bshg.librarysystem.publisher.Publisher;
import org.bshg.librarysystem.publisher.services.PublisherService;
import org.bshg.librarysystem.librarybranch.LibraryBranch;
import org.bshg.librarysystem.librarybranch.services.LibraryBranchService;
import org.bshg.librarysystem.utils.service.ServiceHelper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.ArrayList;
@Service
public class AddressServiceImpl implements AddressService {
//--------------- FIND -------------------------------------
public Address findById(Long id) {
return dao.findById(id).orElse(null);
}
public List<Address> findAll() {
return dao.findAll();
}
public List<Address> findAllOptimized() {
return findAll();
}
//--------------- CREATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public Address create(Address item) {
if (item == null) return null;
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
public List<Address> create(List<Address> items) {
List<Address> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(create(it)));
return result;
}
//--------------- UPDATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public Address update(Address item) {
if (item == null || item.getId() == null) return null;
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
public List<Address> update(List<Address> items) {
List<Address> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(update(it)));
return result;
}
//--------------- DELETE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public void deleteById(Long id) {
Address item = findById(id);
if (item != null) delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(Address item) {
deleteAssociated(item);
dao.delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(List<Address> items) {
if (items == null || items.isEmpty()) return;
items.forEach(this::delete);
}
@Transactional(rollbackFor = Exception.class)
public void deleteByIdIn(List<Long> ids) {
ids.forEach(id -> {
Address item = findById(id);
if (item != null) {
deleteAssociated(item);
}
});
dao.deleteByIdIn(ids);
}
//--------------- FIND AND DELETE BYs ----------------------
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByCountryId(Long id){
if (id == null) return 0;
List<Address> found = findByCountryId(id);
if (found == null) return 0;
found.forEach(this::deleteAssociated);
return dao.deleteByCountryId(id);
}
@Override
public List<Address> findByCountryId(Long id){
return dao.findByCountryId(id);
}
//----------------------------------------------------------
@Transactional(rollbackFor = Exception.class)
public void deleteAssociated(Address item) {
deleteAssociatedObjects(item);
}
public void deleteAssociatedObjects(Address item) {
employeeService.deleteByAddressId(item.getId());
publisherService.deleteByAddressId(item.getId());
libraryBranchService.deleteByAddressId(item.getId());
}
//----------------------------------------------------------
@Autowired private AddressDao dao;
@Lazy @Autowired private CountryService countryService;
@Lazy @Autowired private EmployeeService employeeService;
@Lazy @Autowired private PublisherService publisherService;
@Lazy @Autowired private LibraryBranchService libraryBranchService;
}