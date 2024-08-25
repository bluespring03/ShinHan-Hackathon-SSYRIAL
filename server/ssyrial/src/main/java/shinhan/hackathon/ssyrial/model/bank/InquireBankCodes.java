package shinhan.hackathon.ssyrial.model.bank;

import lombok.Getter;
import lombok.Setter;
import shinhan.hackathon.ssyrial.model.CommonHeaderModel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InquireBankCodes {

  @Getter
  @Setter
  @NoArgsConstructor
  @AllArgsConstructor
  public static class Request {

    @NotBlank(message = "공통 헤더는 필수 입력 항목입니다.")
    @JsonProperty("Header")
    private CommonHeaderModel.Request Header;
  }

  @Getter
  @Setter
  @NoArgsConstructor
  @AllArgsConstructor
  public static class Response {
    @JsonProperty("Header")
    private CommonHeaderModel.Response Header;
    @JsonProperty("REC")
    private List<BankCode> REC;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BankCode {
      private String bankCode;
      private String bankName;
    }
  }
}
