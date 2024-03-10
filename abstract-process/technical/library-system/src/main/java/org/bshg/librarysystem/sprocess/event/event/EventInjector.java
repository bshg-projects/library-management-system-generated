package org.bshg.librarysystem.sprocess.event.event;

import org.bshg.librarysystem.services.facade.event.EventService;
import org.bshg.librarysystem.sprocess.event.event.facade.CreateEventProcess;
import org.bshg.librarysystem.sprocess.event.event.facade.UpdateEventProcess;
import org.bshg.librarysystem.sprocess.event.event.facade.DeleteEventProcess;
import org.bshg.librarysystem.sprocess.event.event.impl.CreateEventProcessImpl;
import org.bshg.librarysystem.sprocess.event.event.impl.UpdateEventProcessImpl;
import org.bshg.librarysystem.sprocess.event.event.impl.DeleteEventProcessImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Inject Event Processes (Create, Update, Delete).
 */
@Configuration
public class EventInjector {
    @Bean
    public CreateEventProcess createEventProcess(EventService service) {
        var bean = new CreateEventProcessImpl(service);
        return bean;
    }

    @Bean
    public UpdateEventProcess updateEventProcess(EventService service) {
        var bean = new UpdateEventProcessImpl(service);
        return bean;
    }

    @Bean
    public DeleteEventProcess deleteEventProcess(EventService service) {
        var bean = new DeleteEventProcessImpl(service);
        return bean;
    }
}