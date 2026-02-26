package az.umid.userservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice 
public class GlobalExceptionHandler {


  @ExceptionHandler(RuntimeException.class)
  public ResponseEntity<Map<String, Object>> handleRuntimeException(RuntimeException ex) {
    Map<String, Object> errorBody = new HashMap<>();

    
    errorBody.put("timestamp", LocalDateTime.now()); 
    errorBody.put("message", ex.getMessage());        
    errorBody.put("status", HttpStatus.BAD_REQUEST.value()); 

    return new ResponseEntity<>(errorBody, HttpStatus.BAD_REQUEST);
  }



  @ExceptionHandler(Exception.class)
  public ResponseEntity<Map<String, Object>> handleGeneralException(Exception ex) {
    Map<String, Object> errorBody = new HashMap<>();

    errorBody.put("timestamp", LocalDateTime.now());
    errorBody.put("message", "Sistemdə gözlənilməz xəta baş verdi!");
    errorBody.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());

    return new ResponseEntity<>(errorBody, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}