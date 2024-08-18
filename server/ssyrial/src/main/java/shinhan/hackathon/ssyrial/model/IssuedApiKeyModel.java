package shinhan.hackathon.ssyrial.model;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

public class IssuedApiKeyModel {

  @Getter
  @Setter
  @NoArgsConstructor
  @AllArgsConstructor
  public static class Request {
    private String managerId;
  }

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
