package org.bshg.librarysystem.webservice.event.payment;

import org.bshg.librarysystem.entity.core.event.Money;
import org.bshg.librarysystem.entity.core.event.Payment;
import org.bshg.librarysystem.utils.webservice.converter.AbstractConverter;
import org.bshg.librarysystem.webservice.event.money.MoneyConverter;
import org.bshg.librarysystem.webservice.event.money.MoneyDto;
import org.bshg.librarysystem.webservice.user.client.ClientConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentConverter extends AbstractConverter<Payment, PaymentDto> {
    @Autowired
    private MoneyConverter moneyConverter;
    @Autowired
    private ClientConverter clientConverter;
    private boolean client = true;

    @Override
    protected void convertersConfig(boolean value) {
        this.clientConverter.setPayments(value);
    }

    private void convertFromMoney(MoneyDto moneyDto, Payment item) {
        var moneyItem = moneyConverter.toItem(moneyDto);
        item.setId(moneyItem.getId());
        item.setName(moneyItem.getName());
        item.setAmount(moneyItem.getAmount());
    }

    private void convertFromMoneyDto(Money moneyItem, PaymentDto dto) {
        var moneyDto = moneyConverter.toDto(moneyItem);
        dto.setId(moneyDto.getId());
        dto.setName(moneyDto.getName());
        dto.setAmount(moneyDto.getAmount());
    }

    @Override
    protected Payment convertToItem(PaymentDto dto) {
        var item = new Payment();
        convertFromMoney(dto, item);
        item.setPaymentDate(dto.getPaymentDate());
        item.setClient(clientConverter.toItem(dto.getClient()));
        return item;
    }

    @Override
    protected PaymentDto convertToDto(Payment item) {
        var dto = new PaymentDto();
        convertFromMoneyDto(item, dto);
        dto.setPaymentDate(item.getPaymentDate());
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