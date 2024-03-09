package org.bshg.librarysystem.librarybranch.services;
import org.bshg.librarysystem.librarybranch.LibraryBranch;
import org.bshg.librarysystem.librarybranch.LibraryBranchDao;
import org.bshg.librarysystem.librarybranch.services.LibraryBranchService;
import org.bshg.librarysystem.address.Address;
import org.bshg.librarysystem.address.services.AddressService;
import org.bshg.librarysystem.utils.service.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class LibraryBranchServiceImpl extends ServiceImpl<LibraryBranch, LibraryBranchDao> implements LibraryBranchService {
public LibraryBranchServiceImpl(LibraryBranchDao dao) {
super(dao);
}
@Override
public List<LibraryBranch> findAllOptimized() {
return dao.findAllOptimized();
}
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByAddressId(Long id){
return dao.deleteByAddressId(id);
}
@Override
public LibraryBranch findByAddressId(Long id){
return dao.findByAddressId(id);
}
@Autowired private AddressService addressService;
}