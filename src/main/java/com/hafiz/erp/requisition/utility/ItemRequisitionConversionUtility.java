package com.hafiz.erp.requisition.utility;

import com.hafiz.erp.requisition.core.crud.ConversionUtility;
import com.hafiz.erp.requisition.dataclass.ItemRequisitionDTO;
import com.hafiz.erp.requisition.entities.ItemRequisition;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ItemRequisitionConversionUtility extends ConversionUtility<ItemRequisition, ItemRequisitionDTO> {
    ItemRequisitionConversionUtility(ModelMapper modelMapper) {
        super(modelMapper, ItemRequisition.class, ItemRequisitionDTO.class);
    }
}
