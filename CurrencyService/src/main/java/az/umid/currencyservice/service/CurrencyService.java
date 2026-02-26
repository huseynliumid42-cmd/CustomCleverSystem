package az.umid.currencyservice.service;

import az.umid.currencyservice.dto.CurrencyRequest;
import az.umid.currencyservice.dto.CurrencyResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CurrencyService {
    CurrencyResponse getByCode(String code);

    List<CurrencyResponse> getAll();

    void save(CurrencyRequest request);

    void update(String code, Double rate);

    void delete(String code);


}
