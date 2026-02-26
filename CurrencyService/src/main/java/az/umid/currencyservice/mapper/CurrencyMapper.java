package az.umid.currencyservice.mapper;

import az.umid.currencyservice.dto.CurrencyRequest;
import az.umid.currencyservice.dto.CurrencyResponse;
import az.umid.currencyservice.entity.Currency;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CurrencyMapper {
    @Mapping(target = "updatedAt", source = "updatedAt", dateFormat = "dd--MM-yyy HH-mm-ss")
    CurrencyResponse toResponse(Currency currency);

    Currency toEntity(CurrencyRequest request);
}
