package com.hafiz.erp.requisition.core.crud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.UUID;

@NoRepositoryBean
public interface ICrudRepository<T extends BaseEntity, ID extends UUID> extends JpaRepository<T, ID> {
}
