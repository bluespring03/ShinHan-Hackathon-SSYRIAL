package shinhan.hackathon.ssyrial.service;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import shinhan.hackathon.ssyrial.model.CommonHeaderModel;
import shinhan.hackathon.ssyrial.model.demandDeposit.CreateDemandDepositAccountModel;
import shinhan.hackathon.ssyrial.model.demandDeposit.CreateDemandDepositModel;
import shinhan.hackathon.ssyrial.model.demandDeposit.InquireDemandDepositListModel;

/**
 * DemandDepositService 클래스는 수시입출금 상품 관련 비즈니스 로직을 처리하는 서비스 클래스입니다.
 * 이 클래스는 정기 입출금 상품 등록, 목록 조회 및 계좌 생성과 관련된 API 요청을 처리합니다.
 */
@Service
public class DemandDepositService extends ShinhanApiService {

  /**
   * DemandDepositService 생성자.
   *
   * @param restTemplate RestTemplate 객체로, 외부 API와의 통신에 사용됩니다.
   * @param apiKey       API 호출 시 사용할 API 키.
   */
  public DemandDepositService(RestTemplate restTemplate, String apiKey) {
    super(restTemplate, apiKey);
  }

  /**
   * 정기 입출금 상품을 등록하는 메서드입니다.
   *
   * 이 메서드는 은행 코드와 상품 정보를 받아, 해당 정보를 기반으로
   * 정기 입출금 상품을 등록하는 API 요청을 보냅니다.
   *
   * @param bankCode           은행 코드
   * @param accountName        상품 이름
   * @param accountDescription 상품 설명
   * @return CreateDemandDepositModel.Response - 등록된 상품 정보가 담긴 응답
   */
  public CreateDemandDepositModel.Response createDemandDeposit(String bankCode, String accountName,
      String accountDescription) {
    // 공통 헤더 생성
    CommonHeaderModel.Request header = createCommonHeader("createDemandDeposit", "createDemandDeposit", null);

    // 요청 객체 생성
    CreateDemandDepositModel.Request request = new CreateDemandDepositModel.Request(header, bankCode, accountName,
        accountDescription);

    // API 요청 보내기
    return sendRequest("/edu/demandDeposit/createDemandDeposit", HttpMethod.POST, request,
        CreateDemandDepositModel.Response.class, true);
  }

  /**
   * 수시입출금 상품 목록 조회 요청을 처리하는 메서드입니다.
   *
   * 이 메서드는 정기 입출금 상품 목록을 조회하는 API 요청을 보내고,
   * 그 결과를 반환합니다.
   *
   * @return InquireDemandDepositListModel.Response - 조회된 상품 목록이 담긴 응답
   */
  public InquireDemandDepositListModel.Response inquireDemandDepositList() {
    // 공통 헤더 생성
    CommonHeaderModel.Request header = createCommonHeader("inquireDemandDepositList", "inquireDemandDepositList", null);

    // 요청 객체 생성
    InquireDemandDepositListModel.Request request = new InquireDemandDepositListModel.Request(header);

    // API 요청 보내기
    return sendRequest("/edu/demandDeposit/inquireDemandDepositList", HttpMethod.POST, request,
        InquireDemandDepositListModel.Response.class, true);
  }

  /**
   * 수시입출금 계좌를 생성하는 메서드입니다.
   *
   * 이 메서드는 사용자 키와 상품 고유번호를 받아 계좌를 생성하는 API 요청을 보냅니다.
   *
   * @param userKey             사용자 키
   * @param accountTypeUniqueNo 상품 고유번호
   * @return CreateDemandDepositAccountModel.Response - 생성된 계좌 정보가 담긴 응답
   */
  public CreateDemandDepositAccountModel.Response createDemandDepositAccount(String userKey,
      String accountTypeUniqueNo) {
    // 공통 헤더 생성
    CommonHeaderModel.Request header = createCommonHeader("createDemandDepositAccount", "createDemandDepositAccount",
        userKey);

    // 요청 객체 생성
    CreateDemandDepositAccountModel.Request request = new CreateDemandDepositAccountModel.Request(header,
        accountTypeUniqueNo);

    // API 요청 보내기
    return sendRequest("/edu/demandDeposit/createDemandDepositAccount", HttpMethod.POST, request,
        CreateDemandDepositAccountModel.Response.class, true);
  }
}
