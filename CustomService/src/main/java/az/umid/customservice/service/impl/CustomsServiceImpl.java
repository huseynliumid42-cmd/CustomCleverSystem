package az.umid.customservice.service.impl;

import az.umid.customservice.dto.CustomsRequest;
import az.umid.customservice.dto.CustomsResponse;
import az.umid.customservice.entity.CustomsDuty;
import az.umid.customservice.repository.CustomsRepository;
import az.umid.customservice.service.CustomsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomsServiceImpl implements CustomsService {

    private final CustomsRepository repository;

    @Override
    public CustomsResponse create(CustomsRequest request) {

        CustomsDuty entity = new CustomsDuty();

        entity.setProductName(request.getProductName());
        entity.setHsCode(request.getHsCode());
        entity.setPrice(request.getPrice());
        entity.setCurrency(request.getCurrency());

        double tax = request.getPrice() * 0.15;
        double total = request.getPrice() + tax;

        entity.setTax(tax);
        entity.setTotalPrice(total);
        entity.setAiAnalysis("AI analiz gözlənilir");
        entity.setStatus("PENDING");
        entity.setCreatedAt(LocalDateTime.now());

        CustomsDuty saved = repository.save(entity);

        return mapToResponse(saved);
    }

    @Override
    public CustomsResponse update(Long id, CustomsRequest request) {

        CustomsDuty entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bəyannamə tapılmadı"));

        entity.setProductName(request.getProductName());
        entity.setHsCode(request.getHsCode());
        entity.setPrice(request.getPrice());
        entity.setCurrency(request.getCurrency());

        double tax = request.getPrice() * 0.15;
        double total = request.getPrice() + tax;

        entity.setTax(tax);
        entity.setTotalPrice(total);

        CustomsDuty saved = repository.save(entity);

        return mapToResponse(saved);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public CustomsResponse getById(Long id) {

        CustomsDuty entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tapılmadı"));

        return mapToResponse(entity);
    }

    @Override
    public List<CustomsResponse> getAll() {

        return repository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private CustomsResponse mapToResponse(CustomsDuty entity){

        CustomsResponse response = new CustomsResponse();

        response.setId(entity.getId());
        response.setProductName(entity.getProductName());
        response.setHsCode(entity.getHsCode());
        response.setPrice(entity.getPrice());
        response.setCurrency(entity.getCurrency());
        response.setTax(entity.getTax());
        response.setTotalPrice(entity.getTotalPrice());
        response.setAiAnalysis(entity.getAiAnalysis());
        response.setStatus(entity.getStatus());
        response.setCreatedAt(entity.getCreatedAt());

        return response;
    }
}