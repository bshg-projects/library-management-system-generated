package org.bshg.librarysystem.money.services;

import org.bshg.librarysystem.money.Money;
import org.bshg.librarysystem.money.MoneyDao;
import org.bshg.librarysystem.utils.service.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoneyServiceImpl extends ServiceImpl<Money, MoneyDao> implements MoneyService {
    public MoneyServiceImpl(MoneyDao dao) {
        super(dao);
    }

    @Override
    public List<Money> findAllOptimized() {
        return dao.findAllOptimized();
    }
}