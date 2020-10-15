package com.hafiz.erp.requisition.dataclass;

import com.hafiz.erp.requisition.core.crud.IdHolder;
import lombok.Data;

import java.util.UUID;

@Data
public class ApprovalResponseDTO extends IdHolder {
  private UUID sourceRecordId;
  private String source;
  private String status;
}
