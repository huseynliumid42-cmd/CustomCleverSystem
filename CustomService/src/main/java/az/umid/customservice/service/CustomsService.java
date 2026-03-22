package az.umid.customservice.service;

import az.umid.customservice.dto.CustomsRequest;
import az.umid.customservice.dto.CustomsResponse;

import java.util.List;

public interface CustomsService {

    CustomsResponse create(CustomsRequest request);

    CustomsResponse update(Long id, CustomsRequest request);

    void delete(Long id);

    CustomsResponse getById(Long id);

    List<CustomsResponse> getAll();
}