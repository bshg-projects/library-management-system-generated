package org.bshg.librarysystem.webservice.controller.library;
import org.bshg.librarysystem.entity.core.library.Country;
import org.bshg.librarysystem.services.facade.library.CountryService;
import org.bshg.librarysystem.sprocess.library.country.facade.CreateCountryProcess;
import org.bshg.librarysystem.sprocess.library.country.facade.UpdateCountryProcess;
import org.bshg.librarysystem.sprocess.library.country.facade.DeleteCountryProcess;
import org.bshg.librarysystem.webservice.converter.library.CountryConverter;
import org.bshg.librarysystem.webservice.dto.library.CountryDto;
import org.bshg.librarysystem.utils.webservice.restapi.AbstractRestApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/country")
public class CountryRestApi extends AbstractRestApi<
Country,
CountryDto,
CountryService,
CountryConverter,
CreateCountryProcess,
UpdateCountryProcess,
DeleteCountryProcess> {
public CountryRestApi( CountryService service, CountryConverter converter, CreateCountryProcess createProcess, UpdateCountryProcess updateProcess, DeleteCountryProcess deleteProcess) {
super(service, converter, createProcess, updateProcess, deleteProcess);
}
@Override
@GetMapping("/id/{id}")
public ResponseEntity<CountryDto> findById(@PathVariable Long id) {
return super.findById(id);
}
@Override
@GetMapping
public ResponseEntity<List<CountryDto>> findAll() {
return super.findAll();
}
@Override
@GetMapping("/optimized")
public ResponseEntity<List<CountryDto>> findAllOptimized() {
return super.findAllOptimized();
}
@Override
@PostMapping
public ResponseEntity<CountryDto> save(@RequestBody CountryDto dto) {
return super.save(dto);
}
@Override
@PostMapping("/all")
public ResponseEntity<List<CountryDto>> save(@RequestBody List<CountryDto> dtos) {
return super.save(dtos);
}
@Override
@PutMapping()
public ResponseEntity<CountryDto> update(@RequestBody CountryDto dto) {
return super.update(dto);
}
@Override
@PutMapping("/all")
public ResponseEntity<List<CountryDto>> update(@RequestBody List<CountryDto> dtos) {
return super.update(dtos);
}
@Override
@DeleteMapping
public ResponseEntity<CountryDto> delete(@RequestBody CountryDto dto) {
return super.delete(dto);
}
@Override
@DeleteMapping("/all")
public ResponseEntity<List<CountryDto>> delete(@RequestBody List<CountryDto> dtos) {
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
}