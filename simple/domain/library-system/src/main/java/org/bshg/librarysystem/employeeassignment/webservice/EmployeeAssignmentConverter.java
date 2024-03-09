package org.bshg.librarysystem.employeeassignment.webservice;
import org.bshg.librarysystem.employeeassignment.EmployeeAssignment;
import org.bshg.librarysystem.employeeassignment.webservice.EmployeeAssignmentDto;
import org.bshg.librarysystem.admin.webservice.AdminConverter;
import org.bshg.librarysystem.employee.webservice.EmployeeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class EmployeeAssignmentConverter {
@Autowired private EmployeeConverter employeeConverter;
@Autowired private AdminConverter adminConverter;
private boolean admin = true;
private boolean employee = true;
protected void convertersConfig(boolean value) {
this.employeeConverter.setEmployeeAssignment(value);
this.adminConverter.setEmployeeAssignment(value);
}
public final EmployeeAssignmentDto toDto(EmployeeAssignment item) {
this.convertersConfig(false);
var dto = item != null ? convertToDto(item) : null;
this.convertersConfig(true);
return dto;
}
public final EmployeeAssignment toItem(EmployeeAssignmentDto d) {
return d != null ? convertToItem(d) : null;
}
public final List<EmployeeAssignment> toItem(List<EmployeeAssignmentDto> dtos) {
if (dtos == null) return null;
List<EmployeeAssignment> list = new ArrayList<>();
dtos.forEach(it -> list.add(toItem(it)));
return list;
}
public final List<EmployeeAssignmentDto> toDto(List<EmployeeAssignment> items) {
if (items == null) return null;
List<EmployeeAssignmentDto> list = new ArrayList<>();
items.forEach(it -> list.add(toDto(it)));
return list;
}
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