package org.bshg.librarysystem.webservice.controller.library;
import org.bshg.librarysystem.entity.core.library.Review;
import org.bshg.librarysystem.services.facade.library.ReviewService;
import org.bshg.librarysystem.sprocess.library.review.facade.CreateReviewProcess;
import org.bshg.librarysystem.sprocess.library.review.facade.UpdateReviewProcess;
import org.bshg.librarysystem.sprocess.library.review.facade.DeleteReviewProcess;
import org.bshg.librarysystem.webservice.converter.library.ReviewConverter;
import org.bshg.librarysystem.webservice.dto.library.ReviewDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController
@RequestMapping("/api/review")
public class ReviewRestApi {
protected ReviewService service;
protected ReviewConverter converter;
protected CreateReviewProcess createProcess;
protected UpdateReviewProcess updateProcess;
protected DeleteReviewProcess deleteProcess;
@GetMapping("/id/{id}")
public ResponseEntity<ReviewDto> findById(@PathVariable Long id) {
Review item = service.findById(id);
if (item == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
converter.init(true);
ReviewDto dto = converter.toDto(item);
return ResponseEntity.ok(dto);
}
@GetMapping
public ResponseEntity<List<ReviewDto>> findAll() {
List<Review> all = service.findAll();
List<ReviewDto> dtos = converter.toDto(all);
return ResponseEntity.ok(dtos);
}
@GetMapping("/optimized")
public ResponseEntity<List<ReviewDto>> findAllOptimized() {
List<Review> all = service.findAllOptimized();
List<ReviewDto> dtos = converter.toDto(all);
return ResponseEntity.ok(dtos);
}
@PostMapping
public ResponseEntity<ReviewDto> save(@RequestBody ReviewDto dto) {
converter.init(true);
Review item = converter.toItem(dto);
item = createProcess.run(item);
return new ResponseEntity<>(converter.toDto(item), HttpStatus.CREATED);
}
@PostMapping("/all")
public ResponseEntity<List<ReviewDto>> save(@RequestBody List<ReviewDto> dtos) {
converter.init(true);
List<Review> items = converter.toItem(dtos);
items = createProcess.run(items);
return new ResponseEntity<>(converter.toDto(items), HttpStatus.CREATED);
}
@PutMapping()
public ResponseEntity<ReviewDto> update(@RequestBody ReviewDto dto) {
converter.init(true);
Review item = converter.toItem(dto);
item = updateProcess.run(item);
return ResponseEntity.ok(converter.toDto(item));
}
@PutMapping("/all")
public ResponseEntity<List<ReviewDto>> update(@RequestBody List<ReviewDto> dtos) {
converter.init(true);
List<Review> items = converter.toItem(dtos);
items = updateProcess.run(items);
return ResponseEntity.ok(converter.toDto(items));
}
@DeleteMapping
public ResponseEntity<ReviewDto> delete(@RequestBody ReviewDto dto) {
converter.init(false);
Review item = converter.toItem(dto);
deleteProcess.run(item);
return ResponseEntity.ok(dto);
}
@DeleteMapping("/all")
public ResponseEntity<List<ReviewDto>> delete(@RequestBody List<ReviewDto> dtos) {
converter.init(false);
List<Review> items = converter.toItem(dtos);
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
public ResponseEntity<Long> deleteByBookId(@PathVariable Long id){
service.deleteByBookId(id);
return ResponseEntity.ok(id);
}
@GetMapping("/book/id/{id}")
public ResponseEntity<ReviewDto> findByBookId(@PathVariable Long id){
Review item = service.findByBookId(id);
ReviewDto dto = converter.toDto(item);
return ResponseEntity.ok(dto);
}
@DeleteMapping("/client/id/{id}")
public ResponseEntity<Long> deleteByClientId(@PathVariable Long id){
service.deleteByClientId(id);
return ResponseEntity.ok(id);
}
@GetMapping("/client/id/{id}")
public ResponseEntity<List<ReviewDto>> findByClientId(@PathVariable Long id){
List<Review> items = service.findByClientId(id);
List<ReviewDto> dtos = converter.toDto(items);
return ResponseEntity.ok(dtos);
}
}