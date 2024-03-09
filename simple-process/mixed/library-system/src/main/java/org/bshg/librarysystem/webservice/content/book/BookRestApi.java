package org.bshg.librarysystem.webservice.content.book;
import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.services.content.book.BookService;
import org.bshg.librarysystem.sprocess.content.book.create.CreateBookProcess;
import org.bshg.librarysystem.sprocess.content.book.update.UpdateBookProcess;
import org.bshg.librarysystem.sprocess.content.book.delete.DeleteBookProcess;
import org.bshg.librarysystem.webservice.content.book.BookConverter;
import org.bshg.librarysystem.webservice.content.book.BookDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController
@RequestMapping("/api/book")
public class BookRestApi {
protected BookService service;
protected BookConverter converter;
protected CreateBookProcess createProcess;
protected UpdateBookProcess updateProcess;
protected DeleteBookProcess deleteProcess;
@GetMapping("/id/{id}")
public ResponseEntity<BookDto> findById(@PathVariable Long id) {
Book item = service.findById(id);
if (item == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
converter.init(true);
BookDto dto = converter.toDto(item);
return ResponseEntity.ok(dto);
}
@GetMapping
public ResponseEntity<List<BookDto>> findAll() {
List<Book> all = service.findAll();
List<BookDto> dtos = converter.toDto(all);
return ResponseEntity.ok(dtos);
}
@GetMapping("/optimized")
public ResponseEntity<List<BookDto>> findAllOptimized() {
List<Book> all = service.findAllOptimized();
List<BookDto> dtos = converter.toDto(all);
return ResponseEntity.ok(dtos);
}
@PostMapping
public ResponseEntity<BookDto> save(@RequestBody BookDto dto) {
converter.init(true);
Book item = converter.toItem(dto);
item = createProcess.run(item);
return new ResponseEntity<>(converter.toDto(item), HttpStatus.CREATED);
}
@PostMapping("/all")
public ResponseEntity<List<BookDto>> save(@RequestBody List<BookDto> dtos) {
converter.init(true);
List<Book> items = converter.toItem(dtos);
items = createProcess.run(items);
return new ResponseEntity<>(converter.toDto(items), HttpStatus.CREATED);
}
@PutMapping()
public ResponseEntity<BookDto> update(@RequestBody BookDto dto) {
converter.init(true);
Book item = converter.toItem(dto);
item = updateProcess.run(item);
return ResponseEntity.ok(converter.toDto(item));
}
@PutMapping("/all")
public ResponseEntity<List<BookDto>> update(@RequestBody List<BookDto> dtos) {
converter.init(true);
List<Book> items = converter.toItem(dtos);
items = updateProcess.run(items);
return ResponseEntity.ok(converter.toDto(items));
}
@DeleteMapping
public ResponseEntity<BookDto> delete(@RequestBody BookDto dto) {
converter.init(false);
Book item = converter.toItem(dto);
deleteProcess.run(item);
return ResponseEntity.ok(dto);
}
@DeleteMapping("/all")
public ResponseEntity<List<BookDto>> delete(@RequestBody List<BookDto> dtos) {
converter.init(false);
List<Book> items = converter.toItem(dtos);
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
@DeleteMapping("/employee/id/{id}")
public ResponseEntity<Long> deleteByEmployeeId(@PathVariable Long id){
service.deleteByEmployeeId(id);
return ResponseEntity.ok(id);
}
@GetMapping("/employee/id/{id}")
public ResponseEntity<List<BookDto>> findByEmployeeId(@PathVariable Long id){
List<Book> items = service.findByEmployeeId(id);
List<BookDto> dtos = converter.toDto(items);
return ResponseEntity.ok(dtos);
}
@DeleteMapping("/publisher/id/{id}")
public ResponseEntity<Long> deleteByPublisherId(@PathVariable Long id){
service.deleteByPublisherId(id);
return ResponseEntity.ok(id);
}
@GetMapping("/publisher/id/{id}")
public ResponseEntity<List<BookDto>> findByPublisherId(@PathVariable Long id){
List<Book> items = service.findByPublisherId(id);
List<BookDto> dtos = converter.toDto(items);
return ResponseEntity.ok(dtos);
}
@DeleteMapping("/rack/id/{id}")
public ResponseEntity<Long> deleteByRackId(@PathVariable Long id){
service.deleteByRackId(id);
return ResponseEntity.ok(id);
}
@GetMapping("/rack/id/{id}")
public ResponseEntity<List<BookDto>> findByRackId(@PathVariable Long id){
List<Book> items = service.findByRackId(id);
List<BookDto> dtos = converter.toDto(items);
return ResponseEntity.ok(dtos);
}
}