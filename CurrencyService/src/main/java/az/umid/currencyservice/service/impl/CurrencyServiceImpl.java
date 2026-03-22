package az.umid.currencyservice.service.impl;

import az.umid.currencyservice.dto.CurrencyResponse;
import az.umid.currencyservice.service.CurrencyService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public CurrencyResponse getRates() {

        String url = "https://open.er-api.com/v6/latest/USD";

        Map response = restTemplate.getForObject(url, Map.class);

        Map rates = (Map) response.get("rates");

        CurrencyResponse r = new CurrencyResponse();

        r.setBase("USD");
        r.setUsd(1.0);
        r.setEur((Double) rates.get("EUR"));
        r.setTryRate((Double) rates.get("TRY"));
        r.setGbp((Double) rates.get("GBP"));

        return r;
    }
}