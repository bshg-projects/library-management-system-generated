package org.bshg.librarysystem.money.sprocess;

import org.bshg.librarysystem.money.services.MoneyService;
import org.bshg.librarysystem.money.sprocess.create.CreateMoneyProcess;
import org.bshg.librarysystem.money.sprocess.create.CreateMoneyProcessImpl;
import org.bshg.librarysystem.money.sprocess.delete.DeleteMoneyProcess;
import org.bshg.librarysystem.money.sprocess.delete.DeleteMoneyProcessImpl;
import org.bshg.librarysystem.money.sprocess.update.UpdateMoneyProcess;
import org.bshg.librarysystem.money.sprocess.update.UpdateMoneyProcessImpl;
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