package org.bshg.librarysystem.webservice.event.transaction;

import org.bshg.librarysystem.entity.core.event.Money;
import org.bshg.librarysystem.entity.core.event.Transaction;
import org.bshg.librarysystem.webservice.event.money.MoneyConverter;
import org.bshg.librarysystem.webservice.event.money.MoneyDto;
import org.bshg.librarysystem.webservice.user.client.ClientConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TransactionConverter {
    @Autowired
    private MoneyConverter moneyConverter;
    @Autowired
    private ClientConverter clientConverter;
    private boolean client = true;

    protected void convertersConfig(boolean value) {
        this.clientConverter.setTransactions(value);
    }

    public final TransactionDto toDto(Transaction item) {
        this.convertersConfig(false);
        var dto = item != null ? convertToDto(item) : null;
        this.convertersConfig(true);
        return dto;
    }

    public final Transaction toItem(TransactionDto d) {
        return d != null ? convertToItem(d) : null;
    }

    public final List<Transaction> toItem(List<TransactionDto> dtos) {
        if (dtos == null) return null;
        List<Transaction> list = new ArrayList<>();
        dtos.forEach(it -> list.add(toItem(it)));
        return list;
    }

    public final List<TransactionDto> toDto(List<Transaction> items) {
        if (items == null) return null;
        List<TransactionDto> list = new ArrayList<>();
        items.forEach(it -> list.add(toDto(it)));
        return list;
    }

    private void convertFromMoney(MoneyDto moneyDto, Transaction item) {
        var moneyItem = moneyConverter.toItem(moneyDto);
        item.setId(moneyItem.getId());
        item.setName(moneyItem.getName());
        item.setAmount(moneyItem.getAmount());
    }

    private void convertFromMoneyDto(Money moneyItem, TransactionDto dto) {
        var moneyDto = moneyConverter.toDto(moneyItem);
        dto.setId(moneyDto.getId());
        dto.setName(moneyDto.getName());
        dto.setAmount(moneyDto.getAmount());
    }

    protected Transaction convertToItem(TransactionDto dto) {
        var item = new Transaction();
        convertFromMoney(dto, item);
        item.setTransactionDate(dto.getTransactionDate());
        item.setClient(clientConverter.toItem(dto.getClient()));
        return item;
    }

    protected TransactionDto convertToDto(Transaction item) {
        var dto = new TransactionDto();
        convertFromMoneyDto(item, dto);
        dto.setTransactionDate(item.getTransactionDate());
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