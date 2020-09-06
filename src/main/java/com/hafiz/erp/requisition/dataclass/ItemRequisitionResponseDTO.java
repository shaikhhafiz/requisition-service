package com.hafiz.erp.requisition.dataclass;

import com.hafiz.erp.requisition.core.crud.IdHolder;
import lombok.Data;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Data
public class ItemRequisitionResponseDTO extends IdHolder {
    private UUID storeId;
    private String refNo;
    private Date reqDate;
    private String status;
    private Set<ItemRequisitionDetailResponseDTO> details;
}
