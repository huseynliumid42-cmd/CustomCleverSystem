package az.umid.aiintegrationservice.service.impl;

import az.umid.aiintegrationservice.dto.AIRequestDTO;
import az.umid.aiintegrationservice.dto.AIResponseDTO;
import az.umid.aiintegrationservice.entity.AIQueryLog;
import az.umid.aiintegrationservice.mapper.AIMapper;
import az.umid.aiintegrationservice.repository.AIQueryRepository;
import az.umid.aiintegrationservice.service.AIService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AIServiceImpl implements AIService {

    private final AIQueryRepository repository;
    private final AIMapper mapper;

    private final WebClient webClient = WebClient.create();

    @Value("${gemini.api-key}")
    private String apiKey;

    @Override
    public AIResponseDTO askAI(AIRequestDTO request) {

        String url = "https://generativelanguage.googleapis.com/v1beta/models/gemini-pro:generateContent?key=" + apiKey;

        String body = """
        {
          "contents": [
            {
              "parts": [
                {"text": "%s"}
              ]
            }
          ]
        }
        """.formatted(request.getPrompt());

        String response = webClient.post()
                .uri(url)
                .header("Content-Type", "application/json")
                .bodyValue(body)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        String aiText = extractText(response);

        AIQueryLog log = AIQueryLog.builder()
                .userId(request.getUserId())
                .userPrompt(request.getPrompt())
                .aiResponse(aiText)
                .createdAt(LocalDateTime.now())
                .build();

        return mapper.toDTO(repository.save(log));
    }

    private String extractText(String response) {
        try {
            int start = response.indexOf("text") + 7;
            int end = response.indexOf("\"", start);
            return response.substring(start, end);
        } catch (Exception e) {
            return "AI cavabı parse olunmadı";
        }
    }

    @Override
    public List<AIResponseDTO> getUserHistory(Long userId) {
        return repository.findByUserId(userId)
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteLog(Long logId) {
        repository.deleteById(logId);
    }
}
