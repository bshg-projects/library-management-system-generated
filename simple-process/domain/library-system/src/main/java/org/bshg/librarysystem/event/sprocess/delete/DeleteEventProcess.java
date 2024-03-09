package org.bshg.librarysystem.event.sprocess.delete;
import org.bshg.librarysystem.event.Event;
import java.util.List;
public interface DeleteEventProcess {
void run(Event item);
void run(Long id);
void runByIds(List<Long> ids);
void run(List<Event> items);
}