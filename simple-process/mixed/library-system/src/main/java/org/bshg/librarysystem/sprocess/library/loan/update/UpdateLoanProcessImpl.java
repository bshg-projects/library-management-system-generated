package org.bshg.librarysystem.sprocess.library.loan.update;

import org.bshg.librarysystem.entity.core.library.Loan;
import org.bshg.librarysystem.services.library.loan.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    private LoanService service;
}