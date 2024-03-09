package org.bshg.librarysystem.transaction.webservice;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.bshg.librarysystem.money.webservice.MoneyDto;
import org.bshg.librarysystem.client.webservice.ClientDto;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransactionDto extends MoneyDto {
private Long id;
private LocalDate transactionDate;
private ClientDto client;
public Long getId() {
return id;
}
public void setId(Long id) {
this.id = id;
}
public LocalDate getTransactionDate() {
return transactionDate;
}
public void setTransactionDate(LocalDate value) {
this.transactionDate = value;
}
public ClientDto getClient() {
return client;
}
public void setClient(ClientDto value) {
this.client = value;
}
}