package org.bshg.librarysystem.event.sprocess.create;
import org.bshg.librarysystem.event.Event;
import java.util.List;
public interface CreateEventProcess {
Event run(Event item);
List<Event> run(List<Event> items);
}