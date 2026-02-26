package az.umid.aiintegrationservice.service;

import az.umid.aiintegrationservice.dto.AIRequestDTO;
import az.umid.aiintegrationservice.dto.AIResponseDTO;

import java.util.List;

public interface AIService {

    AIResponseDTO askAI(AIRequestDTO request);

    List<AIResponseDTO> getUserHistory(Long userId);

    void deleteLog(Long logId);
}
