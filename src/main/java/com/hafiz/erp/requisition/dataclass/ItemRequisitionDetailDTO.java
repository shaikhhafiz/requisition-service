package com.hafiz.erp.requisition.dataclass;

import com.hafiz.erp.requisition.core.crud.IdHolder;
import com.hafiz.erp.requisition.validatorgroup.CreateValidatorGroup;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.UUID;

@Data
public class ItemRequisitionDetailDTO extends IdHolder {
    private UUID reqId;
    @NotEmpty(groups = {CreateValidatorGroup.class})
    private BigDecimal qty;
    @NotEmpty(groups = {CreateValidatorGroup.class})
    private UUID specValueId;
}
