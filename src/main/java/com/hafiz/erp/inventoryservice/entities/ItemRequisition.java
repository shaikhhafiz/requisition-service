package com.hafiz.erp.inventoryservice.entities;

import com.hafiz.erp.inventoryservice.core.crud.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(name = "item_requisition")
public class ItemRequisition extends BaseEntity {
    private UUID storeId;
    private String refNo;
    private Date reqDate;
    private String status;
}
