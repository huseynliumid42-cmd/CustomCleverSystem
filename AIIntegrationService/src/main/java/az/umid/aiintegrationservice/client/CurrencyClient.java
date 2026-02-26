package az.umid.aiintegrationservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@FeignClient(name = "CURRENCYSERVICE")
public interface CurrencyClient {
    @GetMapping("api/currencies/latest")
    Map<String, java.math.BigDecimal> getLatestRates();


}
