package org.bshg.librarysystem.webservice.content.author;
import org.bshg.librarysystem.entity.core.content.Author;
import org.bshg.librarysystem.services.content.author.AuthorService;
import org.bshg.librarysystem.sprocess.content.author.create.CreateAuthorProcess;
import org.bshg.librarysystem.sprocess.content.author.update.UpdateAuthorProcess;
import org.bshg.librarysystem.sprocess.content.author.delete.DeleteAuthorProcess;
import org.bshg.librarysystem.webservice.content.author.AuthorConverter;
import org.bshg.librarysystem.webservice.content.author.AuthorDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController
@RequestMapping("/api/author")
public class AuthorRestApi {
protected AuthorService service;
protected AuthorConverter converter;
protected CreateAuthorProcess createProcess;
protected UpdateAuthorProcess updateProcess;
protected DeleteAuthorProcess deleteProcess;
@GetMapping("/id/{id}")
public ResponseEntity<AuthorDto> findById(@PathVariable Long id) {
Author item = service.findById(id);
if (item == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
converter.init(true);
AuthorDto dto = converter.toDto(item);
return ResponseEntity.ok(dto);
}
@GetMapping
public ResponseEntity<List<AuthorDto>> findAll() {
List<Author> all = service.findAll();
List<AuthorDto> dtos = converter.toDto(all);
return ResponseEntity.ok(dtos);
}
@GetMapping("/optimized")
public ResponseEntity<List<AuthorDto>> findAllOptimized() {
List<Author> all = service.findAllOptimized();
List<AuthorDto> dtos = converter.toDto(all);
return ResponseEntity.ok(dtos);
}
@PostMapping
public ResponseEntity<AuthorDto> save(@RequestBody AuthorDto dto) {
converter.init(true);
Author item = converter.toItem(dto);
item = createProcess.run(item);
return new ResponseEntity<>(converter.toDto(item), HttpStatus.CREATED);
}
@PostMapping("/all")
public ResponseEntity<List<AuthorDto>> save(@RequestBody List<AuthorDto> dtos) {
converter.init(true);
List<Author> items = converter.toItem(dtos);
items = createProcess.run(items);
return new ResponseEntity<>(converter.toDto(items), HttpStatus.CREATED);
}
@PutMapping()
public ResponseEntity<AuthorDto> update(@RequestBody AuthorDto dto) {
converter.init(true);
Author item = converter.toItem(dto);
item = updateProcess.run(item);
return ResponseEntity.ok(converter.toDto(item));
}
@PutMapping("/all")
public ResponseEntity<List<AuthorDto>> update(@RequestBody List<AuthorDto> dtos) {
converter.init(true);
List<Author> items = converter.toItem(dtos);
items = updateProcess.run(items);
return ResponseEntity.ok(converter.toDto(items));
}
@DeleteMapping
public ResponseEntity<AuthorDto> delete(@RequestBody AuthorDto dto) {
converter.init(false);
Author item = converter.toItem(dto);
deleteProcess.run(item);
return ResponseEntity.ok(dto);
}
@DeleteMapping("/all")
public ResponseEntity<List<AuthorDto>> delete(@RequestBody List<AuthorDto> dtos) {
converter.init(false);
List<Author> items = converter.toItem(dtos);
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
}