package org.bshg.librarysystem.sprocess.storage.shelf;

import org.bshg.librarysystem.services.storage.rack.RackService;
import org.bshg.librarysystem.services.storage.shelf.ShelfService;
import org.bshg.librarysystem.sprocess.storage.rack.create.CreateRackProcess;
import org.bshg.librarysystem.sprocess.storage.rack.delete.DeleteRackProcess;
import org.bshg.librarysystem.sprocess.storage.rack.update.UpdateRackProcess;
import org.bshg.librarysystem.sprocess.storage.shelf.create.CreateShelfProcess;
import org.bshg.librarysystem.sprocess.storage.shelf.create.CreateShelfProcessImpl;
import org.bshg.librarysystem.sprocess.storage.shelf.delete.DeleteShelfProcess;
import org.bshg.librarysystem.sprocess.storage.shelf.delete.DeleteShelfProcessImpl;
import org.bshg.librarysystem.sprocess.storage.shelf.update.UpdateShelfProcess;
import org.bshg.librarysystem.sprocess.storage.shelf.update.UpdateShelfProcessImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * Inject Shelf Processes (Create, Update, Delete).
 */
@Configuration
public class ShelfInjector {
    @Bean
    public CreateShelfProcess createShelfProcess(ShelfService service, RackService rackService) {
        var bean = new CreateShelfProcessImpl(service, rackService);
        bean.setCreateRackProcess(this.createRackProcess);
        return bean;
    }

    @Bean
    public UpdateShelfProcess updateShelfProcess(ShelfService service, RackService rackService) {
        var bean = new UpdateShelfProcessImpl(service, rackService);
        bean.setUpdateRackProcess(this.updateRackProcess);
        bean.setDeleteRackProcess(this.deleteRackProcess);
        return bean;
    }

    @Bean
    public DeleteShelfProcess deleteShelfProcess(ShelfService service, RackService rackService) {
        var bean = new DeleteShelfProcessImpl(service, rackService);
        bean.setDeleteRackProcess(this.deleteRackProcess);
        return bean;
    }

    @Autowired
    @Lazy
    private CreateRackProcess createRackProcess;
    @Autowired
    @Lazy
    private UpdateRackProcess updateRackProcess;
    @Autowired
    @Lazy
    private DeleteRackProcess deleteRackProcess;
}