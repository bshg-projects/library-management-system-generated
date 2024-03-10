package org.bshg.librarysystem.sprocess.user.client.facade;

import org.bshg.librarysystem.entity.core.user.Client;

import java.util.List;

public interface UpdateClientProcess {
    Client run(Client item);

    List<Client> run(List<Client> items);
}
