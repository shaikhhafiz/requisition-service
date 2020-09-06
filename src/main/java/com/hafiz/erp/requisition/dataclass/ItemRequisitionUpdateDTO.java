package com.hafiz.erp.requisition.dataclass;

import com.hafiz.erp.requisition.core.crud.IdHolder;
import lombok.Data;

import java.util.UUID;

@Data
public class ItemRequisitionUpdateDTO extends IdHolder {
    private UUID storeId;
    private String status;
}
