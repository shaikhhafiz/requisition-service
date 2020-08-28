package com.hafiz.erp.inventoryservice.dataclass;

import com.hafiz.erp.inventoryservice.core.crud.IdHolder;
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
