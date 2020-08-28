package com.hafiz.erp.inventoryservice.utility;

import com.hafiz.erp.inventoryservice.core.crud.ConversionUtility;
import com.hafiz.erp.inventoryservice.dataclass.ItemRequisitionDetailResponseDTO;
import com.hafiz.erp.inventoryservice.entities.ItemRequisitionDetail;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ItemRequisitionDetailConversionUtility extends ConversionUtility<ItemRequisitionDetail, ItemRequisitionDetailResponseDTO> {
    ItemRequisitionDetailConversionUtility(ModelMapper modelMapper) {
        super(modelMapper, ItemRequisitionDetail.class, ItemRequisitionDetailResponseDTO.class);
    }
}
