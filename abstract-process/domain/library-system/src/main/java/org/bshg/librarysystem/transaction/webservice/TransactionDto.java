package org.bshg.librarysystem.transaction.webservice;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.bshg.librarysystem.client.webservice.ClientDto;
import org.bshg.librarysystem.money.webservice.MoneyDto;

import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransactionDto extends MoneyDto {
    public TransactionDto() {
        super();
    }

    private LocalDate transactionDate;
    private ClientDto client;

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