package com.hafiz.erp.requisition.dataclass;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class ItemRequisitionDetailCreateDTO {
    private UUID reqId;
    private BigDecimal qty;
    private UUID specValueId;
}
