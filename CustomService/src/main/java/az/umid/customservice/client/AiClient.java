package az.umid.customservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "AIINTEGRATIONSERVICE")
public interface AiClient {

    @PostMapping("/api/ai/analyze")
    String analyzeProduct(@RequestParam String productName);
}