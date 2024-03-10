package org.bshg.librarysystem.sprocess.user.staff;

import org.bshg.librarysystem.services.facade.user.StaffService;
import org.bshg.librarysystem.sprocess.user.staff.facade.CreateStaffProcess;
import org.bshg.librarysystem.sprocess.user.staff.facade.DeleteStaffProcess;
import org.bshg.librarysystem.sprocess.user.staff.facade.UpdateStaffProcess;
import org.bshg.librarysystem.sprocess.user.staff.impl.CreateStaffProcessImpl;
import org.bshg.librarysystem.sprocess.user.staff.impl.DeleteStaffProcessImpl;
import org.bshg.librarysystem.sprocess.user.staff.impl.UpdateStaffProcessImpl;
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