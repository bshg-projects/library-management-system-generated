package org.bshg.librarysystem.sprocess.event.event.facade;
import org.bshg.librarysystem.entity.core.event.Event;
import java.util.List;
public interface DeleteEventProcess {
void run(Event item);
void run(Long id);
void runByIds(List<Long> ids);
void run(List<Event> items);
}