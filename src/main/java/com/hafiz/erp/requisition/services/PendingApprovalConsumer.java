package com.hafiz.erp.requisition.services;

import com.hafiz.erp.requisition.dataclass.ApprovalDTO;
import com.hafiz.erp.requisition.entities.ItemRequisition;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PendingApprovalConsumer {

  private final ItemRequisitionService requisitionService;

  public PendingApprovalConsumer(ItemRequisitionService requisitionService) {
    this.requisitionService = requisitionService;
  }

  @KafkaListener(id = "pendingApprovalGroup", topics = "pending-approval")
  public void listenPendingApproval(ApprovalDTO dto) {
    Optional<ItemRequisition> requisition = requisitionService.getById(dto.getSourceRecordId());
    requisition.ifPresent(itemRequisition -> itemRequisition.setStatus(dto.getStatus()));
    requisitionService.update(requisition);
  }
}
