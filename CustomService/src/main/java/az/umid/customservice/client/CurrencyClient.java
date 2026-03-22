package az.umid.customservice.client;

import az.umid.customservice.dto.CurrencyResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "CURRENCYSERVICE")
public interface CurrencyClient {

    @GetMapping("/api/currency/usd-rate")
    CurrencyResponse getRates();
}