package com.hafiz.erp.inventoryservice.utility;

import com.hafiz.erp.inventoryservice.core.crud.ConversionUtility;
import com.hafiz.erp.inventoryservice.dataclass.ItemRequisitionResponseDTO;
import com.hafiz.erp.inventoryservice.entities.ItemRequisition;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ItemRequisitionConversionUtility extends ConversionUtility<ItemRequisition, ItemRequisitionResponseDTO> {
    ItemRequisitionConversionUtility(ModelMapper modelMapper) {
        super(modelMapper, ItemRequisition.class, ItemRequisitionResponseDTO.class);
    }
}
