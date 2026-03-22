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

        String response;

        if (msg.toLowerCase().contains("bəyannamə")) {
            response = "Bəyannamə etmək üçün məhsul məlumatlarını sistemə daxil edib təsdiqləməlisiniz.";
        } else if (msg.toLowerCase().contains("rüsum")) {
            response = "100$-dan yuxarı məhsullara 18% ƏDV tətbiq olunur.";
        } else if (msg.toLowerCase().contains("neçə günə")) {
            response = "Çatdırılma adətən 3-7 iş günü çəkir.";
        } else {
            response = "Sualınızı daha detallı yazın.";
        }

        return Map.of("response", response);
    }
}