package org.bshg.librarysystem.loan.webservice;

import org.bshg.librarysystem.loan.Loan;
import org.bshg.librarysystem.loan.services.LoanService;
import org.bshg.librarysystem.loan.sprocess.create.CreateLoanProcess;
import org.bshg.librarysystem.loan.sprocess.delete.DeleteLoanProcess;
import org.bshg.librarysystem.loan.sprocess.update.UpdateLoanProcess;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loan")
public class LoanRestApi {
    protected LoanService service;
    protected LoanConverter converter;
    protected CreateLoanProcess createProcess;
    protected UpdateLoanProcess updateProcess;
    protected DeleteLoanProcess deleteProcess;

    @GetMapping("/id/{id}")
    public ResponseEntity<LoanDto> findById(@PathVariable Long id) {
        Loan item = service.findById(id);
        if (item == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        converter.init(true);
        LoanDto dto = converter.toDto(item);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<LoanDto>> findAll() {
        List<Loan> all = service.findAll();
        List<LoanDto> dtos = converter.toDto(all);
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/optimized")
    public ResponseEntity<List<LoanDto>> findAllOptimized() {
        List<Loan> all = service.findAllOptimized();
        List<LoanDto> dtos = converter.toDto(all);
        return ResponseEntity.ok(dtos);
    }

    @PostMapping
    public ResponseEntity<LoanDto> save(@RequestBody LoanDto dto) {
        converter.init(true);
        Loan item = converter.toItem(dto);
        item = createProcess.run(item);
        return new ResponseEntity<>(converter.toDto(item), HttpStatus.CREATED);
    }

    @PostMapping("/all")
    public ResponseEntity<List<LoanDto>> save(@RequestBody List<LoanDto> dtos) {
        converter.init(true);
        List<Loan> items = converter.toItem(dtos);
        items = createProcess.run(items);
        return new ResponseEntity<>(converter.toDto(items), HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<LoanDto> update(@RequestBody LoanDto dto) {
        converter.init(true);
        Loan item = converter.toItem(dto);
        item = updateProcess.run(item);
        return ResponseEntity.ok(converter.toDto(item));
    }

    @PutMapping("/all")
    public ResponseEntity<List<LoanDto>> update(@RequestBody List<LoanDto> dtos) {
        converter.init(true);
        List<Loan> items = converter.toItem(dtos);
        items = updateProcess.run(items);
        return ResponseEntity.ok(converter.toDto(items));
    }

    @DeleteMapping
    public ResponseEntity<LoanDto> delete(@RequestBody LoanDto dto) {
        converter.init(false);
        Loan item = converter.toItem(dto);
        deleteProcess.run(item);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/all")
    public ResponseEntity<List<LoanDto>> delete(@RequestBody List<LoanDto> dtos) {
        converter.init(false);
        List<Loan> items = converter.toItem(dtos);
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

    @DeleteMapping("/book/id/{id}")
    public ResponseEntity<Long> deleteByBookId(@PathVariable Long id) {
        service.deleteByBookId(id);
        return ResponseEntity.ok(id);
    }

    @GetMapping("/book/id/{id}")
    public ResponseEntity<LoanDto> findByBookId(@PathVariable Long id) {
        Loan item = service.findByBookId(id);
        LoanDto dto = converter.toDto(item);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/client/id/{id}")
    public ResponseEntity<Long> deleteByClientId(@PathVariable Long id) {
        service.deleteByClientId(id);
        return ResponseEntity.ok(id);
    }

    @GetMapping("/client/id/{id}")
    public ResponseEntity<List<LoanDto>> findByClientId(@PathVariable Long id) {
        List<Loan> items = service.findByClientId(id);
        List<LoanDto> dtos = converter.toDto(items);
        return ResponseEntity.ok(dtos);
    }

    @DeleteMapping("/employee/id/{id}")
    public ResponseEntity<Long> deleteByEmployeeId(@PathVariable Long id) {
        service.deleteByEmployeeId(id);
        return ResponseEntity.ok(id);
    }

    @GetMapping("/employee/id/{id}")
    public ResponseEntity<List<LoanDto>> findByEmployeeId(@PathVariable Long id) {
        List<Loan> items = service.findByEmployeeId(id);
        List<LoanDto> dtos = converter.toDto(items);
        return ResponseEntity.ok(dtos);
    }
}