package org.bshg.librarysystem.sprocess.user.staff;

import org.bshg.librarysystem.services.user.staff.StaffService;
import org.bshg.librarysystem.sprocess.user.staff.create.CreateStaffProcess;
import org.bshg.librarysystem.sprocess.user.staff.create.CreateStaffProcessImpl;
import org.bshg.librarysystem.sprocess.user.staff.delete.DeleteStaffProcess;
import org.bshg.librarysystem.sprocess.user.staff.delete.DeleteStaffProcessImpl;
import org.bshg.librarysystem.sprocess.user.staff.update.UpdateStaffProcess;
import org.bshg.librarysystem.sprocess.user.staff.update.UpdateStaffProcessImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Inject Staff Processes (Create, Update, Delete).
 */
@Configuration
public class StaffInjector {
    @Bean
    public CreateStaffProcess createStaffProcess(StaffService service) {
        var bean = new CreateStaffProcessImpl(service);
        return bean;
    }

    @Bean
    public UpdateStaffProcess updateStaffProcess(StaffService service) {
        var bean = new UpdateStaffProcessImpl(service);
        return bean;
    }

    @Bean
    public DeleteStaffProcess deleteStaffProcess(StaffService service) {
        var bean = new DeleteStaffProcessImpl(service);
        return bean;
    }
}