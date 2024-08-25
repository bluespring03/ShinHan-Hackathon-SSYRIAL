package shinhan.hackathon.ssyrial.model;

import lombok.Getter;
import lombok.Setter;

/**
 * ApiResponse 클래스는 API 응답을 표준화하기 위한 모델 클래스입니다.
 * 
 * @param <T> 응답 데이터의 타입
 */
@Getter
@Setter
public class ApiResponse<T> {
  private boolean success;
  private String message;
  private T data;

  public ApiResponse(boolean success, String message, T data) {
    this.success = success;
    this.message = message;
    this.data = data;
  }

  /**
   * 성공적인 요청에 대한 ApiResponse 객체를 생성하는 메서드입니다.
   * 
   * @param <T>  응답 데이터의 타입
   * @param data 응답 데이터
   * @return ApiResponse<T> - 성공 응답 객체
   */
  public static <T> ApiResponse<T> success(T data) {
    return new ApiResponse<>(true, "Request processed successfully.", data);
  }

  /**
   * 오류가 발생했을 때 ApiResponse 객체를 생성하는 메서드입니다.
   * 
   * @param <T>     응답 데이터의 타입
   * @param message 오류 메시지
   * @return ApiResponse<T> - 오류 응답 객체
   */
  public static <T> ApiResponse<T> error(String message) {
    return new ApiResponse<>(false, message, null);
  }

  // 새로운 오류 응답 메서드 (메시지 + 추가 데이터)
  public static <T> ApiResponse<T> error(String message, T data) {
    return new ApiResponse<>(false, message, data);
  }
}