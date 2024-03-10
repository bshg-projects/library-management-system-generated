package org.bshg.librarysystem.rack.sprocess.create;

import org.bshg.librarysystem.rack.Rack;

import java.util.List;

public interface CreateRackProcess {
    Rack run(Rack item);

    List<Rack> run(List<Rack> items);
}