package com.hafiz.erp.requisition.core.crud;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ICrudService<E extends BaseEntity> {
    List<E> getList();
    Optional<E> getById(UUID id);
    E create(Optional<E> e);
    List<E> createAll(List<E> e);
    E update(Optional<E> e);
    void deleteById(Optional<UUID> id);
}
