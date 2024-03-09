package org.bshg.librarysystem.authorbook.webservice;
import org.bshg.librarysystem.authorbook.AuthorBook;
import org.bshg.librarysystem.authorbook.services.AuthorBookService;
import org.bshg.librarysystem.authorbook.sprocess.create.CreateAuthorBookProcess;
import org.bshg.librarysystem.authorbook.sprocess.update.UpdateAuthorBookProcess;
import org.bshg.librarysystem.authorbook.sprocess.delete.DeleteAuthorBookProcess;
import org.bshg.librarysystem.authorbook.webservice.AuthorBookConverter;
import org.bshg.librarysystem.authorbook.webservice.AuthorBookDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController
@RequestMapping("/api/authorbook")
public class AuthorBookRestApi {
protected AuthorBookService service;
protected AuthorBookConverter converter;
protected CreateAuthorBookProcess createProcess;
protected UpdateAuthorBookProcess updateProcess;
protected DeleteAuthorBookProcess deleteProcess;
@GetMapping("/id/{id}")
public ResponseEntity<AuthorBookDto> findById(@PathVariable Long id) {
AuthorBook item = service.findById(id);
if (item == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
converter.init(true);
AuthorBookDto dto = converter.toDto(item);
return ResponseEntity.ok(dto);
}
@GetMapping
public ResponseEntity<List<AuthorBookDto>> findAll() {
List<AuthorBook> all = service.findAll();
List<AuthorBookDto> dtos = converter.toDto(all);
return ResponseEntity.ok(dtos);
}
@GetMapping("/optimized")
public ResponseEntity<List<AuthorBookDto>> findAllOptimized() {
List<AuthorBook> all = service.findAllOptimized();
List<AuthorBookDto> dtos = converter.toDto(all);
return ResponseEntity.ok(dtos);
}
@PostMapping
public ResponseEntity<AuthorBookDto> save(@RequestBody AuthorBookDto dto) {
converter.init(true);
AuthorBook item = converter.toItem(dto);
item = createProcess.run(item);
return new ResponseEntity<>(converter.toDto(item), HttpStatus.CREATED);
}
@PostMapping("/all")
public ResponseEntity<List<AuthorBookDto>> save(@RequestBody List<AuthorBookDto> dtos) {
converter.init(true);
List<AuthorBook> items = converter.toItem(dtos);
items = createProcess.run(items);
return new ResponseEntity<>(converter.toDto(items), HttpStatus.CREATED);
}
@PutMapping()
public ResponseEntity<AuthorBookDto> update(@RequestBody AuthorBookDto dto) {
converter.init(true);
AuthorBook item = converter.toItem(dto);
item = updateProcess.run(item);
return ResponseEntity.ok(converter.toDto(item));
}
@PutMapping("/all")
public ResponseEntity<List<AuthorBookDto>> update(@RequestBody List<AuthorBookDto> dtos) {
converter.init(true);
List<AuthorBook> items = converter.toItem(dtos);
items = updateProcess.run(items);
return ResponseEntity.ok(converter.toDto(items));
}
@DeleteMapping
public ResponseEntity<AuthorBookDto> delete(@RequestBody AuthorBookDto dto) {
converter.init(false);
AuthorBook item = converter.toItem(dto);
deleteProcess.run(item);
return ResponseEntity.ok(dto);
}
@DeleteMapping("/all")
public ResponseEntity<List<AuthorBookDto>> delete(@RequestBody List<AuthorBookDto> dtos) {
converter.init(false);
List<AuthorBook> items = converter.toItem(dtos);
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
@DeleteMapping("/author/id/{id}")
public ResponseEntity<Long> deleteByAuthorId(@PathVariable Long id){
service.deleteByAuthorId(id);
return ResponseEntity.ok(id);
}
@GetMapping("/author/id/{id}")
public ResponseEntity<List<AuthorBookDto>> findByAuthorId(@PathVariable Long id){
List<AuthorBook> items = service.findByAuthorId(id);
List<AuthorBookDto> dtos = converter.toDto(items);
return ResponseEntity.ok(dtos);
}
@DeleteMapping("/book/id/{id}")
public ResponseEntity<Long> deleteByBookId(@PathVariable Long id){
service.deleteByBookId(id);
return ResponseEntity.ok(id);
}
@GetMapping("/book/id/{id}")
public ResponseEntity<List<AuthorBookDto>> findByBookId(@PathVariable Long id){
List<AuthorBook> items = service.findByBookId(id);
List<AuthorBookDto> dtos = converter.toDto(items);
return ResponseEntity.ok(dtos);
}
}