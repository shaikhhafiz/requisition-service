package com.hafiz.erp.inventoryservice.core.crud;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ConversionUtility<E extends BaseEntity, D> {
    private final ModelMapper mapper;
    private final Type entityType;
    private final Type dtoType;

    public <C> Optional<E> buildEntity(Optional<C> s) {
        return Optional.of(mapper.map(s.get(), entityType));
    }

//    public <C> void updateEntity(Optional<C> s, E e) {
//        BeanUtils.copyProperties(s,e);
//    }

    public Optional<D> getDto(Optional<E> e) {
        return e.<Optional<D>>map(value -> Optional.of(mapper.map(value, dtoType))).orElse(null);
    }

    public List<D> getDtoList(List<E> entities) {
        return entities.stream().map(Optional::of).map(this::getDto).map(Optional::get).collect(Collectors.toList());
    }
}
