package org.bshg.librarysystem.sprocess.event.money;

import org.bshg.librarysystem.services.event.money.MoneyService;
import org.bshg.librarysystem.sprocess.event.money.create.CreateMoneyProcess;
import org.bshg.librarysystem.sprocess.event.money.create.CreateMoneyProcessImpl;
import org.bshg.librarysystem.sprocess.event.money.delete.DeleteMoneyProcess;
import org.bshg.librarysystem.sprocess.event.money.delete.DeleteMoneyProcessImpl;
import org.bshg.librarysystem.sprocess.event.money.update.UpdateMoneyProcess;
import org.bshg.librarysystem.sprocess.event.money.update.UpdateMoneyProcessImpl;
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