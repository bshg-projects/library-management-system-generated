package org.bshg.librarysystem.publisher.sprocess.update;

import org.bshg.librarysystem.publisher.Publisher;

import java.util.List;

public interface UpdatePublisherProcess {
    Publisher run(Publisher item);

    List<Publisher> run(List<Publisher> items);
}
