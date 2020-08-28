package com.hafiz.erp.inventoryservice.dataclass;

import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
public class ItemRequisitionCreateDTO {
    private String refNo;
    private Date reqDate;
    private String status;
    private Set<ItemRequisitionDetailCreateDTO> details;
}
