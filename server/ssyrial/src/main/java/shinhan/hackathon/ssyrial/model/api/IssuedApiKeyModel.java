package shinhan.hackathon.ssyrial.model.api;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * IssuedApiKeyModel 클래스는 API 키 발급 요청 및 응답 데이터를 담는 모델 클래스입니다.
 */
public class IssuedApiKeyModel {

  /**
   * API 키 발급 요청 데이터를 담는 내부 클래스입니다.
   */
  @Getter
  @Setter
  @NoArgsConstructor
  @AllArgsConstructor
  public static class Request {

    @NotBlank(message = "managerId는 필수 입력 항목입니다.")
    @Email(message = "managerId는 유효한 이메일 형식이어야 합니다.")
    @Size(max = 30, message = "managerId는 최대 30글자 이내여야 합니다.")
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
