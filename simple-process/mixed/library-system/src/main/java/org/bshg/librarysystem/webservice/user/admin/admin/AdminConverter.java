package org.bshg.librarysystem.webservice.user.admin.admin;

import org.bshg.librarysystem.entity.core.user.admin.Admin;
import org.bshg.librarysystem.mySecurity.ws.converter.UserConverter;
import org.bshg.librarysystem.webservice.user.admin.employeeassignment.EmployeeAssignmentConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AdminConverter {
    @Autowired
    private UserConverter userConverter;

    public void init(boolean initialisation) {
        this.employeeAssignment = initialisation;
    }

    @Autowired
    private EmployeeAssignmentConverter employeeAssignmentConverter;
    private boolean employeeAssignment = true;

    protected void convertersConfig(boolean value) {
        this.employeeAssignmentConverter.setAdmin(value);
    }

    public final AdminDto toDto(Admin item) {
        this.convertersConfig(false);
        var dto = item != null ? convertToDto(item) : null;
        this.convertersConfig(true);
        return dto;
    }

    public final Admin toItem(AdminDto d) {
        return d != null ? convertToItem(d) : null;
    }

    public final List<Admin> toItem(List<AdminDto> dtos) {
        if (dtos == null) return null;
        List<Admin> list = new ArrayList<>();
        dtos.forEach(it -> list.add(toItem(it)));
        return list;
    }

    public final List<AdminDto> toDto(List<Admin> items) {
        if (items == null) return null;
        List<AdminDto> list = new ArrayList<>();
        items.forEach(it -> list.add(toDto(it)));
        return list;
    }

    protected Admin convertToItem(AdminDto dto) {
        var item = new Admin();
        userConverter.convertToChildItem(dto, item);
        item.setFirstName(dto.getFirstName());
        item.setLastName(dto.getLastName());
        item.setEmployeeAssignment(employeeAssignmentConverter.toItem(dto.getEmployeeAssignment()));
        return item;
    }

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