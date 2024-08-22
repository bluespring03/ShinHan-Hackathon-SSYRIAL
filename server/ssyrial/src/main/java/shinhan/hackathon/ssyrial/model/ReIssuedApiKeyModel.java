package shinhan.hackathon.ssyrial.model;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * IssuedApiKeyModel 클래스는 API 키 발급 요청 및 응답 데이터를 담는 모델 클래스입니다.
 */
public class ReIssuedApiKeyModel {

  /**
   * API 키 발급 요청 데이터를 담는 내부 클래스입니다.
   */
  @Getter
  @Setter
  @NoArgsConstructor
  @AllArgsConstructor
  public static class Request {
    private String managerId;
  }

  /**
   * API 키 발급 응답 데이터를 담는 내부 클래스입니다.
   */
  @Getter
  @Setter
  @NoArgsConstructor
  @AllArgsConstructor
  public static class Response {
    private String managerId;
    private String apiKey;
    private String createDate;
    private String expirationDate;
  }
}
