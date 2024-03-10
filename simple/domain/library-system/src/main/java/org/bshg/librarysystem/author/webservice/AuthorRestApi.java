package org.bshg.librarysystem.author.webservice;

import org.bshg.librarysystem.author.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/author")
public class AuthorRestApi {
    @Autowired
    private AuthorService service;
    @Autowired
    private AuthorConverter converter;

    @GetMapping("/id/{id}")
    public ResponseEntity<AuthorDto> findById(@PathVariable Long id) {
        var result = service.findById(id);
        var resultDto = converter.toDto(result);
        return ResponseEntity.ok(resultDto);
    }

    @GetMapping
    public ResponseEntity<List<AuthorDto>> findAll() {
        var result = service.findAll();
        var resultDto = converter.toDto(result);
        return ResponseEntity.ok(resultDto);
    }

    @GetMapping("/optimized")
    public ResponseEntity<List<AuthorDto>> findAllOptimized() {
        var result = service.findAllOptimized();
        var resultDto = converter.toDto(result);
        return ResponseEntity.ok(resultDto);
    }

    @PostMapping
    public ResponseEntity<AuthorDto> save(@RequestBody AuthorDto dto) {
        if (dto == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
        var item = converter.toItem(dto);
        var result = service.create(item);
        var resultDto = converter.toDto(result);
        return ResponseEntity.ok(resultDto);
    }

    @PostMapping("/all")
    public ResponseEntity<List<AuthorDto>> save(@RequestBody List<AuthorDto> dtos) {
        if (dtos == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
        var item = converter.toItem(dtos);
        var result = service.create(item);
        var resultDto = converter.toDto(result);
        return ResponseEntity.ok(resultDto);
    }

    @PutMapping()
    public ResponseEntity<AuthorDto> update(@RequestBody AuthorDto dto) {
        if (dto == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
        var item = converter.toItem(dto);
        var result = service.update(item);
        var resultDto = converter.toDto(result);
        return ResponseEntity.ok(resultDto);
    }

    @PutMapping("/all")
    public ResponseEntity<List<AuthorDto>> update(@RequestBody List<AuthorDto> dtos) {
        if (dtos == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
        var item = converter.toItem(dtos);
        var result = service.update(item);
        var resultDto = converter.toDto(result);
        return ResponseEntity.ok(resultDto);
    }

    @DeleteMapping
    public ResponseEntity<AuthorDto> delete(@RequestBody AuthorDto dto) {
        if (dto == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
        var item = converter.toItem(dto);
        service.delete(item);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/all")
    public ResponseEntity<List<AuthorDto>> delete(@RequestBody List<AuthorDto> dtos) {
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
}