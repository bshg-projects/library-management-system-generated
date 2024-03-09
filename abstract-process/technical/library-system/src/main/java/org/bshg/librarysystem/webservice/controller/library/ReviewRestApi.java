package org.bshg.librarysystem.webservice.controller.library;
import org.bshg.librarysystem.entity.core.library.Review;
import org.bshg.librarysystem.services.facade.library.ReviewService;
import org.bshg.librarysystem.sprocess.library.review.facade.CreateReviewProcess;
import org.bshg.librarysystem.sprocess.library.review.facade.UpdateReviewProcess;
import org.bshg.librarysystem.sprocess.library.review.facade.DeleteReviewProcess;
import org.bshg.librarysystem.webservice.converter.library.ReviewConverter;
import org.bshg.librarysystem.webservice.dto.library.ReviewDto;
import org.bshg.librarysystem.utils.webservice.restapi.AbstractRestApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/review")
public class ReviewRestApi extends AbstractRestApi<
Review,
ReviewDto,
ReviewService,
ReviewConverter,
CreateReviewProcess,
UpdateReviewProcess,
DeleteReviewProcess> {
public ReviewRestApi( ReviewService service, ReviewConverter converter, CreateReviewProcess createProcess, UpdateReviewProcess updateProcess, DeleteReviewProcess deleteProcess) {
super(service, converter, createProcess, updateProcess, deleteProcess);
}
@Override
@GetMapping("/id/{id}")
public ResponseEntity<ReviewDto> findById(@PathVariable Long id) {
return super.findById(id);
}
@Override
@GetMapping
public ResponseEntity<List<ReviewDto>> findAll() {
return super.findAll();
}
@Override
@GetMapping("/optimized")
public ResponseEntity<List<ReviewDto>> findAllOptimized() {
return super.findAllOptimized();
}
@Override
@PostMapping
public ResponseEntity<ReviewDto> save(@RequestBody ReviewDto dto) {
return super.save(dto);
}
@Override
@PostMapping("/all")
public ResponseEntity<List<ReviewDto>> save(@RequestBody List<ReviewDto> dtos) {
return super.save(dtos);
}
@Override
@PutMapping()
public ResponseEntity<ReviewDto> update(@RequestBody ReviewDto dto) {
return super.update(dto);
}
@Override
@PutMapping("/all")
public ResponseEntity<List<ReviewDto>> update(@RequestBody List<ReviewDto> dtos) {
return super.update(dtos);
}
@Override
@DeleteMapping
public ResponseEntity<ReviewDto> delete(@RequestBody ReviewDto dto) {
return super.delete(dto);
}
@Override
@DeleteMapping("/all")
public ResponseEntity<List<ReviewDto>> delete(@RequestBody List<ReviewDto> dtos) {
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
public ResponseEntity<Long> deleteByBookId(@PathVariable Long id){
return super.deleteProcess(id, service::deleteByBookId);
}
@GetMapping("/book/id/{id}")
public ResponseEntity<ReviewDto> findByBookId(@PathVariable Long id){
return super.findByChildId(id, service::findByBookId);
}
@DeleteMapping("/client/id/{id}")
public ResponseEntity<Long> deleteByClientId(@PathVariable Long id){
return super.deleteProcess(id, service::deleteByClientId);
}
@GetMapping("/client/id/{id}")
public ResponseEntity<List<ReviewDto>> findByClientId(@PathVariable Long id){
return super.findListByChildId(id, service::findByClientId);
}
}