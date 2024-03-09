package org.bshg.librarysystem.shelf.sprocess;
import org.bshg.librarysystem.shelf.services.ShelfService;
import org.bshg.librarysystem.shelf.sprocess.create.CreateShelfProcess;
import org.bshg.librarysystem.shelf.sprocess.update.UpdateShelfProcess;
import org.bshg.librarysystem.shelf.sprocess.delete.DeleteShelfProcess;
import org.bshg.librarysystem.shelf.sprocess.create.CreateShelfProcessImpl;
import org.bshg.librarysystem.shelf.sprocess.update.UpdateShelfProcessImpl;
import org.bshg.librarysystem.shelf.sprocess.delete.DeleteShelfProcessImpl;
import org.bshg.librarysystem.rack.services.RackService;
import org.bshg.librarysystem.rack.sprocess.create.CreateRackProcess;
import org.bshg.librarysystem.rack.sprocess.update.UpdateRackProcess;
import org.bshg.librarysystem.rack.sprocess.delete.DeleteRackProcess;
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