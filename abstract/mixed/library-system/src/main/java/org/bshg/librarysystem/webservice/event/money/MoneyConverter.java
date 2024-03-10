package org.bshg.librarysystem.webservice.event.money;

import org.bshg.librarysystem.entity.core.event.Money;
import org.bshg.librarysystem.utils.webservice.converter.AbstractConverter;
import org.springframework.stereotype.Component;

@Component
public class MoneyConverter extends AbstractConverter<Money, MoneyDto> {
    @Override
    protected void config() {
        config(Money.class, MoneyDto.class);
    }

    @Override
    protected Money convertToItem(MoneyDto dto) {
        var item = new Money();
        item.setId(dto.getId());
        item.setName(dto.getName());
        item.setAmount(dto.getAmount());
        return item;
    }

    @Override
    protected MoneyDto convertToDto(Money item) {
        var dto = new MoneyDto();
        dto.setId(item.getId());
        dto.setName(item.getName());
        dto.setAmount(item.getAmount());
        return dto;
    }
}