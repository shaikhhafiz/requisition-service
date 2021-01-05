package com.hafiz.erp.requisition.dataclass;

import com.hafiz.erp.requisition.core.crud.IdHolder;
import com.hafiz.erp.requisition.validatorgroup.CreateValidatorGroup;
import com.hafiz.erp.requisition.validatorgroup.UpdateValidatorGroup;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.UUID;

@Data
public class ItemRequisitionDetailDTO extends IdHolder {
    private UUID reqId;
    @NotBlank(groups = {CreateValidatorGroup.class, UpdateValidatorGroup.class})
    private BigDecimal qty;
    @NotBlank(groups = {CreateValidatorGroup.class, UpdateValidatorGroup.class})
    private UUID specValueId;
}
