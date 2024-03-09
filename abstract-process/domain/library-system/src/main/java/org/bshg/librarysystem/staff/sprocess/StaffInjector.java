package org.bshg.librarysystem.staff.sprocess;
import org.bshg.librarysystem.staff.services.StaffService;
import org.bshg.librarysystem.staff.sprocess.create.CreateStaffProcess;
import org.bshg.librarysystem.staff.sprocess.update.UpdateStaffProcess;
import org.bshg.librarysystem.staff.sprocess.delete.DeleteStaffProcess;
import org.bshg.librarysystem.staff.sprocess.create.CreateStaffProcessImpl;
import org.bshg.librarysystem.staff.sprocess.update.UpdateStaffProcessImpl;
import org.bshg.librarysystem.staff.sprocess.delete.DeleteStaffProcessImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
* Inject Staff Processes (Create, Update, Delete).
*/
@Configuration
public class StaffInjector {
@Bean
public CreateStaffProcess createStaffProcess (StaffService service) {
var bean = new CreateStaffProcessImpl(service);
return bean;
}
@Bean
public UpdateStaffProcess updateStaffProcess (StaffService service) {
var bean = new UpdateStaffProcessImpl(service);
return bean;
}
@Bean
public DeleteStaffProcess deleteStaffProcess(StaffService service) {
var bean = new DeleteStaffProcessImpl(service);
return bean;
}
}