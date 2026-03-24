package az.umid.aiintegrationservice.controller;

import az.umid.aiintegrationservice.service.AiService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/ai")
@CrossOrigin(origins = "*")
public class AiController {

    private final AiService aiService;

    public AiController(AiService aiService) {
        this.aiService = aiService;
    }

    @PostMapping("/chat")
    public Map<String, String> chat(@RequestBody Map<String, String> request) {

        String msg = request.get("message");

        // təhlükəsizlik (null check)
        if (msg == null || msg.trim().isEmpty()) {
            return Map.of("response", "Mesaj boşdur");
        }

        // əsas logic SERVICE-də işləyir
        String response = aiService.askGemini(msg);

        return Map.of("response", response);
    }
}