package az.umid.customservice.dto;

import lombok.Data;

@Data
public class CurrencyResponse {

    private String base;
    private double usd;
    private double eur;
    private double tryRate;
    private double gbp;

}