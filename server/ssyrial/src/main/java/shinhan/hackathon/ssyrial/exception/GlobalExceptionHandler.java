package shinhan.hackathon.ssyrial.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

import shinhan.hackathon.ssyrial.model.ApiResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * GlobalExceptionHandler는 전역적으로 발생하는 예외를 처리하는 클래스입니다.
 * 
 * HttpClientErrorException 및 일반 예외(Exception)에 대한 처리 로직을 제공합니다.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

  private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

  /**
   * HttpClientErrorException이 발생했을 때 해당 예외를 처리하는 메서드입니다.
   * 
   * @param e HttpClientErrorException - HTTP 클라이언트 오류 예외
   * @return ResponseEntity<ApiResponse<String>> - 오류 응답
   */
  @ExceptionHandler(HttpClientErrorException.class)
  public ResponseEntity<ApiResponse<String>> handleHttpClientErrorException(HttpClientErrorException e) {
    logger.error("HTTP Client Error: Status Code: {}, Response Body: {}", e.getStatusCode(),
        e.getResponseBodyAsString());
    return new ResponseEntity<>(ApiResponse.error(e.getResponseBodyAsString()), e.getStatusCode());
  }

  /**
   * Exception이 발생했을 때 해당 예외를 처리하는 메서드입니다.
   * 
   * @param e Exception - 일반 예외
   * @return ResponseEntity<ApiResponse<String>> - 오류 응답
   */
  @ExceptionHandler(Exception.class)
  public ResponseEntity<ApiResponse<String>> handleGeneralException(Exception e) {
    logger.error("Unexpected error occurred: {}", e.getMessage());
    return new ResponseEntity<>(ApiResponse.error("An unexpected error occurred. Please try again later."),
        HttpStatus.INTERNAL_SERVER_ERROR);
  }
}