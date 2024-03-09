
package org.bshg.librarysystem.services.library.librarybranch;
import org.bshg.librarysystem.entity.core.library.LibraryBranch;
import org.bshg.librarysystem.repository.library.LibraryBranchDao;
import org.bshg.librarysystem.services.library.librarybranch.LibraryBranchService;
import org.bshg.librarysystem.entity.core.library.Address;
import org.bshg.librarysystem.services.library.address.AddressService;
import org.bshg.librarysystem.utils.service.ServiceImpl;
import org.bshg.librarysystem.utils.service.ServiceHelper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
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
@Lazy @Autowired private AddressService addressService;
}