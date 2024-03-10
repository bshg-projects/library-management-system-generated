package org.bshg.librarysystem.sprocess.library.librarybranch.update;

import org.bshg.librarysystem.entity.core.library.LibraryBranch;
import org.bshg.librarysystem.services.library.librarybranch.LibraryBranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class UpdateLibraryBranchProcessImpl implements UpdateLibraryBranchProcess {
    @Transactional(rollbackFor = Exception.class)
    public LibraryBranch run(LibraryBranch item) { // Your Logic To Update 'LibraryBranch'
        item = service.edit(item);
        return item;
    }

    public List<LibraryBranch> run(List<LibraryBranch> items) {
        items.forEach(this::run);
        return items;
    }

    @Autowired
    private LibraryBranchService service;
}