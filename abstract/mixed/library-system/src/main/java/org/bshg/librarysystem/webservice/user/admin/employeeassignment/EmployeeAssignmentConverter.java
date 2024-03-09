package org.bshg.librarysystem.webservice.user.admin.employeeassignment;
import org.bshg.librarysystem.entity.core.user.admin.EmployeeAssignment;
import org.bshg.librarysystem.webservice.user.admin.employeeassignment.EmployeeAssignmentDto;
import org.bshg.librarysystem.webservice.user.admin.admin.AdminConverter;
import org.bshg.librarysystem.webservice.user.admin.employee.EmployeeConverter;
import org.bshg.librarysystem.utils.webservice.converter.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class EmployeeAssignmentConverter extends AbstractConverter<EmployeeAssignment, EmployeeAssignmentDto> {
@Autowired private EmployeeConverter employeeConverter;
@Autowired private AdminConverter adminConverter;
private boolean admin = true;
private boolean employee = true;
@Override
protected void config() {
config(EmployeeAssignment.class, EmployeeAssignmentDto.class);
}
@Override
protected void convertersConfig(boolean value) {
this.employeeConverter.setEmployeeAssignment(value);
this.adminConverter.setEmployeeAssignment(value);
}
@Override
protected EmployeeAssignment convertToItem(EmployeeAssignmentDto dto) {
var item = new EmployeeAssignment();
item.setId(dto.getId());
item.setAssignmentRole(dto.getAssignmentRole());
item.setStartDate(dto.getStartDate());
item.setEndDate(dto.getEndDate());
item.setIsActive(dto.isIsActive());
item.setAdmin(adminConverter.toItem(dto.getAdmin()));
item.setEmployee(employeeConverter.toItem(dto.getEmployee()));
return item;
}
@Override
protected EmployeeAssignmentDto convertToDto(EmployeeAssignment item) {
var dto = new EmployeeAssignmentDto();
dto.setId(item.getId());
dto.setAssignmentRole(item.getAssignmentRole());
dto.setStartDate(item.getStartDate());
dto.setEndDate(item.getEndDate());
dto.setIsActive(item.isIsActive());
dto.setAdmin(admin? adminConverter.toDto(item.getAdmin()): null);
dto.setEmployee(employee? employeeConverter.toDto(item.getEmployee()): null);
return dto;
}
public void setAdmin(boolean value) {
this.admin = value;
}
public void setEmployee(boolean value) {
this.employee = value;
}
public void setEmployeeConverter(EmployeeConverter value) {
this.employeeConverter = value;
}
public EmployeeConverter getEmployeeConverter() {
return employeeConverter;
}
public void setAdminConverter(AdminConverter value) {
this.adminConverter = value;
}
public AdminConverter getAdminConverter() {
return adminConverter;
}
}