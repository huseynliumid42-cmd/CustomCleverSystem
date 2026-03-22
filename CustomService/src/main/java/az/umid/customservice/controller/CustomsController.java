package az.umid.customservice.controller;

import az.umid.customservice.dto.CustomsRequest;
import az.umid.customservice.dto.CustomsResponse;
import az.umid.customservice.service.CustomsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customs")
@RequiredArgsConstructor
public class CustomsController {

    private final CustomsService service;

    @PostMapping
    public CustomsResponse create(@Valid @RequestBody CustomsRequest request){
        return service.create(request);
    }

    @GetMapping
    public List<CustomsResponse> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public CustomsResponse getById(@PathVariable Long id){
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public CustomsResponse update(@PathVariable Long id,
                                  @Valid @RequestBody CustomsRequest request){
        return service.update(id,request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}