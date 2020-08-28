package com.hafiz.erp.inventoryservice.services;

import com.hafiz.erp.inventoryservice.core.crud.CrudService;
import com.hafiz.erp.inventoryservice.entities.ItemRequisitionDetail;
import com.hafiz.erp.inventoryservice.repositories.ItemRequisitionDetailRepository;
import org.springframework.stereotype.Service;

@Service
public class ItemRequisitionDetailService extends CrudService<ItemRequisitionDetail> {

    public ItemRequisitionDetailService(ItemRequisitionDetailRepository repository) {
        super(repository);
    }
}
