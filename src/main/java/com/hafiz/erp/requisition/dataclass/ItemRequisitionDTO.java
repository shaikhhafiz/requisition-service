package com.hafiz.erp.requisition.dataclass;

import com.hafiz.erp.requisition.core.crud.IdHolder;
import com.hafiz.erp.requisition.validation.ValidDateFormat;
import com.hafiz.erp.requisition.validatorgroup.CreateValidatorGroup;
import com.hafiz.erp.requisition.validatorgroup.UpdateValidatorGroup;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Data
public class ItemRequisitionDTO extends IdHolder {
    @NotBlank(groups = {CreateValidatorGroup.class})
    private String refNo;
    //Not blank don't work on Date type variable. Have to find out why this happen.
    @NotNull(groups = {CreateValidatorGroup.class})
    @ValidDateFormat(groups = {UpdateValidatorGroup.class, CreateValidatorGroup.class})
    private Date reqDate;
    @NotBlank(groups = {CreateValidatorGroup.class, UpdateValidatorGroup.class})
    private String status;
    //@Valid annotation is needed to work validator group in nested object
    @NotEmpty(groups = {CreateValidatorGroup.class})
    @Valid
    private Set<ItemRequisitionDetailDTO> details;
}
