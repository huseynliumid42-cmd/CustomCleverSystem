package az.umid.customservice.controler;

import az.umid.customservice.dto.*;
import az.umid.customservice.service.CustomsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/customs")
@RequiredArgsConstructor
public class CustomsController {

    private final CustomsService service;

    @PostMapping
    public CustomsResponse create(@RequestBody CustomsRequest request) {
        return service.create(request);
    }

    @PutMapping("/{id}")
    public CustomsResponse update(@PathVariable Long id, @RequestBody CustomsRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/{id}")
    public CustomsResponse getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<CustomsResponse> getAll() {
        return service.getAll();
    }
}