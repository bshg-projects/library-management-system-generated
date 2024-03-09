package org.bshg.librarysystem.webservice.library.librarybranch;
import org.bshg.librarysystem.entity.core.library.LibraryBranch;
import org.bshg.librarysystem.services.library.librarybranch.LibraryBranchService;
import org.bshg.librarysystem.webservice.library.librarybranch.LibraryBranchConverter;
import org.bshg.librarysystem.webservice.library.librarybranch.LibraryBranchDto;
import org.bshg.librarysystem.utils.webservice.restapi.AbstractRestApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/librarybranch")
public class LibraryBranchRestApi extends AbstractRestApi<LibraryBranch,LibraryBranchDto,LibraryBranchService,LibraryBranchConverter> {
public LibraryBranchRestApi( LibraryBranchService service, LibraryBranchConverter converter) {
super(service, converter);
}
@Override
@GetMapping("/id/{id}")
public ResponseEntity<LibraryBranchDto> findById(@PathVariable Long id) {
return super.findById(id);
}
@Override
@GetMapping
public ResponseEntity<List<LibraryBranchDto>> findAll() {
return super.findAll();
}
@Override
@GetMapping("/optimized")
public ResponseEntity<List<LibraryBranchDto>> findAllOptimized() {
return super.findAllOptimized();
}
@Override
@PostMapping
public ResponseEntity<LibraryBranchDto> save(@RequestBody LibraryBranchDto dto) {
return super.save(dto);
}
@Override
@PostMapping("/all")
public ResponseEntity<List<LibraryBranchDto>> save(@RequestBody List<LibraryBranchDto> dtos) {
return super.save(dtos);
}
@Override
@PutMapping()
public ResponseEntity<LibraryBranchDto> update(@RequestBody LibraryBranchDto dto) {
return super.update(dto);
}
@Override
@PutMapping("/all")
public ResponseEntity<List<LibraryBranchDto>> update(@RequestBody List<LibraryBranchDto> dtos) {
return super.update(dtos);
}
@Override
@DeleteMapping
public ResponseEntity<LibraryBranchDto> delete(@RequestBody LibraryBranchDto dto) {
return super.delete(dto);
}
@Override
@DeleteMapping("/all")
public ResponseEntity<List<LibraryBranchDto>> delete(@RequestBody List<LibraryBranchDto> dtos) {
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
public ResponseEntity<LibraryBranchDto> findByAddressId(@PathVariable Long id){
return super.findByChildId(id, service::findByAddressId);
}
}