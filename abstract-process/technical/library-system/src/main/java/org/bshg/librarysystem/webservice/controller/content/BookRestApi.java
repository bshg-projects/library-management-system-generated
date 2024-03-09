package org.bshg.librarysystem.webservice.controller.content;
import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.services.facade.content.BookService;
import org.bshg.librarysystem.sprocess.content.book.facade.CreateBookProcess;
import org.bshg.librarysystem.sprocess.content.book.facade.UpdateBookProcess;
import org.bshg.librarysystem.sprocess.content.book.facade.DeleteBookProcess;
import org.bshg.librarysystem.webservice.converter.content.BookConverter;
import org.bshg.librarysystem.webservice.dto.content.BookDto;
import org.bshg.librarysystem.utils.webservice.restapi.AbstractRestApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/book")
public class BookRestApi extends AbstractRestApi<
Book,
BookDto,
BookService,
BookConverter,
CreateBookProcess,
UpdateBookProcess,
DeleteBookProcess> {
public BookRestApi( BookService service, BookConverter converter, CreateBookProcess createProcess, UpdateBookProcess updateProcess, DeleteBookProcess deleteProcess) {
super(service, converter, createProcess, updateProcess, deleteProcess);
}
@Override
@GetMapping("/id/{id}")
public ResponseEntity<BookDto> findById(@PathVariable Long id) {
return super.findById(id);
}
@Override
@GetMapping
public ResponseEntity<List<BookDto>> findAll() {
return super.findAll();
}
@Override
@GetMapping("/optimized")
public ResponseEntity<List<BookDto>> findAllOptimized() {
return super.findAllOptimized();
}
@Override
@PostMapping
public ResponseEntity<BookDto> save(@RequestBody BookDto dto) {
return super.save(dto);
}
@Override
@PostMapping("/all")
public ResponseEntity<List<BookDto>> save(@RequestBody List<BookDto> dtos) {
return super.save(dtos);
}
@Override
@PutMapping()
public ResponseEntity<BookDto> update(@RequestBody BookDto dto) {
return super.update(dto);
}
@Override
@PutMapping("/all")
public ResponseEntity<List<BookDto>> update(@RequestBody List<BookDto> dtos) {
return super.update(dtos);
}
@Override
@DeleteMapping
public ResponseEntity<BookDto> delete(@RequestBody BookDto dto) {
return super.delete(dto);
}
@Override
@DeleteMapping("/all")
public ResponseEntity<List<BookDto>> delete(@RequestBody List<BookDto> dtos) {
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
@DeleteMapping("/employee/id/{id}")
public ResponseEntity<Long> deleteByEmployeeId(@PathVariable Long id){
return super.deleteProcess(id, service::deleteByEmployeeId);
}
@GetMapping("/employee/id/{id}")
public ResponseEntity<List<BookDto>> findByEmployeeId(@PathVariable Long id){
return super.findListByChildId(id, service::findByEmployeeId);
}
@DeleteMapping("/publisher/id/{id}")
public ResponseEntity<Long> deleteByPublisherId(@PathVariable Long id){
return super.deleteProcess(id, service::deleteByPublisherId);
}
@GetMapping("/publisher/id/{id}")
public ResponseEntity<List<BookDto>> findByPublisherId(@PathVariable Long id){
return super.findListByChildId(id, service::findByPublisherId);
}
@DeleteMapping("/rack/id/{id}")
public ResponseEntity<Long> deleteByRackId(@PathVariable Long id){
return super.deleteProcess(id, service::deleteByRackId);
}
@GetMapping("/rack/id/{id}")
public ResponseEntity<List<BookDto>> findByRackId(@PathVariable Long id){
return super.findListByChildId(id, service::findByRackId);
}
}