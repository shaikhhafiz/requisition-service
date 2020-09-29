package com.hafiz.erp.requisition.core.crud;

import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public abstract class CrudService<E extends BaseEntity> implements ICrudService<E> {

    private final ICrudRepository<E, UUID> repository;

    @Override
    public List<E> getList() {
        return repository.findAll();
    }

    @Override
    public Optional<E> getById(UUID id) {
        return repository.findById(id);
    }

    @Override
    public E create(Optional<E> entity) {
        if(!entity.isPresent()) return entity.get();
        E createdEntity = null;
        entity.ifPresent(e -> e.setId(null));
        if(entity.isPresent()) {
            entity = this.getEntity(entity.get());
            createdEntity = repository.save(entity.get());
        }
        return createdEntity;
    }

    @Override
    public List<E> createAll(List<E> entities) {
        entities = entities.stream().peek(e -> e.setId(null)).map(this::getEntity).map(Optional::get).collect(Collectors.toList());
        return repository.saveAll(entities);
    }

    @Override
    public Optional<E> update(Optional<E> entity) {
        E updatedEntity = null;
        if(entity.isPresent()) {
            // TODO Through exception properly
            if(entity.get().getId() == null) System.out.println("Error");
            updatedEntity = repository.save(entity.get());
        }
        assert updatedEntity != null;
        return Optional.of(updatedEntity);
    }

    @Override
    public void deleteById(Optional<UUID> id) {
        id.ifPresent(repository::deleteById);
    }

    private Optional<E> getEntity(E e) {
        e.setCreatedAt(new Date());
        //TODO Set created by id in a common way
        e.setCreatedBy(UUID.randomUUID());
        e.setIsDeleted(Boolean.FALSE);
        return Optional.of(e);
    }
}
