package shinhan.hackathon.ssyrial.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicLong;

public class CommonHeaderModel {

  private static final AtomicLong sequence = new AtomicLong(0);

  @Getter
  @Setter
  @NoArgsConstructor
  @AllArgsConstructor
  @JsonInclude(JsonInclude.Include.NON_NULL)
  public static class Request {

    @NotBlank(message = "API 이름은 필수 입력 항목입니다.")
    @Size(max = 30, message = "API 이름은 최대 30자까지 허용됩니다.")
    private String apiName;

    @NotBlank(message = "API 전송일자는 필수 입력 항목입니다.")
    @Size(min = 8, max = 8, message = "API 전송일자는 YYYYMMDD 형식이어야 합니다.")
    private String transmissionDate;

    @NotBlank(message = "API 전송시각은 필수 입력 항목입니다.")
    @Size(min = 6, max = 6, message = "API 전송시각은 HHMMSS 형식이어야 합니다.")
    private String transmissionTime;

    @NotBlank(message = "기관코드는 필수 입력 항목입니다.")
    @Size(max = 5, message = "기관코드는 최대 5자까지 허용됩니다.")
    private String institutionCode;

    @NotBlank(message = "핀테크 앱 일련번호는 필수 입력 항목입니다.")
    @Size(max = 3, message = "핀테크 앱 일련번호는 최대 3자까지 허용됩니다.")
    private String fintechAppNo;

    @NotBlank(message = "API 서비스 코드는 필수 입력 항목입니다.")
    @Size(max = 30, message = "API 서비스 코드는 최대 30자까지 허용됩니다.")
    private String apiServiceCode;

    @NotBlank(message = "기관 거래 고유번호는 필수 입력 항목입니다.")
    @Size(min = 20, max = 20, message = "기관 거래 고유번호는 20자리여야 합니다.")
    private String institutionTransactionUniqueNo;

    @NotBlank(message = "API 키는 필수 입력 항목입니다.")
    @Size(max = 40, message = "API 키는 최대 40자까지 허용됩니다.")
    private String apiKey;

    @Size(max = 40, message = "사용자 키는 최대 40자까지 허용됩니다.")
    private String userKey;

    @Builder
    public Request(String apiName, String apiServiceCode, String apiKey, String userKey) {
      this.apiName = apiName;
      this.apiServiceCode = apiServiceCode;
      this.apiKey = apiKey;
      this.userKey = userKey;

      LocalDateTime now = LocalDateTime.now();
      this.transmissionDate = now.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
      this.transmissionTime = now.format(DateTimeFormatter.ofPattern("HHmmss"));
      this.institutionTransactionUniqueNo = generateUniqueTransactionNumber(now);
      this.institutionCode = "00100";
      this.fintechAppNo = "001";
    }

    private static String generateUniqueTransactionNumber(LocalDateTime now) {
      String dateTime = now.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
      long sequenceNumber = sequence.getAndIncrement() % 1000000; // 6자리 순차 번호
      return String.format("%s%06d", dateTime, sequenceNumber);
    }
  }

  @Getter
  @Setter
  @NoArgsConstructor
  @AllArgsConstructor
  @JsonInclude(JsonInclude.Include.NON_NULL)
  public static class Response {
    private String responseCode;
    private String responseMessage;
    private String apiName;
    private String transmissionDate;
    private String transmissionTime;
    private String institutionCode;
    private String fintechAppNo;
    private String apiServiceCode;
    private String institutionTransactionUniqueNo;
  }
}
