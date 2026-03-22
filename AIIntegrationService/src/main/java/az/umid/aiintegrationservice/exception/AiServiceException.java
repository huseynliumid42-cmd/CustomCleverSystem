package az.umid.aiintegrationservice.exception;

public class AiServiceException extends RuntimeException {
    public AiServiceException(String message) {
        super(message);
    }

    public AiServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public AiServiceException(String error, String message) {
    }
}
