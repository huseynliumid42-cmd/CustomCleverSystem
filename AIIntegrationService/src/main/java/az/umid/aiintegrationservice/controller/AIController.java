package az.umid.aiintegrationservice.controller;

import az.umid.aiintegrationservice.dto.AIRequestDTO;
import az.umid.aiintegrationservice.dto.AIResponseDTO;
import az.umid.aiintegrationservice.service.AIService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ai")
@RequiredArgsConstructor
public class AIController {

    private final AIService aiService;

    
    @PostMapping("/ask")
    public ResponseEntity<AIResponseDTO> askAI(@Valid @RequestBody AIRequestDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(aiService.askAI(request));
    }

    
    @GetMapping("/history/{userId}")
    public ResponseEntity<List<AIResponseDTO>> getUserHistory(@PathVariable Long userId) {
        return ResponseEntity.ok(aiService.getUserHistory(userId));
    }

    
    @PutMapping("/log/{logId}")
    public ResponseEntity<AIResponseDTO> updateResponse(
            @PathVariable Long logId,
            @RequestBody String newResponse) {
        return ResponseEntity.ok(aiService.updateAIResponse(logId, newResponse));
    }

    
    @DeleteMapping("/log/{logId}")
    public ResponseEntity<Void> deleteLog(@PathVariable Long logId) {
        aiService.deleteLog(logId);
        return ResponseEntity.noContent().build();
    }
}