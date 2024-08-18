package shinhan.hackathon.ssyrial.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

import shinhan.hackathon.ssyrial.model.ApiResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ControllerAdvice
public class GlobalExceptionHandler {

  private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

  @ExceptionHandler(HttpClientErrorException.class)
  public ResponseEntity<ApiResponse<String>> handleHttpClientErrorException(HttpClientErrorException e) {
    logger.error("HTTP Client Error: Status Code: {}, Response Body: {}", e.getStatusCode(),
        e.getResponseBodyAsString());
    return new ResponseEntity<>(ApiResponse.error(e.getResponseBodyAsString()), e.getStatusCode());
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ApiResponse<String>> handleGeneralException(Exception e) {
    logger.error("Unexpected error occurred: {}", e.getMessage());
    return new ResponseEntity<>(ApiResponse.error("An unexpected error occurred. Please try again later."),
        HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
