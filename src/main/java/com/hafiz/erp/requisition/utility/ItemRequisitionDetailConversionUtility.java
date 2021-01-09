package com.hafiz.erp.requisition.utility;

import com.hafiz.erp.requisition.core.crud.ConversionUtility;
import com.hafiz.erp.requisition.dataclass.ItemRequisitionDetailDTO;
import com.hafiz.erp.requisition.entities.ItemRequisitionDetail;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ItemRequisitionDetailConversionUtility extends ConversionUtility<ItemRequisitionDetail, ItemRequisitionDetailDTO> {
    ItemRequisitionDetailConversionUtility(ModelMapper modelMapper) {
        super(modelMapper, ItemRequisitionDetail.class, ItemRequisitionDetailDTO.class);
    }
}
