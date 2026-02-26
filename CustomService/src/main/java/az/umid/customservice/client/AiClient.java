package az.umid.customservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "ai-service", url = "http://localhost:8084")
public interface AiClient {
    
    @PostMapping("/api/v1/ai/ask")
    String getAiResponse(@RequestBody String prompt);
}