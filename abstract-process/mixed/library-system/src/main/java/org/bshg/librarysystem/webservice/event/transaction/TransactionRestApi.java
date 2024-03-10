package org.bshg.librarysystem.webservice.event.transaction;

import org.bshg.librarysystem.entity.core.event.Transaction;
import org.bshg.librarysystem.services.event.transaction.TransactionService;
import org.bshg.librarysystem.sprocess.event.transaction.create.CreateTransactionProcess;
import org.bshg.librarysystem.sprocess.event.transaction.delete.DeleteTransactionProcess;
import org.bshg.librarysystem.sprocess.event.transaction.update.UpdateTransactionProcess;
import org.bshg.librarysystem.utils.webservice.restapi.AbstractRestApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transaction")
public class TransactionRestApi extends AbstractRestApi<
        Transaction,
        TransactionDto,
        TransactionService,
        TransactionConverter,
        CreateTransactionProcess,
        UpdateTransactionProcess,
        DeleteTransactionProcess> {
    public TransactionRestApi(TransactionService service, TransactionConverter converter, CreateTransactionProcess createProcess, UpdateTransactionProcess updateProcess, DeleteTransactionProcess deleteProcess) {
        super(service, converter, createProcess, updateProcess, deleteProcess);
    }

    @Override
    @GetMapping("/id/{id}")
    public ResponseEntity<TransactionDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<TransactionDto>> findAll() {
        return super.findAll();
    }

    @Override
    @GetMapping("/optimized")
    public ResponseEntity<List<TransactionDto>> findAllOptimized() {
        return super.findAllOptimized();
    }

    @Override
    @PostMapping
    public ResponseEntity<TransactionDto> save(@RequestBody TransactionDto dto) {
        return super.save(dto);
    }

    @Override
    @PostMapping("/all")
    public ResponseEntity<List<TransactionDto>> save(@RequestBody List<TransactionDto> dtos) {
        return super.save(dtos);
    }

    @Override
    @PutMapping()
    public ResponseEntity<TransactionDto> update(@RequestBody TransactionDto dto) {
        return super.update(dto);
    }

    @Override
    @PutMapping("/all")
    public ResponseEntity<List<TransactionDto>> update(@RequestBody List<TransactionDto> dtos) {
        return super.update(dtos);
    }

    @Override
    @DeleteMapping
    public ResponseEntity<TransactionDto> delete(@RequestBody TransactionDto dto) {
        return super.delete(dto);
    }

    @Override
    @DeleteMapping("/all")
    public ResponseEntity<List<TransactionDto>> delete(@RequestBody List<TransactionDto> dtos) {
        return super.delete(dtos);
    }

    @Override
    @DeleteMapping("/id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) {
        return super.deleteById(id);
    }

    @Override
    @DeleteMapping("/ids")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestParam("id") List<Long> ids) {
        return super.deleteByIdIn(ids);
    }

    @DeleteMapping("/client/id/{id}")
    public ResponseEntity<Long> deleteByClientId(@PathVariable Long id) {
        return super.deleteProcess(id, service::deleteByClientId);
    }

    @GetMapping("/client/id/{id}")
    public ResponseEntity<List<TransactionDto>> findByClientId(@PathVariable Long id) {
        return super.findListByChildId(id, service::findByClientId);
    }
}