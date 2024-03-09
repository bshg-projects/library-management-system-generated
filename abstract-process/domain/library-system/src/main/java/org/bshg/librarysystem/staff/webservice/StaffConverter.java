package org.bshg.librarysystem.staff.webservice;
import org.bshg.librarysystem.staff.Staff;
import org.bshg.librarysystem.staff.webservice.StaffDto;
import org.bshg.librarysystem.mySecurity.ws.converter.UserConverter;
import org.bshg.librarysystem.utils.webservice.converter.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class StaffConverter extends AbstractConverter<Staff, StaffDto> {
@Autowired private UserConverter userConverter;
@Override
protected Staff convertToItem(StaffDto dto) {
var item = new Staff();
userConverter.convertToChildItem(dto, item);
item.setFirstName(dto.getFirstName());
item.setLastName(dto.getLastName());
item.setPosition(dto.getPosition());
item.setSalary(dto.getSalary());
return item;
}
@Override
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