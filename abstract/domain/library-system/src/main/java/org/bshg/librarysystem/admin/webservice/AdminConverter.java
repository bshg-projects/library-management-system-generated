package org.bshg.librarysystem.admin.webservice;

import org.bshg.librarysystem.admin.Admin;
import org.bshg.librarysystem.employeeassignment.webservice.EmployeeAssignmentConverter;
import org.bshg.librarysystem.mySecurity.ws.converter.UserConverter;
import org.bshg.librarysystem.utils.webservice.converter.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdminConverter extends AbstractConverter<Admin, AdminDto> {
    @Autowired
    private UserConverter userConverter;
    @Autowired
    private EmployeeAssignmentConverter employeeAssignmentConverter;
    private boolean employeeAssignment = true;

    @Override
    protected void config() {
        config(Admin.class, AdminDto.class);
    }

    @Override
    protected void convertersConfig(boolean value) {
        this.employeeAssignmentConverter.setAdmin(value);
    }

    @Override
    protected Admin convertToItem(AdminDto dto) {
        var item = new Admin();
        userConverter.convertToChildItem(dto, item);
        item.setFirstName(dto.getFirstName());
        item.setLastName(dto.getLastName());
        item.setEmployeeAssignment(employeeAssignmentConverter.toItem(dto.getEmployeeAssignment()));
        return item;
    }

    @Override
    protected AdminDto convertToDto(Admin item) {
        var dto = new AdminDto();
        userConverter.convertToChildDto(item, dto);
        dto.setFirstName(item.getFirstName());
        dto.setLastName(item.getLastName());
        dto.setEmployeeAssignment(employeeAssignment ? employeeAssignmentConverter.toDto(item.getEmployeeAssignment()) : null);
        return dto;
    }

    public void setEmployeeAssignment(boolean value) {
        this.employeeAssignment = value;
    }

    public void setEmployeeAssignmentConverter(EmployeeAssignmentConverter value) {
        this.employeeAssignmentConverter = value;
    }

    public EmployeeAssignmentConverter getEmployeeAssignmentConverter() {
        return employeeAssignmentConverter;
    }
}