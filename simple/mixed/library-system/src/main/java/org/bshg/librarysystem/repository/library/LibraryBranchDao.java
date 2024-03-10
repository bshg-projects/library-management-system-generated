package org.bshg.librarysystem.repository.library;

import org.bshg.librarysystem.entity.core.library.LibraryBranch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LibraryBranchDao extends JpaRepository<LibraryBranch, Long> {
    int deleteByIdIn(List<Long> ids);

    int deleteByAddressId(Long id);

    LibraryBranch findByAddressId(Long id);

    @Query("SELECT NEW LibraryBranch(item.id,item.name) FROM LibraryBranch item")
    List<LibraryBranch> findAllOptimized();
}