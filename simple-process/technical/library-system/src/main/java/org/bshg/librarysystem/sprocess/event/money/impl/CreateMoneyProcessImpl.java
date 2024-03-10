package org.bshg.librarysystem.sprocess.event.money.impl;

import org.bshg.librarysystem.entity.core.event.Money;
import org.bshg.librarysystem.services.facade.event.MoneyService;
import org.bshg.librarysystem.sprocess.event.money.facade.CreateMoneyProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class CreateMoneyProcessImpl implements CreateMoneyProcess {
    @Transactional(rollbackFor = Exception.class)
    public Money run(Money item) {
// Your Creation Logic For 'Money'
        item = service.create(item);
        return item;
    }

    public List<Money> run(List<Money> items) {
        items.forEach(this::run);
        return items;
    }

    @Autowired
    private MoneyService service;
}