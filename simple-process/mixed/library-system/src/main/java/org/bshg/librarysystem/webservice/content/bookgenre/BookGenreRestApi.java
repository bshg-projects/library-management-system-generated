package org.bshg.librarysystem.webservice.content.bookgenre;

import org.bshg.librarysystem.entity.core.content.BookGenre;
import org.bshg.librarysystem.services.content.bookgenre.BookGenreService;
import org.bshg.librarysystem.sprocess.content.bookgenre.create.CreateBookGenreProcess;
import org.bshg.librarysystem.sprocess.content.bookgenre.delete.DeleteBookGenreProcess;
import org.bshg.librarysystem.sprocess.content.bookgenre.update.UpdateBookGenreProcess;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookgenre")
public class BookGenreRestApi {
    protected BookGenreService service;
    protected BookGenreConverter converter;
    protected CreateBookGenreProcess createProcess;
    protected UpdateBookGenreProcess updateProcess;
    protected DeleteBookGenreProcess deleteProcess;

    @GetMapping("/id/{id}")
    public ResponseEntity<BookGenreDto> findById(@PathVariable Long id) {
        BookGenre item = service.findById(id);
        if (item == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        converter.init(true);
        BookGenreDto dto = converter.toDto(item);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<BookGenreDto>> findAll() {
        List<BookGenre> all = service.findAll();
        List<BookGenreDto> dtos = converter.toDto(all);
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/optimized")
    public ResponseEntity<List<BookGenreDto>> findAllOptimized() {
        List<BookGenre> all = service.findAllOptimized();
        List<BookGenreDto> dtos = converter.toDto(all);
        return ResponseEntity.ok(dtos);
    }

    @PostMapping
    public ResponseEntity<BookGenreDto> save(@RequestBody BookGenreDto dto) {
        converter.init(true);
        BookGenre item = converter.toItem(dto);
        item = createProcess.run(item);
        return new ResponseEntity<>(converter.toDto(item), HttpStatus.CREATED);
    }

    @PostMapping("/all")
    public ResponseEntity<List<BookGenreDto>> save(@RequestBody List<BookGenreDto> dtos) {
        converter.init(true);
        List<BookGenre> items = converter.toItem(dtos);
        items = createProcess.run(items);
        return new ResponseEntity<>(converter.toDto(items), HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<BookGenreDto> update(@RequestBody BookGenreDto dto) {
        converter.init(true);
        BookGenre item = converter.toItem(dto);
        item = updateProcess.run(item);
        return ResponseEntity.ok(converter.toDto(item));
    }

    @PutMapping("/all")
    public ResponseEntity<List<BookGenreDto>> update(@RequestBody List<BookGenreDto> dtos) {
        converter.init(true);
        List<BookGenre> items = converter.toItem(dtos);
        items = updateProcess.run(items);
        return ResponseEntity.ok(converter.toDto(items));
    }

    @DeleteMapping
    public ResponseEntity<BookGenreDto> delete(@RequestBody BookGenreDto dto) {
        converter.init(false);
        BookGenre item = converter.toItem(dto);
        deleteProcess.run(item);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/all")
    public ResponseEntity<List<BookGenreDto>> delete(@RequestBody List<BookGenreDto> dtos) {
        converter.init(false);
        List<BookGenre> items = converter.toItem(dtos);
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
    public ResponseEntity<List<BookGenreDto>> findByBookId(@PathVariable Long id) {
        List<BookGenre> items = service.findByBookId(id);
        List<BookGenreDto> dtos = converter.toDto(items);
        return ResponseEntity.ok(dtos);
    }

    @DeleteMapping("/genre/id/{id}")
    public ResponseEntity<Long> deleteByGenreId(@PathVariable Long id) {
        service.deleteByGenreId(id);
        return ResponseEntity.ok(id);
    }

    @GetMapping("/genre/id/{id}")
    public ResponseEntity<List<BookGenreDto>> findByGenreId(@PathVariable Long id) {
        List<BookGenre> items = service.findByGenreId(id);
        List<BookGenreDto> dtos = converter.toDto(items);
        return ResponseEntity.ok(dtos);
    }
}