package org.bshg.librarysystem.librarybranch.sprocess.update;
import org.bshg.librarysystem.librarybranch.LibraryBranch;
import org.bshg.librarysystem.librarybranch.services.LibraryBranchService;
import org.bshg.librarysystem.librarybranch.sprocess.update.UpdateLibraryBranchProcess;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
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
@Autowired private LibraryBranchService service;
}