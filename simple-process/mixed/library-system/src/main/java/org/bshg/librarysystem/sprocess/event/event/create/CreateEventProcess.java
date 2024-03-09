package org.bshg.librarysystem.sprocess.event.event.create;
import org.bshg.librarysystem.entity.core.event.Event;
import java.util.List;
public interface CreateEventProcess {
Event run(Event item);
List<Event> run(List<Event> items);
}