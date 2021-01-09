package com.hafiz.erp.requisition.services;

import com.hafiz.erp.requisition.entities.ItemRequisition;
import com.hafiz.erp.requisition.repositories.ItemRequisitionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.*;

public class ItemRequisitionServiceUnitTest {

  @Test
  @DisplayName("Create item requisition with valid data will return entity")
  void Create_Item_Requisition_With_Valid_Data_Return_Success() {
    //Arrange
    ItemRequisitionRepository repository = Mockito.mock(ItemRequisitionRepository.class);
    IItemRequisitionService service = new ItemRequisitionService(repository);
    //TODO Find a wat to create mock object
    Optional<ItemRequisition> builtEntity = this.buildItemRequisition();
    Mockito.when(repository.save(builtEntity.get())).thenReturn(builtEntity.get());

    //Execute
    ItemRequisition entity = service.create(builtEntity);

    //Assert
    Assertions.assertNotNull(entity, () -> "Expected Not null entity");
  }

  @Test
  @DisplayName("Get item requisition list length will return exact same length what repository will return")
  void Get_Item_Requisition_List_Length_Return_Equal_To_Entity_List_Length() {
    //Arrange
    ItemRequisitionRepository repository = Mockito.mock(ItemRequisitionRepository.class);
    IItemRequisitionService service = new ItemRequisitionService(repository);
    Mockito.when(repository.findAll()).thenReturn(Collections.singletonList(new ItemRequisition()));

    //Execute
    List<ItemRequisition> list = service.getList();
    long expectedSize = list.size();

    //Assert
    Assertions.assertEquals(expectedSize, 1);
  }

  private Optional<ItemRequisition> buildItemRequisition(){
    ItemRequisition requisition = new ItemRequisition();
    requisition.setId(UUID.randomUUID());
    requisition.setRefNo("ref-no-test");
    requisition.setReqDate(new Date());
    requisition.setStatus("New");
    requisition.setIsDeleted(Boolean.FALSE);
    requisition.setCreatedAt(new Date());
    requisition.setCreatedBy(UUID.randomUUID());
    return Optional.of(requisition);
  }
}
