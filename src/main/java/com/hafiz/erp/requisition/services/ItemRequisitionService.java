package com.hafiz.erp.requisition.services;

import com.hafiz.erp.requisition.core.crud.CrudService;
import com.hafiz.erp.requisition.entities.ItemRequisition;
import com.hafiz.erp.requisition.repositories.ItemRequisitionRepository;
import org.springframework.stereotype.Service;

@Service
public class ItemRequisitionService extends CrudService<ItemRequisition> {

    public ItemRequisitionService(ItemRequisitionRepository repository) {
        super(repository);
    }
}
