package org.bshg.librarysystem.sprocess.user.client.facade;

import org.bshg.librarysystem.entity.core.user.Client;

import java.util.List;

public interface DeleteClientProcess {
    void run(Client item);

    void run(Long id);

    void runByIds(List<Long> ids);

    void run(List<Client> items);
}