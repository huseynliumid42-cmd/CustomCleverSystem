package az.umid.userservice.Mapper;

import az.umid.userservice.Config.MapperConfiguration;
import az.umid.userservice.dto.UserRegistrationRequest;
import az.umid.userservice.dto.UserResponse;
import az.umid.userservice.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(config = MapperConfiguration.class)
public interface UserMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "password",ignore = true)
    User toEntity(UserRegistrationRequest request);

   void uptadeUserFromDto(UserRegistrationRequest request, @MappingTarget User user);

    UserResponse toResponse(User user);
}
