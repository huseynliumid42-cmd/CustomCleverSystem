package az.umid.customservice.service.impl;

import az.umid.customservice.client.AiClient;
import az.umid.customservice.dto.*;
import az.umid.customservice.entity.CustomsDuty;
import az.umid.customservice.mapper.CustomsMapper;
import az.umid.customservice.repository.CustomsRepository;
import az.umid.customservice.service.CustomsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomsServiceImpl implements CustomsService {

    private final CustomsRepository repository;
    private final AiClient aiClient;
    private final CustomsMapper mapper;

    @Override
    public CustomsResponse create(CustomsRequest request) {
        String aiResult = aiClient.getAiResponse(request.getProductName());
        CustomsDuty entity = mapper.toEntity(request);
        entity.setAiAnalysis(aiResult);
        entity.setTax(request.getPrice() * 0.15); // Nümunə vergi
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public CustomsResponse update(Long id, CustomsRequest request) {
        CustomsDuty entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tapılmadı!"));
        mapper.updateEntityFromRequest(request, entity);
        entity.setTax(request.getPrice() * 0.15);
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public CustomsResponse getById(Long id) {
        return repository.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Tapılmadı!"));
    }

    @Override
    public List<CustomsResponse> getAll() {
        return repository.findAll().stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }
}