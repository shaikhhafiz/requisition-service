package com.hafiz.erp.requisition.entities;

import com.hafiz.erp.requisition.core.crud.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@Entity
@Table(name = "item_requisition_detail")
public class ItemRequisitionDetail extends BaseEntity {
    private UUID reqId;
    private BigDecimal qty;
    private UUID specValueId;
}
