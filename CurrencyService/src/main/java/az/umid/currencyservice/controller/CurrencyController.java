package az.umid.currencyservice.controller;

import az.umid.currencyservice.dto.CurrencyResponse;
import az.umid.currencyservice.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/currency")
@RequiredArgsConstructor
public class CurrencyController {

    private final CurrencyService service;

    @GetMapping("/rates")
    public CurrencyResponse getRates(){

        return service.getRates();

    }
}