package com.hafiz.erp.requisition.core.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.support.converter.BatchMessagingMessageConverter;
import org.springframework.kafka.support.converter.RecordMessageConverter;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;

@Configuration
public class KafkaConfig {

  @Bean
  public NewTopic pendingApproval() {
    return TopicBuilder.name("pending-approval").partitions(1).replicas(1).build();
  }

  @Bean
  public RecordMessageConverter converter() {
    return new StringJsonMessageConverter();
  }

  @Bean
  public BatchMessagingMessageConverter batchConverter() {
    return new BatchMessagingMessageConverter(converter());
  }

}
