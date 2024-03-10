package org.bshg.librarysystem.client.sprocess.create;

import org.bshg.librarysystem.client.Client;

import java.util.List;

public interface CreateClientProcess {
    Client run(Client item);

    List<Client> run(List<Client> items);
}