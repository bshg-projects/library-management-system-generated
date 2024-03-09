package org.bshg.librarysystem.sprocess.event.event;
import org.bshg.librarysystem.services.event.event.EventService;
import org.bshg.librarysystem.sprocess.event.event.create.CreateEventProcess;
import org.bshg.librarysystem.sprocess.event.event.update.UpdateEventProcess;
import org.bshg.librarysystem.sprocess.event.event.delete.DeleteEventProcess;
import org.bshg.librarysystem.sprocess.event.event.create.CreateEventProcessImpl;
import org.bshg.librarysystem.sprocess.event.event.update.UpdateEventProcessImpl;
import org.bshg.librarysystem.sprocess.event.event.delete.DeleteEventProcessImpl;
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
public CreateEventProcess createEventProcess (EventService service) {
var bean = new CreateEventProcessImpl(service);
return bean;
}
@Bean
public UpdateEventProcess updateEventProcess (EventService service) {
var bean = new UpdateEventProcessImpl(service);
return bean;
}
@Bean
public DeleteEventProcess deleteEventProcess(EventService service) {
var bean = new DeleteEventProcessImpl(service);
return bean;
}
}