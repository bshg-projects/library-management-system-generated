package org.bshg.librarysystem.client.sprocess.delete;

import org.bshg.librarysystem.client.Client;

import java.util.List;

public interface DeleteClientProcess {
    void run(Client item);

    void run(Long id);

    void runByIds(List<Long> ids);

    void run(List<Client> items);
}