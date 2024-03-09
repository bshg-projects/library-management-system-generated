package org.bshg.librarysystem.librarybranch.services;
import org.bshg.librarysystem.librarybranch.LibraryBranch;
import org.bshg.librarysystem.address.Address;
import java.util.List;
public interface LibraryBranchService {
LibraryBranch findById(Long id);
List<LibraryBranch> findAllOptimized();
List<LibraryBranch> findAll();
LibraryBranch create(LibraryBranch item);
List<LibraryBranch> create(List<LibraryBranch> item);
LibraryBranch update(LibraryBranch item);
List<LibraryBranch> update(List<LibraryBranch> item);
void deleteById(Long id);
void delete(LibraryBranch item);
void delete(List<LibraryBranch> items);
void deleteByIdIn(List<Long> ids);
int deleteByAddressId(Long id);
LibraryBranch findByAddressId(Long id);
}