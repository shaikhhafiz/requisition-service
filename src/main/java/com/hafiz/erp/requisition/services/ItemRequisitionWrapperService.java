package com.hafiz.erp.requisition.services;

import com.hafiz.erp.requisition.dataclass.ItemRequisitionCreateDTO;
import com.hafiz.erp.requisition.dataclass.ItemRequisitionResponseDTO;
import com.hafiz.erp.requisition.utility.ItemRequisitionConversionUtility;
import com.hafiz.erp.requisition.utility.ItemRequisitionDetailConversionUtility;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemRequisitionWrapperService {
    private final ItemRequisitionService service;
    private final ItemRequisitionConversionUtility conversionUtility;
    private final ItemRequisitionDetailService detailService;
    private final ItemRequisitionDetailConversionUtility detailConversionUtility;


    @Transactional
    public ItemRequisitionResponseDTO createRequisitionWithDetails(ItemRequisitionCreateDTO d){
        Optional<ItemRequisitionResponseDTO> dto = conversionUtility.getDto(
            Optional.ofNullable(service.create(
                conversionUtility.buildEntity(Optional.of(d)))));
        dto.ifPresent(itemRequisitionResponseDTO -> itemRequisitionResponseDTO.setDetails(
                new HashSet<>(detailConversionUtility.getDtoList(
                        detailService.createAll(
                                d.getDetails().stream()
                                        .peek(e -> e.setReqId(dto.get().getId()))
                                        .map(e -> detailConversionUtility.buildEntity(Optional.of(e)))
                                        .map(Optional::get).collect(Collectors.toList()))))));
        return dto.orElse(null);
    }
}
