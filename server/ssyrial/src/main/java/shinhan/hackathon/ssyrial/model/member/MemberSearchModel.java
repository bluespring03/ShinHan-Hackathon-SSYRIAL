package shinhan.hackathon.ssyrial.model.member;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * MemberSearchModel 클래스는 사용자 검색 API 요청 및 응답 데이터를 담는 모델 클래스입니다.
 */
public class MemberSearchModel {

  /**
   * 사용자 검색 API 요청 데이터를 담는 내부 클래스입니다.
   */
  @Getter
  @Setter
  @NoArgsConstructor
  @AllArgsConstructor
  public static class Request {

    @NotBlank(message = "apiKey는 필수 입력 항목입니다.")
    @Size(min = 10, max = 10, message = "apiKey는 10자리여야 합니다.")
    private String apiKey;

    @NotBlank(message = "userId는 필수 입력 항목입니다.")
    @Email(message = "userId는 유효한 이메일 형식이어야 합니다.")
    @Size(max = 40, message = "userId는 최대 40글자 이내여야 합니다.")
    private String userId;
  }

  /**
   * 사용자 검색 API 응답 데이터를 담는 내부 클래스입니다.
   */
  @Getter
  @Setter
  @NoArgsConstructor
  @AllArgsConstructor
  public static class Response {
    private String userId;
    private String username;
    private String institutionCode;
    private String userKey;
    private String created;
    private String modified;
  }
}
