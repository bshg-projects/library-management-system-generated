package org.bshg.librarysystem.sprocess.storage.rack.update;

import org.bshg.librarysystem.entity.core.storage.Rack;

import java.util.List;

public interface UpdateRackProcess {
    Rack run(Rack item);

    List<Rack> run(List<Rack> items);
}
