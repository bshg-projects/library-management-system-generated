package org.bshg.librarysystem.webservice.converter.event;
import org.bshg.librarysystem.entity.core.event.Money;
import org.bshg.librarysystem.webservice.dto.event.MoneyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class MoneyConverter {
protected void convertersConfig(boolean value) {
}
public final MoneyDto toDto(Money item) {
this.convertersConfig(false);
var dto = item != null ? convertToDto(item) : null;
this.convertersConfig(true);
return dto;
}
public final Money toItem(MoneyDto d) {
return d != null ? convertToItem(d) : null;
}
public final List<Money> toItem(List<MoneyDto> dtos) {
if (dtos == null) return null;
List<Money> list = new ArrayList<>();
dtos.forEach(it -> list.add(toItem(it)));
return list;
}
public final List<MoneyDto> toDto(List<Money> items) {
if (items == null) return null;
List<MoneyDto> list = new ArrayList<>();
items.forEach(it -> list.add(toDto(it)));
return list;
}
protected Money convertToItem(MoneyDto dto) {
var item = new Money();
item.setId(dto.getId());
item.setName(dto.getName());
item.setAmount(dto.getAmount());
return item;
}
protected MoneyDto convertToDto(Money item) {
var dto = new MoneyDto();
dto.setId(item.getId());
dto.setName(item.getName());
dto.setAmount(item.getAmount());
return dto;
}
}