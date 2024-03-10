package org.bshg.librarysystem.book.webservice;

import org.bshg.librarysystem.book.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookRestApi {
    @Autowired
    private BookService service;
    @Autowired
    private BookConverter converter;

    @GetMapping("/id/{id}")
    public ResponseEntity<BookDto> findById(@PathVariable Long id) {
        var result = service.findById(id);
        var resultDto = converter.toDto(result);
        return ResponseEntity.ok(resultDto);
    }

    @GetMapping
    public ResponseEntity<List<BookDto>> findAll() {
        var result = service.findAll();
        var resultDto = converter.toDto(result);
        return ResponseEntity.ok(resultDto);
    }

    @GetMapping("/optimized")
    public ResponseEntity<List<BookDto>> findAllOptimized() {
        var result = service.findAllOptimized();
        var resultDto = converter.toDto(result);
        return ResponseEntity.ok(resultDto);
    }

    @PostMapping
    public ResponseEntity<BookDto> save(@RequestBody BookDto dto) {
        if (dto == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
        var item = converter.toItem(dto);
        var result = service.create(item);
        var resultDto = converter.toDto(result);
        return ResponseEntity.ok(resultDto);
    }

    @PostMapping("/all")
    public ResponseEntity<List<BookDto>> save(@RequestBody List<BookDto> dtos) {
        if (dtos == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
        var item = converter.toItem(dtos);
        var result = service.create(item);
        var resultDto = converter.toDto(result);
        return ResponseEntity.ok(resultDto);
    }

    @PutMapping()
    public ResponseEntity<BookDto> update(@RequestBody BookDto dto) {
        if (dto == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
        var item = converter.toItem(dto);
        var result = service.update(item);
        var resultDto = converter.toDto(result);
        return ResponseEntity.ok(resultDto);
    }

    @PutMapping("/all")
    public ResponseEntity<List<BookDto>> update(@RequestBody List<BookDto> dtos) {
        if (dtos == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
        var item = converter.toItem(dtos);
        var result = service.update(item);
        var resultDto = converter.toDto(result);
        return ResponseEntity.ok(resultDto);
    }

    @DeleteMapping
    public ResponseEntity<BookDto> delete(@RequestBody BookDto dto) {
        if (dto == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
        var item = converter.toItem(dto);
        service.delete(item);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/all")
    public ResponseEntity<List<BookDto>> delete(@RequestBody List<BookDto> dtos) {
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

    @DeleteMapping("/employee/id/{id}")
    public ResponseEntity<Long> deleteByEmployeeId(@PathVariable Long id) {
        service.deleteByEmployeeId(id);
        return ResponseEntity.ok(id);
    }

    @GetMapping("/employee/id/{id}")
    public ResponseEntity<List<BookDto>> findByEmployeeId(@PathVariable Long id) {
        var result = service.findByEmployeeId(id);
        var resultDto = converter.toDto(result);
        return ResponseEntity.ok(resultDto);
    }

    @DeleteMapping("/publisher/id/{id}")
    public ResponseEntity<Long> deleteByPublisherId(@PathVariable Long id) {
        service.deleteByPublisherId(id);
        return ResponseEntity.ok(id);
    }

    @GetMapping("/publisher/id/{id}")
    public ResponseEntity<List<BookDto>> findByPublisherId(@PathVariable Long id) {
        var result = service.findByPublisherId(id);
        var resultDto = converter.toDto(result);
        return ResponseEntity.ok(resultDto);
    }

    @DeleteMapping("/rack/id/{id}")
    public ResponseEntity<Long> deleteByRackId(@PathVariable Long id) {
        service.deleteByRackId(id);
        return ResponseEntity.ok(id);
    }

    @GetMapping("/rack/id/{id}")
    public ResponseEntity<List<BookDto>> findByRackId(@PathVariable Long id) {
        var result = service.findByRackId(id);
        var resultDto = converter.toDto(result);
        return ResponseEntity.ok(resultDto);
    }
}