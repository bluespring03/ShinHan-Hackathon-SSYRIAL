package shinhan.hackathon.ssyrial.controller;

import org.springframework.http.ResponseEntity;
import shinhan.hackathon.ssyrial.model.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * BaseController는 공통 기능을 제공하는 추상 컨트롤러 클래스입니다.
 */
public abstract class BaseController {

  protected final Logger logger = LoggerFactory.getLogger(this.getClass());

  /**
   * API 호출이 성공한 경우 표준화된 ApiResponse를 반환합니다.
   *
   * @param data 응답 데이터
   * @param <T>  응답 데이터의 타입
   * @return 표준화된 성공 ApiResponse 객체
   */
  protected <T> ResponseEntity<ApiResponse<T>> successResponse(T data) {
    return ResponseEntity.ok(ApiResponse.success(data));
  }

  /**
   * API 호출이 실패한 경우 표준화된 ApiResponse를 반환합니다.
   *
   * @param errorMessage 오류 메시지
   * @return 표준화된 오류 ApiResponse 객체
   */
  protected ResponseEntity<ApiResponse<String>> errorResponse(String errorMessage) {
    return ResponseEntity.badRequest().body(ApiResponse.error(errorMessage));
  }
}
