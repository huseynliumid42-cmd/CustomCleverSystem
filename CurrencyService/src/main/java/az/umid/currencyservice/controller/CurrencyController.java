package az.umid.currencyservice.controller;

import az.umid.currencyservice.dto.CurrencyRequest;
import az.umid.currencyservice.dto.CurrencyResponse;
import az.umid.currencyservice.service.CurrencyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController 
@RequestMapping("/api/v1/currencies") 
@RequiredArgsConstructor 
public class CurrencyController {

    
    private final CurrencyService currencyService;

    
    @GetMapping("/{code}")
    public ResponseEntity<CurrencyResponse> getByCode(@PathVariable String code) {
        
        return ResponseEntity.ok(currencyService.getByCode(code));
    }

    
    @GetMapping
    public ResponseEntity<List<CurrencyResponse>> getAll() {
        return ResponseEntity.ok(currencyService.getAll());
    }

    
    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody CurrencyRequest request) {
        
        
        currencyService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).build(); 
    }

    
    @PutMapping("/{code}")
    public ResponseEntity<Void> update(@PathVariable String code, @RequestParam Double rate) {
        currencyService.update(code, rate);
        return ResponseEntity.noContent().build(); 
    }

    
    @DeleteMapping("/{code}")
    public ResponseEntity<Void> delete(@PathVariable String code) {
        currencyService.delete(code);
        return ResponseEntity.ok().build(); 
    }
}