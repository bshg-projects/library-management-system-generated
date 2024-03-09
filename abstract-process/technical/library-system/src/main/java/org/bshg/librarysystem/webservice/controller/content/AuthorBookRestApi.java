package org.bshg.librarysystem.webservice.controller.content;
import org.bshg.librarysystem.entity.core.content.AuthorBook;
import org.bshg.librarysystem.services.facade.content.AuthorBookService;
import org.bshg.librarysystem.sprocess.content.authorbook.facade.CreateAuthorBookProcess;
import org.bshg.librarysystem.sprocess.content.authorbook.facade.UpdateAuthorBookProcess;
import org.bshg.librarysystem.sprocess.content.authorbook.facade.DeleteAuthorBookProcess;
import org.bshg.librarysystem.webservice.converter.content.AuthorBookConverter;
import org.bshg.librarysystem.webservice.dto.content.AuthorBookDto;
import org.bshg.librarysystem.utils.webservice.restapi.AbstractRestApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/authorbook")
public class AuthorBookRestApi extends AbstractRestApi<
AuthorBook,
AuthorBookDto,
AuthorBookService,
AuthorBookConverter,
CreateAuthorBookProcess,
UpdateAuthorBookProcess,
DeleteAuthorBookProcess> {
public AuthorBookRestApi( AuthorBookService service, AuthorBookConverter converter, CreateAuthorBookProcess createProcess, UpdateAuthorBookProcess updateProcess, DeleteAuthorBookProcess deleteProcess) {
super(service, converter, createProcess, updateProcess, deleteProcess);
}
@Override
@GetMapping("/id/{id}")
public ResponseEntity<AuthorBookDto> findById(@PathVariable Long id) {
return super.findById(id);
}
@Override
@GetMapping
public ResponseEntity<List<AuthorBookDto>> findAll() {
return super.findAll();
}
@Override
@GetMapping("/optimized")
public ResponseEntity<List<AuthorBookDto>> findAllOptimized() {
return super.findAllOptimized();
}
@Override
@PostMapping
public ResponseEntity<AuthorBookDto> save(@RequestBody AuthorBookDto dto) {
return super.save(dto);
}
@Override
@PostMapping("/all")
public ResponseEntity<List<AuthorBookDto>> save(@RequestBody List<AuthorBookDto> dtos) {
return super.save(dtos);
}
@Override
@PutMapping()
public ResponseEntity<AuthorBookDto> update(@RequestBody AuthorBookDto dto) {
return super.update(dto);
}
@Override
@PutMapping("/all")
public ResponseEntity<List<AuthorBookDto>> update(@RequestBody List<AuthorBookDto> dtos) {
return super.update(dtos);
}
@Override
@DeleteMapping
public ResponseEntity<AuthorBookDto> delete(@RequestBody AuthorBookDto dto) {
return super.delete(dto);
}
@Override
@DeleteMapping("/all")
public ResponseEntity<List<AuthorBookDto>> delete(@RequestBody List<AuthorBookDto> dtos) {
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
@DeleteMapping("/author/id/{id}")
public ResponseEntity<Long> deleteByAuthorId(@PathVariable Long id){
return super.deleteProcess(id, service::deleteByAuthorId);
}
@GetMapping("/author/id/{id}")
public ResponseEntity<List<AuthorBookDto>> findByAuthorId(@PathVariable Long id){
return super.findListByChildId(id, service::findByAuthorId);
}
@DeleteMapping("/book/id/{id}")
public ResponseEntity<Long> deleteByBookId(@PathVariable Long id){
return super.deleteProcess(id, service::deleteByBookId);
}
@GetMapping("/book/id/{id}")
public ResponseEntity<List<AuthorBookDto>> findByBookId(@PathVariable Long id){
return super.findListByChildId(id, service::findByBookId);
}
}