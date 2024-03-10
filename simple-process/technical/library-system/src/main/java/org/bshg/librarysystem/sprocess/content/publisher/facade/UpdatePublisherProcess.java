package org.bshg.librarysystem.sprocess.content.publisher.facade;

import org.bshg.librarysystem.entity.core.content.Publisher;

import java.util.List;

public interface UpdatePublisherProcess {
    Publisher run(Publisher item);

    List<Publisher> run(List<Publisher> items);
}
