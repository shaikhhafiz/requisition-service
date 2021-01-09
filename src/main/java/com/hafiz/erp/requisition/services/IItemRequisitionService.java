package com.hafiz.erp.requisition.services;

import com.hafiz.erp.requisition.entities.ItemRequisition;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IItemRequisitionService {
  List<ItemRequisition> getList();
  Optional<ItemRequisition> getById(UUID id);
  ItemRequisition create(Optional<ItemRequisition> entity);
  List<ItemRequisition> createAll(List<ItemRequisition> entities);
  Optional<ItemRequisition> update(Optional<ItemRequisition> entity);
  void deleteById(Optional<UUID> id);
}
