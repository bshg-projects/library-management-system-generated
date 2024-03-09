package org.bshg.librarysystem.sprocess.library.loan.impl;
import org.bshg.librarysystem.entity.core.library.Loan;
import org.bshg.librarysystem.services.facade.library.LoanService;
import org.bshg.librarysystem.sprocess.library.loan.facade.UpdateLoanProcess;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import java.util.List;
@Component
public class UpdateLoanProcessImpl implements UpdateLoanProcess {
@Transactional(rollbackFor = Exception.class)
public Loan run(Loan item) { // Your Logic To Update 'Loan'
item = service.edit(item);
return item;
}
public List<Loan> run(List<Loan> items) {
items.forEach(this::run);
return items;
}
@Autowired private LoanService service;
}