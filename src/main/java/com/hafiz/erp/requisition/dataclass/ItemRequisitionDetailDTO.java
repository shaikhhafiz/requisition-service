package com.hafiz.erp.requisition.dataclass;

import com.hafiz.erp.requisition.core.crud.IdHolder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class ItemRequisitionDetailDTO extends IdHolder {
    private UUID reqId;
    private BigDecimal qty;
    private UUID specValueId;
}
