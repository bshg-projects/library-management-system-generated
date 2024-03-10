package org.bshg.librarysystem.event.services;

import org.bshg.librarysystem.event.Event;

import java.util.List;

public interface EventService {
    Event findById(Long id);

    List<Event> findAllOptimized();

    List<Event> findAll();

    Event create(Event item);

    List<Event> create(List<Event> item);

    Event update(Event item);

    List<Event> update(List<Event> item);

    void deleteById(Long id);

    void delete(Event item);

    void delete(List<Event> items);

    void deleteByIdIn(List<Long> ids);
}