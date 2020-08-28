package com.hafiz.erp.inventoryservice.dataclass;

import com.hafiz.erp.inventoryservice.core.crud.IdHolder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class ItemRequisitionDetailResponseDTO extends IdHolder {
    private UUID reqId;
    private BigDecimal qty;
    private UUID specValueId;
}
