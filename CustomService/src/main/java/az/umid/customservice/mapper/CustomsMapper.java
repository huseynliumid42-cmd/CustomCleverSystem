package az.umid.customservice.mapper;

import az.umid.customservice.dto.CustomsRequest;
import az.umid.customservice.dto.CustomsResponse;
import az.umid.customservice.entity.CustomsDuty;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CustomsMapper {
    CustomsDuty toEntity(CustomsRequest request);
    CustomsResponse toResponse(CustomsDuty entity);
    void updateEntityFromRequest(CustomsRequest request, @MappingTarget CustomsDuty entity);
}