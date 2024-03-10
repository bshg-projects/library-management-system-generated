package org.bshg.librarysystem.sprocess.content.magazine.update;

import org.bshg.librarysystem.entity.core.content.Magazine;
import org.bshg.librarysystem.services.content.magazine.MagazineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class UpdateMagazineProcessImpl implements UpdateMagazineProcess {
    @Transactional(rollbackFor = Exception.class)
    public Magazine run(Magazine item) { // Your Logic To Update 'Magazine'
        item = service.edit(item);
        return item;
    }

    public List<Magazine> run(List<Magazine> items) {
        items.forEach(this::run);
        return items;
    }

    @Autowired
    private MagazineService service;
}