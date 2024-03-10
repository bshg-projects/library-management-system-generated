package org.bshg.librarysystem.bookgenre.webservice;

import org.bshg.librarysystem.bookgenre.BookGenre;
import org.bshg.librarysystem.bookgenre.services.BookGenreService;
import org.bshg.librarysystem.bookgenre.sprocess.create.CreateBookGenreProcess;
import org.bshg.librarysystem.bookgenre.sprocess.delete.DeleteBookGenreProcess;
import org.bshg.librarysystem.bookgenre.sprocess.update.UpdateBookGenreProcess;
import org.bshg.librarysystem.utils.webservice.restapi.AbstractRestApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookgenre")
public class BookGenreRestApi extends AbstractRestApi<
        BookGenre,
        BookGenreDto,
        BookGenreService,
        BookGenreConverter,
        CreateBookGenreProcess,
        UpdateBookGenreProcess,
        DeleteBookGenreProcess> {
    public BookGenreRestApi(BookGenreService service, BookGenreConverter converter, CreateBookGenreProcess createProcess, UpdateBookGenreProcess updateProcess, DeleteBookGenreProcess deleteProcess) {
        super(service, converter, createProcess, updateProcess, deleteProcess);
    }

    @Override
    @GetMapping("/id/{id}")
    public ResponseEntity<BookGenreDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<BookGenreDto>> findAll() {
        return super.findAll();
    }

    @Override
    @GetMapping("/optimized")
    public ResponseEntity<List<BookGenreDto>> findAllOptimized() {
        return super.findAllOptimized();
    }

    @Override
    @PostMapping
    public ResponseEntity<BookGenreDto> save(@RequestBody BookGenreDto dto) {
        return super.save(dto);
    }

    @Override
    @PostMapping("/all")
    public ResponseEntity<List<BookGenreDto>> save(@RequestBody List<BookGenreDto> dtos) {
        return super.save(dtos);
    }

    @Override
    @PutMapping()
    public ResponseEntity<BookGenreDto> update(@RequestBody BookGenreDto dto) {
        return super.update(dto);
    }

    @Override
    @PutMapping("/all")
    public ResponseEntity<List<BookGenreDto>> update(@RequestBody List<BookGenreDto> dtos) {
        return super.update(dtos);
    }

    @Override
    @DeleteMapping
    public ResponseEntity<BookGenreDto> delete(@RequestBody BookGenreDto dto) {
        return super.delete(dto);
    }

    @Override
    @DeleteMapping("/all")
    public ResponseEntity<List<BookGenreDto>> delete(@RequestBody List<BookGenreDto> dtos) {
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

    @DeleteMapping("/book/id/{id}")
    public ResponseEntity<Long> deleteByBookId(@PathVariable Long id) {
        return super.deleteProcess(id, service::deleteByBookId);
    }

    @GetMapping("/book/id/{id}")
    public ResponseEntity<List<BookGenreDto>> findByBookId(@PathVariable Long id) {
        return super.findListByChildId(id, service::findByBookId);
    }

    @DeleteMapping("/genre/id/{id}")
    public ResponseEntity<Long> deleteByGenreId(@PathVariable Long id) {
        return super.deleteProcess(id, service::deleteByGenreId);
    }

    @GetMapping("/genre/id/{id}")
    public ResponseEntity<List<BookGenreDto>> findByGenreId(@PathVariable Long id) {
        return super.findListByChildId(id, service::findByGenreId);
    }
}