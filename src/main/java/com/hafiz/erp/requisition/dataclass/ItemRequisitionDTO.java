package com.hafiz.erp.requisition.dataclass;

import com.hafiz.erp.requisition.core.crud.IdHolder;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
public class ItemRequisitionDTO extends IdHolder {
    private String refNo;
    private Date reqDate;
    private String status;
    private Set<ItemRequisitionDetailDTO> details;
}
