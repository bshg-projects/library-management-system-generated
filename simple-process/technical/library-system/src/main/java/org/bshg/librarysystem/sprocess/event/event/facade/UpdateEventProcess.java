package org.bshg.librarysystem.sprocess.event.event.facade;

import org.bshg.librarysystem.entity.core.event.Event;

import java.util.List;

public interface UpdateEventProcess {
    Event run(Event item);

    List<Event> run(List<Event> items);
}
