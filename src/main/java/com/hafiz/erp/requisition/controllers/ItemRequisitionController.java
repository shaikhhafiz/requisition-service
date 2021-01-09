package com.hafiz.erp.requisition.controllers;

import com.hafiz.erp.requisition.core.constants.EndPoint;
import com.hafiz.erp.requisition.core.crud.CrudController;
import com.hafiz.erp.requisition.dataclass.ItemRequisitionDTO;
import com.hafiz.erp.requisition.entities.ItemRequisition;
import com.hafiz.erp.requisition.services.ItemRequisitionService;
import com.hafiz.erp.requisition.services.ItemRequisitionWrapperService;
import com.hafiz.erp.requisition.utility.ItemRequisitionConversionUtility;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(EndPoint.ITEM_REQUISITION)
public class ItemRequisitionController extends CrudController<ItemRequisition, ItemRequisitionDTO> {

    private final ItemRequisitionWrapperService wrapperService;

    ItemRequisitionController(ItemRequisitionService service, ItemRequisitionConversionUtility conversionUtility,
                              ItemRequisitionWrapperService wrapperService) {
        super(service, conversionUtility);
        this.wrapperService = wrapperService;
    }

    @Override
    public ItemRequisitionDTO create(@RequestBody ItemRequisitionDTO reqBody) {
        return wrapperService.createRequisitionWithDetails(reqBody);
    }

    @Override
    public ItemRequisitionDTO update(@RequestBody ItemRequisitionDTO reqBody, @PathVariable UUID id) {
        return wrapperService.updateRequisitionWithDetails(reqBody, id);
    }

}
