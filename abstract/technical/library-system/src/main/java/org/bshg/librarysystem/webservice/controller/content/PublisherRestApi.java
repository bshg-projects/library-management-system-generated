package org.bshg.librarysystem.webservice.controller.content;
import org.bshg.librarysystem.entity.core.content.Publisher;
import org.bshg.librarysystem.services.facade.content.PublisherService;
import org.bshg.librarysystem.webservice.converter.content.PublisherConverter;
import org.bshg.librarysystem.webservice.dto.content.PublisherDto;
import org.bshg.librarysystem.utils.webservice.restapi.AbstractRestApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/publisher")
public class PublisherRestApi extends AbstractRestApi<Publisher,PublisherDto,PublisherService,PublisherConverter> {
public PublisherRestApi( PublisherService service, PublisherConverter converter) {
super(service, converter);
}
@Override
@GetMapping("/id/{id}")
public ResponseEntity<PublisherDto> findById(@PathVariable Long id) {
return super.findById(id);
}
@Override
@GetMapping
public ResponseEntity<List<PublisherDto>> findAll() {
return super.findAll();
}
@Override
@GetMapping("/optimized")
public ResponseEntity<List<PublisherDto>> findAllOptimized() {
return super.findAllOptimized();
}
@Override
@PostMapping
public ResponseEntity<PublisherDto> save(@RequestBody PublisherDto dto) {
return super.save(dto);
}
@Override
@PostMapping("/all")
public ResponseEntity<List<PublisherDto>> save(@RequestBody List<PublisherDto> dtos) {
return super.save(dtos);
}
@Override
@PutMapping()
public ResponseEntity<PublisherDto> update(@RequestBody PublisherDto dto) {
return super.update(dto);
}
@Override
@PutMapping("/all")
public ResponseEntity<List<PublisherDto>> update(@RequestBody List<PublisherDto> dtos) {
return super.update(dtos);
}
@Override
@DeleteMapping
public ResponseEntity<PublisherDto> delete(@RequestBody PublisherDto dto) {
return super.delete(dto);
}
@Override
@DeleteMapping("/all")
public ResponseEntity<List<PublisherDto>> delete(@RequestBody List<PublisherDto> dtos) {
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
@DeleteMapping("/address/id/{id}")
public ResponseEntity<Long> deleteByAddressId(@PathVariable Long id){
return super.deleteProcess(id, service::deleteByAddressId);
}
@GetMapping("/address/id/{id}")
public ResponseEntity<PublisherDto> findByAddressId(@PathVariable Long id){
return super.findByChildId(id, service::findByAddressId);
}
}