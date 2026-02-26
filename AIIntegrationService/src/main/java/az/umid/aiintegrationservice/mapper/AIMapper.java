package az.umid.aiintegrationservice.mapper;

import az.umid.aiintegrationservice.dto.AIResponseDTO;
import az.umid.aiintegrationservice.entity.AIQueryLog;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AIMapper {

    @Mapping(target = "response", source = "aiResponse")
    @Mapping(target = "timestamp", source = "createdAt")
    AIResponseDTO toDTO(AIQueryLog entity);
}