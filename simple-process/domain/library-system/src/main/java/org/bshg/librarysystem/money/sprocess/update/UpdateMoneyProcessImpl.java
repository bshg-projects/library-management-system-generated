package org.bshg.librarysystem.money.sprocess.update;

import org.bshg.librarysystem.money.Money;
import org.bshg.librarysystem.money.services.MoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class UpdateMoneyProcessImpl implements UpdateMoneyProcess {
    @Transactional(rollbackFor = Exception.class)
    public Money run(Money item) { // Your Logic To Update 'Money'
        item = service.edit(item);
        return item;
    }

    public List<Money> run(List<Money> items) {
        items.forEach(this::run);
        return items;
    }

    @Autowired
    private MoneyService service;
}