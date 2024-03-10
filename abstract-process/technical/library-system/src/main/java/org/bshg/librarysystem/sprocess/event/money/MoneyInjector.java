package org.bshg.librarysystem.sprocess.event.money;

import org.bshg.librarysystem.services.facade.event.MoneyService;
import org.bshg.librarysystem.sprocess.event.money.facade.CreateMoneyProcess;
import org.bshg.librarysystem.sprocess.event.money.facade.DeleteMoneyProcess;
import org.bshg.librarysystem.sprocess.event.money.facade.UpdateMoneyProcess;
import org.bshg.librarysystem.sprocess.event.money.impl.CreateMoneyProcessImpl;
import org.bshg.librarysystem.sprocess.event.money.impl.DeleteMoneyProcessImpl;
import org.bshg.librarysystem.sprocess.event.money.impl.UpdateMoneyProcessImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Inject Money Processes (Create, Update, Delete).
 */
@Configuration
public class MoneyInjector {
    @Bean
    public CreateMoneyProcess createMoneyProcess(MoneyService service) {
        var bean = new CreateMoneyProcessImpl(service);
        return bean;
    }

    @Bean
    public UpdateMoneyProcess updateMoneyProcess(MoneyService service) {
        var bean = new UpdateMoneyProcessImpl(service);
        return bean;
    }

    @Bean
    public DeleteMoneyProcess deleteMoneyProcess(MoneyService service) {
        var bean = new DeleteMoneyProcessImpl(service);
        return bean;
    }
}