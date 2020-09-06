package com.hafiz.erp.requisition.core.crud;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ICrudService<E extends BaseEntity> {
    List<E> getList();
    Optional<E> getById(UUID id);
    Optional<E> create(Optional<E> e);
    List<E> createAll(List<E> e);
    Optional<E> update(Optional<E> e) throws Exception;
    void deleteById(Optional<UUID> id);
}
