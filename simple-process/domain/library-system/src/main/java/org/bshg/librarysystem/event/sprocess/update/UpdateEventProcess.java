package org.bshg.librarysystem.event.sprocess.update;

import org.bshg.librarysystem.event.Event;

import java.util.List;

public interface UpdateEventProcess {
    Event run(Event item);

    List<Event> run(List<Event> items);
}
