package com.hafiz.erp.requisition.dataclass;

import com.hafiz.erp.requisition.core.crud.IdHolder;
import com.hafiz.erp.requisition.validatorgroup.CreateValidatorGroup;
import com.hafiz.erp.requisition.validatorgroup.UpdateValidatorGroup;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

@Data
public class ItemRequisitionDetailDTO extends IdHolder {
    private UUID reqId;
    @NotNull(groups = {UpdateValidatorGroup.class, CreateValidatorGroup.class})
    private BigDecimal qty;
    //Not blank don't work on UUID type variable. Have to find out why this happen.
    @NotNull(groups = {UpdateValidatorGroup.class, CreateValidatorGroup.class})
    private UUID specValueId;
}
