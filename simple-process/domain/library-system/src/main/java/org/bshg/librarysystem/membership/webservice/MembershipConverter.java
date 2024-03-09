package org.bshg.librarysystem.membership.webservice;
import org.bshg.librarysystem.membership.Membership;
import org.bshg.librarysystem.membership.webservice.MembershipDto;
import org.bshg.librarysystem.client.webservice.ClientConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class MembershipConverter {
public void init(boolean initialisation) {
this.client = initialisation;
}
@Autowired private ClientConverter clientConverter;
private boolean client = true;
protected void convertersConfig(boolean value) {
}
public final MembershipDto toDto(Membership item) {
this.convertersConfig(false);
var dto = item != null ? convertToDto(item) : null;
this.convertersConfig(true);
return dto;
}
public final Membership toItem(MembershipDto d) {
return d != null ? convertToItem(d) : null;
}
public final List<Membership> toItem(List<MembershipDto> dtos) {
if (dtos == null) return null;
List<Membership> list = new ArrayList<>();
dtos.forEach(it -> list.add(toItem(it)));
return list;
}
public final List<MembershipDto> toDto(List<Membership> items) {
if (items == null) return null;
List<MembershipDto> list = new ArrayList<>();
items.forEach(it -> list.add(toDto(it)));
return list;
}
protected Membership convertToItem(MembershipDto dto) {
var item = new Membership();
item.setId(dto.getId());
item.setName(dto.getName());
item.setStartDate(dto.getStartDate());
item.setEndDate(dto.getEndDate());
item.setStatus(dto.getStatus());
item.setClient(clientConverter.toItem(dto.getClient()));
return item;
}
protected MembershipDto convertToDto(Membership item) {
var dto = new MembershipDto();
dto.setId(item.getId());
dto.setName(item.getName());
dto.setStartDate(item.getStartDate());
dto.setEndDate(item.getEndDate());
dto.setStatus(item.getStatus());
dto.setClient(client? clientConverter.toDto(item.getClient()): null);
return dto;
}
public void setClient(boolean value) {
this.client = value;
}
public void setClientConverter(ClientConverter value) {
this.clientConverter = value;
}
public ClientConverter getClientConverter() {
return clientConverter;
}
}