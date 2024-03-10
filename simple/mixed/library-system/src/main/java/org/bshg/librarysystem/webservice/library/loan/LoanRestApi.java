package org.bshg.librarysystem.webservice.library.loan;

import org.bshg.librarysystem.services.library.loan.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loan")
public class LoanRestApi {
    @Autowired
    private LoanService service;
    @Autowired
    private LoanConverter converter;

    @GetMapping("/id/{id}")
    public ResponseEntity<LoanDto> findById(@PathVariable Long id) {
        var result = service.findById(id);
        var resultDto = converter.toDto(result);
        return ResponseEntity.ok(resultDto);
    }

    @GetMapping
    public ResponseEntity<List<LoanDto>> findAll() {
        var result = service.findAll();
        var resultDto = converter.toDto(result);
        return ResponseEntity.ok(resultDto);
    }

    @GetMapping("/optimized")
    public ResponseEntity<List<LoanDto>> findAllOptimized() {
        var result = service.findAllOptimized();
        var resultDto = converter.toDto(result);
        return ResponseEntity.ok(resultDto);
    }

    @PostMapping
    public ResponseEntity<LoanDto> save(@RequestBody LoanDto dto) {
        if (dto == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
        var item = converter.toItem(dto);
        var result = service.create(item);
        var resultDto = converter.toDto(result);
        return ResponseEntity.ok(resultDto);
    }

    @PostMapping("/all")
    public ResponseEntity<List<LoanDto>> save(@RequestBody List<LoanDto> dtos) {
        if (dtos == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
        var item = converter.toItem(dtos);
        var result = service.create(item);
        var resultDto = converter.toDto(result);
        return ResponseEntity.ok(resultDto);
    }

    @PutMapping()
    public ResponseEntity<LoanDto> update(@RequestBody LoanDto dto) {
        if (dto == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
        var item = converter.toItem(dto);
        var result = service.update(item);
        var resultDto = converter.toDto(result);
        return ResponseEntity.ok(resultDto);
    }

    @PutMapping("/all")
    public ResponseEntity<List<LoanDto>> update(@RequestBody List<LoanDto> dtos) {
        if (dtos == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
        var item = converter.toItem(dtos);
        var result = service.update(item);
        var resultDto = converter.toDto(result);
        return ResponseEntity.ok(resultDto);
    }

    @DeleteMapping
    public ResponseEntity<LoanDto> delete(@RequestBody LoanDto dto) {
        if (dto == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
        var item = converter.toItem(dto);
        service.delete(item);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/all")
    public ResponseEntity<List<LoanDto>> delete(@RequestBody List<LoanDto> dtos) {
        if (dtos == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
        var item = converter.toItem(dtos);
        service.delete(item);
        return ResponseEntity.ok(dtos);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.ok(id);
    }

    @DeleteMapping("/ids")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestParam("id") List<Long> ids) {
        service.deleteByIdIn(ids);
        return ResponseEntity.ok(ids);
    }

    @DeleteMapping("/book/id/{id}")
    public ResponseEntity<Long> deleteByBookId(@PathVariable Long id) {
        service.deleteByBookId(id);
        return ResponseEntity.ok(id);
    }

    @GetMapping("/book/id/{id}")
    public ResponseEntity<LoanDto> findByBookId(@PathVariable Long id) {
        var result = service.findByBookId(id);
        var resultDto = converter.toDto(result);
        return ResponseEntity.ok(resultDto);
    }

    @DeleteMapping("/client/id/{id}")
    public ResponseEntity<Long> deleteByClientId(@PathVariable Long id) {
        service.deleteByClientId(id);
        return ResponseEntity.ok(id);
    }

    @GetMapping("/client/id/{id}")
    public ResponseEntity<List<LoanDto>> findByClientId(@PathVariable Long id) {
        var result = service.findByClientId(id);
        var resultDto = converter.toDto(result);
        return ResponseEntity.ok(resultDto);
    }

    @DeleteMapping("/employee/id/{id}")
    public ResponseEntity<Long> deleteByEmployeeId(@PathVariable Long id) {
        service.deleteByEmployeeId(id);
        return ResponseEntity.ok(id);
    }

    @GetMapping("/employee/id/{id}")
    public ResponseEntity<List<LoanDto>> findByEmployeeId(@PathVariable Long id) {
        var result = service.findByEmployeeId(id);
        var resultDto = converter.toDto(result);
        return ResponseEntity.ok(resultDto);
    }
}