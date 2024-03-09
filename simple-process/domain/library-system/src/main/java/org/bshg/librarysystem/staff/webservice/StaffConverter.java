package org.bshg.librarysystem.staff.webservice;
import org.bshg.librarysystem.staff.Staff;
import org.bshg.librarysystem.staff.webservice.StaffDto;
import org.bshg.librarysystem.mySecurity.ws.converter.UserConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class StaffConverter {
@Autowired private UserConverter userConverter;
public void init(boolean initialisation) {
}
protected void convertersConfig(boolean value) {
}
public final StaffDto toDto(Staff item) {
this.convertersConfig(false);
var dto = item != null ? convertToDto(item) : null;
this.convertersConfig(true);
return dto;
}
public final Staff toItem(StaffDto d) {
return d != null ? convertToItem(d) : null;
}
public final List<Staff> toItem(List<StaffDto> dtos) {
if (dtos == null) return null;
List<Staff> list = new ArrayList<>();
dtos.forEach(it -> list.add(toItem(it)));
return list;
}
public final List<StaffDto> toDto(List<Staff> items) {
if (items == null) return null;
List<StaffDto> list = new ArrayList<>();
items.forEach(it -> list.add(toDto(it)));
return list;
}
protected Staff convertToItem(StaffDto dto) {
var item = new Staff();
userConverter.convertToChildItem(dto, item);
item.setFirstName(dto.getFirstName());
item.setLastName(dto.getLastName());
item.setPosition(dto.getPosition());
item.setSalary(dto.getSalary());
return item;
}
protected StaffDto convertToDto(Staff item) {
var dto = new StaffDto();
userConverter.convertToChildDto(item, dto);
dto.setFirstName(item.getFirstName());
dto.setLastName(item.getLastName());
dto.setPosition(item.getPosition());
dto.setSalary(item.getSalary());
return dto;
}
}