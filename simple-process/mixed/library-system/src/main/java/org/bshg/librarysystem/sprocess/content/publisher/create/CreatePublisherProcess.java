package org.bshg.librarysystem.sprocess.content.publisher.create;
import org.bshg.librarysystem.entity.core.content.Publisher;
import java.util.List;
public interface CreatePublisherProcess {
Publisher run(Publisher item);
List<Publisher> run(List<Publisher> items);
}