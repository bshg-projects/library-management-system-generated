package org.bshg.librarysystem.utils.webservice.restapi;

import org.bshg.librarysystem.utils.entity.audit.AuditEntity;
import org.bshg.librarysystem.utils.service.IService;
import org.bshg.librarysystem.utils.webservice.converter.AbstractConverter;
import org.bshg.librarysystem.utils.webservice.dto.BaseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.LongFunction;

public abstract class AbstractRestApi<T extends AuditEntity, DTO extends BaseDto, SERV extends IService<T>, CONV extends AbstractConverter<T, DTO>> extends RestApiHelper {
    protected SERV service;
    protected AbstractConverter<T, DTO> converter;

    protected AbstractRestApi(SERV service, CONV converter) {
        this.service = service;
        this.converter = converter;
    }

    protected ResponseEntity<DTO> findById(Long id) {
        T item = service.findById(id);
        return sendResponse(item == null, HttpStatus.NOT_FOUND, () -> {
            converter.init(true);
            DTO dto = converter.toDto(item);
            return success(dto);
        });
    }

    protected ResponseEntity<List<DTO>> findAll() {
        List<T> all = service.findAll();
        List<DTO> dtos = converter.toDto(all);
        return success(dtos);
    }

    protected ResponseEntity<List<DTO>> findAllOptimized() {
        List<T> list = service.findAllOptimized();
        List<DTO> dtos = converter.toDto(list);
        return sendResponses(dtos != null && !dtos.isEmpty(), () -> success(dtos));
    }

    protected ResponseEntity<DTO> save(DTO dto) {
        return sendResponse(dto == null, () -> {
            converter.init(true);
            T myT = converter.toItem(dto);
            T item = service.create(myT);
            DTO myDto = converter.toDto(item);
            return new ResponseEntity<>(myDto, HttpStatus.CREATED);
        });
    }

    protected ResponseEntity<List<DTO>> save(List<DTO> dtos) {
        return sendResponse(dtos == null, () -> {
            converter.init(true);
            List<T> myT = converter.toItem(dtos);
            List<T> ts = service.create(myT);
            List<DTO> myDto = converter.toDto(ts);
            return new ResponseEntity<>(myDto, HttpStatus.CREATED);
        });
    }

    protected ResponseEntity<DTO> update(DTO dtos) {
        return sendResponse((dtos == null), () -> {
            T ts = converter.toItem(dtos);
            T updated = service.update(ts);
            DTO myDtos = converter.toDto(updated);
            return success(myDtos);
        });
    }

    protected ResponseEntity<List<DTO>> update(List<DTO> dtos) {
        return sendResponse((dtos == null), () -> {
            List<T> ts = converter.toItem(dtos);
            List<T> updated = service.update(ts);
            List<DTO> myDtos = converter.toDto(updated);
            return success(myDtos);
        });
    }

    protected ResponseEntity<DTO> delete(DTO dto) {
        return sendResponse(dto == null, () -> {
            converter.init(false);
            T item = converter.toItem(dto);
            service.delete(item);
            return success(dto);
        });
    }

    protected ResponseEntity<List<DTO>> delete(List<DTO> dtos) {
        return sendResponses((dtos != null && !dtos.isEmpty()), () -> {
            converter.init(false);
            List<T> ts = converter.toItem(dtos);
            service.delete(ts);
            return success(dtos);
        });
    }

    protected ResponseEntity<Long> deleteById(Long id) {
        return sendResponse(id == null, () -> {
            service.deleteById(id);
            return success(id);
        });
    }

    protected ResponseEntity<List<Long>> deleteByIdIn(List<Long> ids) {
        return sendResponse(ids == null, () -> {
            service.deleteByIdIn(ids);
            return success(ids);
        });
    }

    public ResponseEntity<List<DTO>> findListByChildId(Long id, LongFunction<List<T>> getter) {
        List<T> ts = getter.apply(id);
        List<DTO> dtos = converter.toDto(ts);
        return ResponseEntity.ok(dtos);
    }

    public ResponseEntity<DTO> findByChildId(Long id, LongFunction<T> getter) {
        T item = getter.apply(id);
        DTO dto = converter.toDto(item);
        return ResponseEntity.ok(dto);
    }

    protected <O> ResponseEntity<O> deleteProcess(O object, Consumer<O> process) {
        ResponseEntity<O> res;
        HttpStatus status = HttpStatus.CONFLICT;
        if (object != null) {
            process.accept(object);
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(object, status);
        return res;
    }
}
