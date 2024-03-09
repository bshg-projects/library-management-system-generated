package org.bshg.librarysystem.webservice.event.payment;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.bshg.librarysystem.webservice.event.money.MoneyDto;
import org.bshg.librarysystem.webservice.user.client.ClientDto;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentDto extends MoneyDto {
public PaymentDto() {
super();
}
private LocalDate paymentDate;
private ClientDto client;
public LocalDate getPaymentDate() {
return paymentDate;
}
public void setPaymentDate(LocalDate value) {
this.paymentDate = value;
}
public ClientDto getClient() {
return client;
}
public void setClient(ClientDto value) {
this.client = value;
}
}