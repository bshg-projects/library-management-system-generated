package org.bshg.librarysystem.webservice.content.authorbook;
import org.bshg.librarysystem.entity.core.content.AuthorBook;
import org.bshg.librarysystem.services.content.authorbook.AuthorBookService;
import org.bshg.librarysystem.webservice.content.authorbook.AuthorBookConverter;
import org.bshg.librarysystem.webservice.content.authorbook.AuthorBookDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController
@RequestMapping("/api/authorbook")
public class AuthorBookRestApi {
@Autowired private AuthorBookService service;
@Autowired private AuthorBookConverter converter;
@GetMapping("/id/{id}")
public ResponseEntity<AuthorBookDto> findById(@PathVariable Long id) {
var result = service.findById(id);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@GetMapping
public ResponseEntity<List<AuthorBookDto>> findAll() {
var result = service.findAll();
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@GetMapping("/optimized")
public ResponseEntity<List<AuthorBookDto>> findAllOptimized() {
var result = service.findAllOptimized();
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@PostMapping
public ResponseEntity<AuthorBookDto> save(@RequestBody AuthorBookDto dto) {
if (dto == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dto);
var result = service.create(item);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@PostMapping("/all")
public ResponseEntity<List<AuthorBookDto>> save(@RequestBody List<AuthorBookDto> dtos) {
if (dtos == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dtos);
var result = service.create(item);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@PutMapping()
public ResponseEntity<AuthorBookDto> update(@RequestBody AuthorBookDto dto) {
if (dto == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dto);
var result = service.update(item);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@PutMapping("/all")
public ResponseEntity<List<AuthorBookDto>> update(@RequestBody List<AuthorBookDto> dtos) {
if (dtos == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dtos);
var result = service.update(item);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@DeleteMapping
public ResponseEntity<AuthorBookDto> delete(@RequestBody AuthorBookDto dto) {
if (dto == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dto);
service.delete(item);
return ResponseEntity.ok(dto);
}
@DeleteMapping("/all")
public ResponseEntity<List<AuthorBookDto>> delete(@RequestBody List<AuthorBookDto> dtos) {
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
@DeleteMapping("/author/id/{id}")
public ResponseEntity<Long> deleteByAuthorId(@PathVariable Long id){
service.deleteByAuthorId(id);
return ResponseEntity.ok(id);
}
@GetMapping("/author/id/{id}")
public ResponseEntity<List<AuthorBookDto>> findByAuthorId(@PathVariable Long id){
var result = service.findByAuthorId(id);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@DeleteMapping("/book/id/{id}")
public ResponseEntity<Long> deleteByBookId(@PathVariable Long id){
service.deleteByBookId(id);
return ResponseEntity.ok(id);
}
@GetMapping("/book/id/{id}")
public ResponseEntity<List<AuthorBookDto>> findByBookId(@PathVariable Long id){
var result = service.findByBookId(id);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
}