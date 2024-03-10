package org.bshg.librarysystem.publisher.sprocess.create;

import org.bshg.librarysystem.publisher.Publisher;

import java.util.List;

public interface CreatePublisherProcess {
    Publisher run(Publisher item);

    List<Publisher> run(List<Publisher> items);
}