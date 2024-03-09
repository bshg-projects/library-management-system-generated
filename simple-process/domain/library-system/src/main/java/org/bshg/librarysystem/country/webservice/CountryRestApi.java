package org.bshg.librarysystem.country.webservice;
import org.bshg.librarysystem.country.Country;
import org.bshg.librarysystem.country.services.CountryService;
import org.bshg.librarysystem.country.sprocess.create.CreateCountryProcess;
import org.bshg.librarysystem.country.sprocess.update.UpdateCountryProcess;
import org.bshg.librarysystem.country.sprocess.delete.DeleteCountryProcess;
import org.bshg.librarysystem.country.webservice.CountryConverter;
import org.bshg.librarysystem.country.webservice.CountryDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController
@RequestMapping("/api/country")
public class CountryRestApi {
protected CountryService service;
protected CountryConverter converter;
protected CreateCountryProcess createProcess;
protected UpdateCountryProcess updateProcess;
protected DeleteCountryProcess deleteProcess;
@GetMapping("/id/{id}")
public ResponseEntity<CountryDto> findById(@PathVariable Long id) {
Country item = service.findById(id);
if (item == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
converter.init(true);
CountryDto dto = converter.toDto(item);
return ResponseEntity.ok(dto);
}
@GetMapping
public ResponseEntity<List<CountryDto>> findAll() {
List<Country> all = service.findAll();
List<CountryDto> dtos = converter.toDto(all);
return ResponseEntity.ok(dtos);
}
@GetMapping("/optimized")
public ResponseEntity<List<CountryDto>> findAllOptimized() {
List<Country> all = service.findAllOptimized();
List<CountryDto> dtos = converter.toDto(all);
return ResponseEntity.ok(dtos);
}
@PostMapping
public ResponseEntity<CountryDto> save(@RequestBody CountryDto dto) {
converter.init(true);
Country item = converter.toItem(dto);
item = createProcess.run(item);
return new ResponseEntity<>(converter.toDto(item), HttpStatus.CREATED);
}
@PostMapping("/all")
public ResponseEntity<List<CountryDto>> save(@RequestBody List<CountryDto> dtos) {
converter.init(true);
List<Country> items = converter.toItem(dtos);
items = createProcess.run(items);
return new ResponseEntity<>(converter.toDto(items), HttpStatus.CREATED);
}
@PutMapping()
public ResponseEntity<CountryDto> update(@RequestBody CountryDto dto) {
converter.init(true);
Country item = converter.toItem(dto);
item = updateProcess.run(item);
return ResponseEntity.ok(converter.toDto(item));
}
@PutMapping("/all")
public ResponseEntity<List<CountryDto>> update(@RequestBody List<CountryDto> dtos) {
converter.init(true);
List<Country> items = converter.toItem(dtos);
items = updateProcess.run(items);
return ResponseEntity.ok(converter.toDto(items));
}
@DeleteMapping
public ResponseEntity<CountryDto> delete(@RequestBody CountryDto dto) {
converter.init(false);
Country item = converter.toItem(dto);
deleteProcess.run(item);
return ResponseEntity.ok(dto);
}
@DeleteMapping("/all")
public ResponseEntity<List<CountryDto>> delete(@RequestBody List<CountryDto> dtos) {
converter.init(false);
List<Country> items = converter.toItem(dtos);
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