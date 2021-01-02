package com.hafiz.erp.requisition.dataclass;

import com.hafiz.erp.requisition.core.crud.IdHolder;
import com.hafiz.erp.requisition.validatorgroup.CreateValidatorGroup;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.Set;

@Data
public class ItemRequisitionDTO extends IdHolder {
    @NotEmpty(groups = {CreateValidatorGroup.class})
    private String refNo;
    @NotEmpty(groups = {CreateValidatorGroup.class})
    private Date reqDate;
    @NotEmpty(groups = {CreateValidatorGroup.class})
    private String status;
    @NotEmpty(groups = {CreateValidatorGroup.class})
    private Set<ItemRequisitionDetailDTO> details;
}
