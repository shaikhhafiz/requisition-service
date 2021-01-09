package com.hafiz.erp.requisition.services;

import com.hafiz.erp.requisition.dataclass.ItemRequisitionDTO;
import com.hafiz.erp.requisition.entities.ItemRequisition;
import com.hafiz.erp.requisition.utility.ItemRequisitionConversionUtility;
import com.hafiz.erp.requisition.utility.ItemRequisitionDetailConversionUtility;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemRequisitionWrapperService {
    private final ItemRequisitionService service;
    private final ItemRequisitionConversionUtility conversionUtility;
    private final ItemRequisitionDetailService detailService;
    private final ItemRequisitionDetailConversionUtility detailConversionUtility;


    @Transactional
    public ItemRequisitionDTO createRequisitionWithDetails(ItemRequisitionDTO reqBody){
        //Create requisition
        Optional<ItemRequisitionDTO> resBody = conversionUtility.getDto(
            Optional.ofNullable(service.create(conversionUtility.buildEntityForCreate(Optional.of(reqBody)))));
        //Create requisition details
        resBody.ifPresent(itemRequisitionDTO -> createDetails(reqBody, itemRequisitionDTO.getId()));

        return resBody.orElse(null);
    }

    private void createDetails(ItemRequisitionDTO d, UUID reqId) {
        detailConversionUtility.getDtoList(
            detailService.createAll(
                d.getDetails().stream()
                    .peek(e -> e.setReqId(reqId))
                    .map(e -> detailConversionUtility.buildEntityForCreate(Optional.of(e)))
                    .map(Optional::get).collect(Collectors.toList())));
    }

    public ItemRequisitionDTO updateRequisitionWithDetails(ItemRequisitionDTO reqBody, UUID reqId) {
        //TODO implement update for details
        Optional<ItemRequisition> entity = service.getById(reqId);
        if(!entity.isPresent()) throw new RuntimeException("Entity not found with id: " + reqId);
        Optional<ItemRequisitionDTO> resBody = conversionUtility.getDto(
            Optional.ofNullable(service.update(conversionUtility.buildEntityForUpdate(Optional.of(reqBody), entity.get()))));
        return resBody.orElse(null);
    }
}
