package com.hafiz.erp.inventoryservice.services;

import com.hafiz.erp.inventoryservice.core.crud.CrudService;
import com.hafiz.erp.inventoryservice.entities.ItemRequisition;
import com.hafiz.erp.inventoryservice.repositories.ItemRequisitionRepository;
import org.springframework.stereotype.Service;

@Service
public class ItemRequisitionService extends CrudService<ItemRequisition> {

    public ItemRequisitionService(ItemRequisitionRepository repository) {
        super(repository);
    }
}
