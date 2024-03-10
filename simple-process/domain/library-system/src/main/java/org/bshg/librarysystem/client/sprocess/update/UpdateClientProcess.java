package org.bshg.librarysystem.client.sprocess.update;

import org.bshg.librarysystem.client.Client;

import java.util.List;

public interface UpdateClientProcess {
    Client run(Client item);

    List<Client> run(List<Client> items);
}
