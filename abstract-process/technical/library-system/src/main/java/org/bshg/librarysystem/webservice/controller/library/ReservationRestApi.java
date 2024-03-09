package org.bshg.librarysystem.webservice.controller.library;
import org.bshg.librarysystem.entity.core.library.Reservation;
import org.bshg.librarysystem.services.facade.library.ReservationService;
import org.bshg.librarysystem.sprocess.library.reservation.facade.CreateReservationProcess;
import org.bshg.librarysystem.sprocess.library.reservation.facade.UpdateReservationProcess;
import org.bshg.librarysystem.sprocess.library.reservation.facade.DeleteReservationProcess;
import org.bshg.librarysystem.webservice.converter.library.ReservationConverter;
import org.bshg.librarysystem.webservice.dto.library.ReservationDto;
import org.bshg.librarysystem.utils.webservice.restapi.AbstractRestApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/reservation")
public class ReservationRestApi extends AbstractRestApi<
Reservation,
ReservationDto,
ReservationService,
ReservationConverter,
CreateReservationProcess,
UpdateReservationProcess,
DeleteReservationProcess> {
public ReservationRestApi( ReservationService service, ReservationConverter converter, CreateReservationProcess createProcess, UpdateReservationProcess updateProcess, DeleteReservationProcess deleteProcess) {
super(service, converter, createProcess, updateProcess, deleteProcess);
}
@Override
@GetMapping("/id/{id}")
public ResponseEntity<ReservationDto> findById(@PathVariable Long id) {
return super.findById(id);
}
@Override
@GetMapping
public ResponseEntity<List<ReservationDto>> findAll() {
return super.findAll();
}
@Override
@GetMapping("/optimized")
public ResponseEntity<List<ReservationDto>> findAllOptimized() {
return super.findAllOptimized();
}
@Override
@PostMapping
public ResponseEntity<ReservationDto> save(@RequestBody ReservationDto dto) {
return super.save(dto);
}
@Override
@PostMapping("/all")
public ResponseEntity<List<ReservationDto>> save(@RequestBody List<ReservationDto> dtos) {
return super.save(dtos);
}
@Override
@PutMapping()
public ResponseEntity<ReservationDto> update(@RequestBody ReservationDto dto) {
return super.update(dto);
}
@Override
@PutMapping("/all")
public ResponseEntity<List<ReservationDto>> update(@RequestBody List<ReservationDto> dtos) {
return super.update(dtos);
}
@Override
@DeleteMapping
public ResponseEntity<ReservationDto> delete(@RequestBody ReservationDto dto) {
return super.delete(dto);
}
@Override
@DeleteMapping("/all")
public ResponseEntity<List<ReservationDto>> delete(@RequestBody List<ReservationDto> dtos) {
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
public ResponseEntity<ReservationDto> findByBookId(@PathVariable Long id){
return super.findByChildId(id, service::findByBookId);
}
@DeleteMapping("/client/id/{id}")
public ResponseEntity<Long> deleteByClientId(@PathVariable Long id){
return super.deleteProcess(id, service::deleteByClientId);
}
@GetMapping("/client/id/{id}")
public ResponseEntity<List<ReservationDto>> findByClientId(@PathVariable Long id){
return super.findListByChildId(id, service::findByClientId);
}
}