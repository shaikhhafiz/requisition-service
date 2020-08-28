package com.hafiz.erp.inventoryservice.controllers;

import com.hafiz.erp.inventoryservice.core.constants.EndPoint;
import com.hafiz.erp.inventoryservice.core.crud.CrudController;
import com.hafiz.erp.inventoryservice.dataclass.ItemRequisitionCreateDTO;
import com.hafiz.erp.inventoryservice.dataclass.ItemRequisitionResponseDTO;
import com.hafiz.erp.inventoryservice.dataclass.ItemRequisitionUpdateDTO;
import com.hafiz.erp.inventoryservice.entities.ItemRequisition;
import com.hafiz.erp.inventoryservice.services.ItemRequisitionService;
import com.hafiz.erp.inventoryservice.services.ItemRequisitionWrapperService;
import com.hafiz.erp.inventoryservice.utility.ItemRequisitionConversionUtility;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(EndPoint.ITEM_REQUISITION)
public class ItemRequisitionController extends CrudController<ItemRequisition, ItemRequisitionResponseDTO, ItemRequisitionCreateDTO, ItemRequisitionUpdateDTO> {

    private final ItemRequisitionWrapperService wrapperService;

    ItemRequisitionController(ItemRequisitionService service, ItemRequisitionConversionUtility conversionUtility,
                              ItemRequisitionWrapperService wrapperService) {
        super(service, conversionUtility);
        this.wrapperService = wrapperService;
    }

    @PostMapping
    public ItemRequisitionResponseDTO create(@RequestBody ItemRequisitionCreateDTO d) {
        return wrapperService.createRequisitionWithDetails(d);
    }

}
