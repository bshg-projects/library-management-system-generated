package org.bshg.librarysystem.webservice.converter.library;

import org.bshg.librarysystem.entity.core.library.Membership;
import org.bshg.librarysystem.utils.webservice.converter.AbstractConverter;
import org.bshg.librarysystem.webservice.converter.user.ClientConverter;
import org.bshg.librarysystem.webservice.dto.library.MembershipDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MembershipConverter extends AbstractConverter<Membership, MembershipDto> {
    @Autowired
    private ClientConverter clientConverter;
    private boolean client = true;

    @Override
    protected void convertersConfig(boolean value) {
    }

    @Override
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

    @Override
    protected MembershipDto convertToDto(Membership item) {
        var dto = new MembershipDto();
        dto.setId(item.getId());
        dto.setName(item.getName());
        dto.setStartDate(item.getStartDate());
        dto.setEndDate(item.getEndDate());
        dto.setStatus(item.getStatus());
        dto.setClient(client ? clientConverter.toDto(item.getClient()) : null);
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