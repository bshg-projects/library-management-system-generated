package org.bshg.librarysystem.webservice.controller.content;
import org.bshg.librarysystem.entity.core.content.Magazine;
import org.bshg.librarysystem.services.facade.content.MagazineService;
import org.bshg.librarysystem.webservice.converter.content.MagazineConverter;
import org.bshg.librarysystem.webservice.dto.content.MagazineDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController
@RequestMapping("/api/magazine")
public class MagazineRestApi {
@Autowired private MagazineService service;
@Autowired private MagazineConverter converter;
@GetMapping("/id/{id}")
public ResponseEntity<MagazineDto> findById(@PathVariable Long id) {
var result = service.findById(id);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@GetMapping
public ResponseEntity<List<MagazineDto>> findAll() {
var result = service.findAll();
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@GetMapping("/optimized")
public ResponseEntity<List<MagazineDto>> findAllOptimized() {
var result = service.findAllOptimized();
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@PostMapping
public ResponseEntity<MagazineDto> save(@RequestBody MagazineDto dto) {
if (dto == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dto);
var result = service.create(item);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@PostMapping("/all")
public ResponseEntity<List<MagazineDto>> save(@RequestBody List<MagazineDto> dtos) {
if (dtos == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dtos);
var result = service.create(item);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@PutMapping()
public ResponseEntity<MagazineDto> update(@RequestBody MagazineDto dto) {
if (dto == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dto);
var result = service.update(item);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@PutMapping("/all")
public ResponseEntity<List<MagazineDto>> update(@RequestBody List<MagazineDto> dtos) {
if (dtos == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dtos);
var result = service.update(item);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@DeleteMapping
public ResponseEntity<MagazineDto> delete(@RequestBody MagazineDto dto) {
if (dto == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dto);
service.delete(item);
return ResponseEntity.ok(dto);
}
@DeleteMapping("/all")
public ResponseEntity<List<MagazineDto>> delete(@RequestBody List<MagazineDto> dtos) {
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
@DeleteMapping("/genre/id/{id}")
public ResponseEntity<Long> deleteByGenreId(@PathVariable Long id){
service.deleteByGenreId(id);
return ResponseEntity.ok(id);
}
@GetMapping("/genre/id/{id}")
public ResponseEntity<List<MagazineDto>> findByGenreId(@PathVariable Long id){
var result = service.findByGenreId(id);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@DeleteMapping("/publisher/id/{id}")
public ResponseEntity<Long> deleteByPublisherId(@PathVariable Long id){
service.deleteByPublisherId(id);
return ResponseEntity.ok(id);
}
@GetMapping("/publisher/id/{id}")
public ResponseEntity<List<MagazineDto>> findByPublisherId(@PathVariable Long id){
var result = service.findByPublisherId(id);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
}