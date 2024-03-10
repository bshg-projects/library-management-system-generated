package org.bshg.librarysystem.rack.sprocess.update;

import org.bshg.librarysystem.rack.Rack;

import java.util.List;

public interface UpdateRackProcess {
    Rack run(Rack item);

    List<Rack> run(List<Rack> items);
}
