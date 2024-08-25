package shinhan.hackathon.ssyrial.model.demandDeposit;

import lombok.Getter;
import lombok.Setter;
import shinhan.hackathon.ssyrial.model.CommonHeaderModel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateDemandDepositAccountModel {

  @Getter
  @Setter
  @NoArgsConstructor
  @AllArgsConstructor
  public static class Request {
    @JsonProperty("Header")
    private CommonHeaderModel.Request Header;

    @NotBlank(message = "상품 고유번호는 필수 입력 항목입니다.")
    private String accountTypeUniqueNo;

    // 클라이언트로부터 받는 userKey를 위한 필드
    @NotBlank(message = "사용자 키는 필수 입력 항목입니다.")
    private String userKey;

    /**
     * 헤더와 상품 고유번호만 초기화하는 생성자.
     * 이 생성자는 서비스에서 API 요청을 보낼 때 사용됩니다.
     * 
     * @param header              공통 헤더 데이터
     * @param accountTypeUniqueNo 상품 고유번호
     */
    public Request(CommonHeaderModel.Request header, String accountTypeUniqueNo) {
      this.Header = header;
      this.accountTypeUniqueNo = accountTypeUniqueNo;
    }

    /**
     * 헤더 없이 계좌 생성 요청을 초기화하는 생성자.
     * 이 생성자는 주로 클라이언트로부터 받은 데이터로 객체를 생성할 때 사용됩니다.
     * 
     * @param userKey             사용자 키
     * @param accountTypeUniqueNo 상품 고유번호
     */
    public Request(String userKey, String accountTypeUniqueNo) {
      this.userKey = userKey;
      this.accountTypeUniqueNo = accountTypeUniqueNo;
    }
  }

  @Getter
  @Setter
  @NoArgsConstructor
  @AllArgsConstructor
  public static class Response {
    @JsonProperty("Header")
    private CommonHeaderModel.Response Header;

    @JsonProperty("REC")
    private AccountInfo REC;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AccountInfo {
      private String bankCode;
      private String accountNo;
      private CurrencyInfo currency;

      @Getter
      @Setter
      @NoArgsConstructor
      @AllArgsConstructor
      public static class CurrencyInfo {
        private String currency;
        private String currencyName;
      }
    }
  }
}
