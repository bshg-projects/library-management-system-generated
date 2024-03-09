package org.bshg.librarysystem.sprocess.storage.shelf;
import org.bshg.librarysystem.services.facade.storage.ShelfService;
import org.bshg.librarysystem.sprocess.storage.shelf.facade.CreateShelfProcess;
import org.bshg.librarysystem.sprocess.storage.shelf.facade.UpdateShelfProcess;
import org.bshg.librarysystem.sprocess.storage.shelf.facade.DeleteShelfProcess;
import org.bshg.librarysystem.sprocess.storage.shelf.impl.CreateShelfProcessImpl;
import org.bshg.librarysystem.sprocess.storage.shelf.impl.UpdateShelfProcessImpl;
import org.bshg.librarysystem.sprocess.storage.shelf.impl.DeleteShelfProcessImpl;
import org.bshg.librarysystem.services.facade.storage.RackService;
import org.bshg.librarysystem.sprocess.storage.rack.facade.CreateRackProcess;
import org.bshg.librarysystem.sprocess.storage.rack.facade.UpdateRackProcess;
import org.bshg.librarysystem.sprocess.storage.rack.facade.DeleteRackProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
* Inject Shelf Processes (Create, Update, Delete).
*/
@Configuration
public class ShelfInjector {
@Bean
public CreateShelfProcess createShelfProcess (ShelfService service,RackService rackService) {
var bean = new CreateShelfProcessImpl(service, rackService);
bean.setCreateRackProcess(this.createRackProcess);
return bean;
}
@Bean
public UpdateShelfProcess updateShelfProcess (ShelfService service,RackService rackService) {
var bean = new UpdateShelfProcessImpl(service,rackService);
bean.setUpdateRackProcess(this.updateRackProcess);
bean.setDeleteRackProcess(this.deleteRackProcess);
return bean;
}
@Bean
public DeleteShelfProcess deleteShelfProcess(ShelfService service,RackService rackService) {
var bean = new DeleteShelfProcessImpl(service,rackService);
bean.setDeleteRackProcess(this.deleteRackProcess);
return bean;
}
@Autowired @Lazy private CreateRackProcess createRackProcess;
@Autowired @Lazy private UpdateRackProcess updateRackProcess;
@Autowired @Lazy private DeleteRackProcess deleteRackProcess;
}