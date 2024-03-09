package org.bshg.librarysystem.payment.webservice;
import org.bshg.librarysystem.payment.Payment;
import org.bshg.librarysystem.payment.webservice.PaymentDto;
import org.bshg.librarysystem.money.webservice.MoneyConverter;
import org.bshg.librarysystem.money.Money;
import org.bshg.librarysystem.money.webservice.MoneyDto;
import org.bshg.librarysystem.client.webservice.ClientConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class PaymentConverter {
@Autowired private MoneyConverter moneyConverter;
public void init(boolean initialisation) {
this.client = initialisation;
}
@Autowired private ClientConverter clientConverter;
private boolean client = true;
protected void convertersConfig(boolean value) {
this.clientConverter.setPayments(value);
}
public final PaymentDto toDto(Payment item) {
this.convertersConfig(false);
var dto = item != null ? convertToDto(item) : null;
this.convertersConfig(true);
return dto;
}
public final Payment toItem(PaymentDto d) {
return d != null ? convertToItem(d) : null;
}
public final List<Payment> toItem(List<PaymentDto> dtos) {
if (dtos == null) return null;
List<Payment> list = new ArrayList<>();
dtos.forEach(it -> list.add(toItem(it)));
return list;
}
public final List<PaymentDto> toDto(List<Payment> items) {
if (items == null) return null;
List<PaymentDto> list = new ArrayList<>();
items.forEach(it -> list.add(toDto(it)));
return list;
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
protected Payment convertToItem(PaymentDto dto) {
var item = new Payment();
convertFromMoney(dto, item);
item.setPaymentDate(dto.getPaymentDate());
item.setClient(clientConverter.toItem(dto.getClient()));
return item;
}
protected PaymentDto convertToDto(Payment item) {
var dto = new PaymentDto();
convertFromMoneyDto(item, dto);
dto.setPaymentDate(item.getPaymentDate());
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