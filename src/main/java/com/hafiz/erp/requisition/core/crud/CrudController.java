package com.hafiz.erp.requisition.core.crud;

import com.hafiz.erp.requisition.validatorgroup.CreateValidatorGroup;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public abstract class CrudController<E extends BaseEntity, D extends IdHolder> {
    private final CrudService<E> service;
    private final ConversionUtility<E, D> conversionUtility;
    @GetMapping
    public List<D> getList() {
        return conversionUtility.getDtoList(service.getList());
    }

    @GetMapping("{id}")
    public D getById(@PathVariable UUID id){
        return conversionUtility.getDto(service.getById(id)).orElse(null);
    }

    @PostMapping
    public D create(@RequestBody @Validated({CreateValidatorGroup.class}) D d) {
        return conversionUtility.getDto(
            Optional.ofNullable(
                service.create(
                    conversionUtility.buildEntity(Optional.of(d))
                )
            )
        ).orElse(null);
    }

    @PutMapping("{id}")
    public D update(@RequestBody D d, @PathVariable UUID id) {
        Optional<E> e = service.getById(id);
        d.setId(id);
        e.ifPresent(value -> BeanUtils.copyProperties(d, value));
        return conversionUtility.getDto(service.update(e)).orElse(null);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable UUID id) {
        service.deleteById(Optional.of(id));
    }
}
