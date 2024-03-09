package org.bshg.librarysystem.webservice.event.transaction;
import org.bshg.librarysystem.entity.core.event.Transaction;
import org.bshg.librarysystem.webservice.event.transaction.TransactionDto;
import org.bshg.librarysystem.webservice.event.money.MoneyConverter;
import org.bshg.librarysystem.entity.core.event.Money;
import org.bshg.librarysystem.webservice.event.money.MoneyDto;
import org.bshg.librarysystem.webservice.user.client.ClientConverter;
import org.bshg.librarysystem.utils.webservice.converter.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class TransactionConverter extends AbstractConverter<Transaction, TransactionDto> {
@Autowired private MoneyConverter moneyConverter;
@Autowired private ClientConverter clientConverter;
private boolean client = true;
@Override
protected void convertersConfig(boolean value) {
this.clientConverter.setTransactions(value);
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
@Override
protected Transaction convertToItem(TransactionDto dto) {
var item = new Transaction();
convertFromMoney(dto, item);
item.setTransactionDate(dto.getTransactionDate());
item.setClient(clientConverter.toItem(dto.getClient()));
return item;
}
@Override
protected TransactionDto convertToDto(Transaction item) {
var dto = new TransactionDto();
convertFromMoneyDto(item, dto);
dto.setTransactionDate(item.getTransactionDate());
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