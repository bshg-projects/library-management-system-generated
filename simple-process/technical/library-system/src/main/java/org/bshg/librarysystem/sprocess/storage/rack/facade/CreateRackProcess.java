package org.bshg.librarysystem.sprocess.storage.rack.facade;

import org.bshg.librarysystem.entity.core.storage.Rack;

import java.util.List;

public interface CreateRackProcess {
    Rack run(Rack item);

    List<Rack> run(List<Rack> items);
}