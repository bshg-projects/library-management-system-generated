package org.bshg.librarysystem.sprocess.user.client.create;
import org.bshg.librarysystem.entity.core.user.Client;
import java.util.List;
public interface CreateClientProcess {
Client run(Client item);
List<Client> run(List<Client> items);
}