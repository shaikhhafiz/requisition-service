package com.hafiz.erp.requisition.services;

import com.hafiz.erp.requisition.core.crud.CrudService;
import com.hafiz.erp.requisition.entities.ItemRequisitionDetail;
import com.hafiz.erp.requisition.repositories.ItemRequisitionDetailRepository;
import org.springframework.stereotype.Service;

@Service
public class ItemRequisitionDetailService extends CrudService<ItemRequisitionDetail> {

    public ItemRequisitionDetailService(ItemRequisitionDetailRepository repository) {
        super(repository);
    }
}
