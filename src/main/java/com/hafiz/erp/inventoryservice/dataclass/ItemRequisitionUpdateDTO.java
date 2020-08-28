package com.hafiz.erp.inventoryservice.dataclass;

import com.hafiz.erp.inventoryservice.core.crud.IdHolder;
import lombok.Data;

import java.util.UUID;

@Data
public class ItemRequisitionUpdateDTO extends IdHolder {
    private UUID storeId;
    private String status;
}
