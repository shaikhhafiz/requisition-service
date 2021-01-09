package com.hafiz.erp.requisition.core.crud;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.FeatureDescriptor;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequiredArgsConstructor
public class ConversionUtility<E extends BaseEntity, D> {
    private final ModelMapper mapper;
    private final Type entityType;
    private final Type dtoType;

    public <C> Optional<E> buildEntityForCreate(Optional<C> s) {
        return Optional.of(mapper.map(s.get(), entityType));
    }

    public <C> Optional<E> buildEntityForUpdate(Optional<C> s, E e) {
        BeanUtils.copyProperties(s.get(),e, getNullPropertyNames(s.get()));
        return Optional.of(e);
    }

    public Optional<D> getDto(Optional<E> e) {
        return e.<Optional<D>>map(value -> Optional.of(mapper.map(value, dtoType))).orElse(null);
    }

    public List<D> getDtoList(List<E> entities) {
        return entities.stream().map(Optional::of).map(this::getDto).map(Optional::get).collect(Collectors.toList());
    }

    private static String[] getNullPropertyNames(Object source) {
        final BeanWrapper wrappedSource = new BeanWrapperImpl(source);
        return Stream.of(wrappedSource.getPropertyDescriptors())
            .map(FeatureDescriptor::getName)
            .filter(propertyName -> wrappedSource.getPropertyValue(propertyName) == null)
            .toArray(String[]::new);
    }
}
