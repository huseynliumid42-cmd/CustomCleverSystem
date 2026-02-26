package az.umid.customservice.exception;

import az.umid.customservice.dto.ErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import java.io.InputStream;

public class FeignErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        try (InputStream bodyIs = response.body().asInputStream()) {
            ObjectMapper mapper = new ObjectMapper();
            
            ErrorResponse errorDto = mapper.readValue(bodyIs, ErrorResponse.class);
            return new AiIntegrationException(errorDto.getMessage());
        } catch (Exception e) {
            return new AiIntegrationException("AI servisi ilə əlaqə zamanı naməlum xəta baş verdi.");
        }
    }
}