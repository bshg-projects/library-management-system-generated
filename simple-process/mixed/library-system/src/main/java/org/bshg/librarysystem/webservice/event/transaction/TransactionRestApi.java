package org.bshg.librarysystem.webservice.event.transaction;

import org.bshg.librarysystem.entity.core.event.Transaction;
import org.bshg.librarysystem.services.event.transaction.TransactionService;
import org.bshg.librarysystem.sprocess.event.transaction.create.CreateTransactionProcess;
import org.bshg.librarysystem.sprocess.event.transaction.delete.DeleteTransactionProcess;
import org.bshg.librarysystem.sprocess.event.transaction.update.UpdateTransactionProcess;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transaction")
public class TransactionRestApi {
    protected TransactionService service;
    protected TransactionConverter converter;
    protected CreateTransactionProcess createProcess;
    protected UpdateTransactionProcess updateProcess;
    protected DeleteTransactionProcess deleteProcess;

    @GetMapping("/id/{id}")
    public ResponseEntity<TransactionDto> findById(@PathVariable Long id) {
        Transaction item = service.findById(id);
        if (item == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        converter.init(true);
        TransactionDto dto = converter.toDto(item);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<TransactionDto>> findAll() {
        List<Transaction> all = service.findAll();
        List<TransactionDto> dtos = converter.toDto(all);
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/optimized")
    public ResponseEntity<List<TransactionDto>> findAllOptimized() {
        List<Transaction> all = service.findAllOptimized();
        List<TransactionDto> dtos = converter.toDto(all);
        return ResponseEntity.ok(dtos);
    }

    @PostMapping
    public ResponseEntity<TransactionDto> save(@RequestBody TransactionDto dto) {
        converter.init(true);
        Transaction item = converter.toItem(dto);
        item = createProcess.run(item);
        return new ResponseEntity<>(converter.toDto(item), HttpStatus.CREATED);
    }

    @PostMapping("/all")
    public ResponseEntity<List<TransactionDto>> save(@RequestBody List<TransactionDto> dtos) {
        converter.init(true);
        List<Transaction> items = converter.toItem(dtos);
        items = createProcess.run(items);
        return new ResponseEntity<>(converter.toDto(items), HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<TransactionDto> update(@RequestBody TransactionDto dto) {
        converter.init(true);
        Transaction item = converter.toItem(dto);
        item = updateProcess.run(item);
        return ResponseEntity.ok(converter.toDto(item));
    }

    @PutMapping("/all")
    public ResponseEntity<List<TransactionDto>> update(@RequestBody List<TransactionDto> dtos) {
        converter.init(true);
        List<Transaction> items = converter.toItem(dtos);
        items = updateProcess.run(items);
        return ResponseEntity.ok(converter.toDto(items));
    }

    @DeleteMapping
    public ResponseEntity<TransactionDto> delete(@RequestBody TransactionDto dto) {
        converter.init(false);
        Transaction item = converter.toItem(dto);
        deleteProcess.run(item);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/all")
    public ResponseEntity<List<TransactionDto>> delete(@RequestBody List<TransactionDto> dtos) {
        converter.init(false);
        List<Transaction> items = converter.toItem(dtos);
        deleteProcess.run(items);
        return ResponseEntity.ok(dtos);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) {
        deleteProcess.run(id);
        return ResponseEntity.ok(id);
    }

    @DeleteMapping("/ids")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestParam("id") List<Long> ids) {
        deleteProcess.runByIds(ids);
        return ResponseEntity.ok(ids);
    }

    @DeleteMapping("/client/id/{id}")
    public ResponseEntity<Long> deleteByClientId(@PathVariable Long id) {
        service.deleteByClientId(id);
        return ResponseEntity.ok(id);
    }

    @GetMapping("/client/id/{id}")
    public ResponseEntity<List<TransactionDto>> findByClientId(@PathVariable Long id) {
        List<Transaction> items = service.findByClientId(id);
        List<TransactionDto> dtos = converter.toDto(items);
        return ResponseEntity.ok(dtos);
    }
}