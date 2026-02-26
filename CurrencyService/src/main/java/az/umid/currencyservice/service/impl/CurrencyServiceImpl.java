package az.umid.currencyservice.service.impl;

import az.umid.currencyservice.dto.CurrencyRequest;
import az.umid.currencyservice.dto.CurrencyResponse;
import az.umid.currencyservice.entity.Currency;
import az.umid.currencyservice.mapper.CurrencyMapper;
import az.umid.currencyservice.repository.CurrencyRepository;
import az.umid.currencyservice.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service 
@RequiredArgsConstructor 
@Slf4j 
public class CurrencyServiceImpl implements CurrencyService {

    private final CurrencyRepository repository; 
    private final CurrencyMapper mapper;         

    @Override
    public CurrencyResponse getByCode(String code) {
        log.info("Valyuta axtarılır: {}", code);
        return repository.findByCode(code.toUpperCase())
                .map(mapper::toResponse) 
                .orElseThrow(() -> new NoSuchElementException("Valyuta tapılmadı: " + code));
    }

    @Override
    public List<CurrencyResponse> getAll() {
        log.info("Bütün valyutalar siyahısı gətirilir");
        return repository.findAll().stream()
                .map(mapper::toResponse)
                .toList(); 
    }

    @Override
    @Transactional 
    public void save(CurrencyRequest request) {
        log.info("Valyuta yadda saxlanılır: {}", request.getCode());

        
        Currency currency = repository.findByCode(request.getCode().toUpperCase())
                .orElse(new Currency());

        currency.setCode(request.getCode().toUpperCase());
        currency.setRate(request.getRate());
        currency.setUpdatedAt(LocalDateTime.now()); 

        repository.save(currency); 
    }

    @Override
    @Transactional
    public void update(String code, Double rate) {
        log.info("Məzənnə update olunur: {} -> {}", code, rate);

        Currency currency = repository.findByCode(code.toUpperCase())
                .orElseThrow(() -> new NoSuchElementException("Yenilənəcək valyuta tapılmadı"));

        currency.setRate(rate); 
        currency.setUpdatedAt(LocalDateTime.now());
        
    }

    @Override
    @Transactional
    public void delete(String code) {
        log.warn("Valyuta silinir: {}", code);

        Currency currency = repository.findByCode(code.toUpperCase())
                .orElseThrow(() -> new NoSuchElementException("Silinəcək valyuta tapılmadı"));

        repository.delete(currency); 
    }
}