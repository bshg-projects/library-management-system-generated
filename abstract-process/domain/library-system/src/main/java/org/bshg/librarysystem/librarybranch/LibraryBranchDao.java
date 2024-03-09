package org.bshg.librarysystem.librarybranch;
import org.bshg.librarysystem.librarybranch.LibraryBranch;
import org.bshg.librarysystem.address.Address;
import org.bshg.librarysystem.utils.repository.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface LibraryBranchDao extends Repository<LibraryBranch, Long> {
int deleteByAddressId(Long id);
LibraryBranch findByAddressId(Long id);
@Query("SELECT NEW LibraryBranch(item.id,item.name) FROM LibraryBranch item")
List<LibraryBranch> findAllOptimized();
}