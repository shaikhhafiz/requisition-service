package com.hafiz.erp.requisition.services;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PendingApprovalConsumer {

  //TODO Do something consuming pending-approval topic
  @KafkaListener(id = "pendingApprovalGroup", topics = "pending-approval")
  public void listenPendingApproval(List<?> in) {

  }
}
