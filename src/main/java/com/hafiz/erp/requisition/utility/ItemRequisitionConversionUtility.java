package com.hafiz.erp.requisition.utility;

import com.hafiz.erp.requisition.core.crud.ConversionUtility;
import com.hafiz.erp.requisition.dataclass.ItemRequisitionResponseDTO;
import com.hafiz.erp.requisition.entities.ItemRequisition;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ItemRequisitionConversionUtility extends ConversionUtility<ItemRequisition, ItemRequisitionResponseDTO> {
    ItemRequisitionConversionUtility(ModelMapper modelMapper) {
        super(modelMapper, ItemRequisition.class, ItemRequisitionResponseDTO.class);
    }
}
