package shinhan.hackathon.ssyrial.service;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import shinhan.hackathon.ssyrial.model.CommonHeaderModel;
import shinhan.hackathon.ssyrial.model.demandDeposit.InquireDemandDepositListModel;

/**
 * DemandDepositService 클래스는 수시입출금 상품 조회와 관련된 비즈니스 로직을 처리하는 서비스 클래스입니다.
 */
@Service
public class DemandDepositService extends ShinhanApiService {

  /**
   * DemandDepositService 생성자.
   * 
   * @param restTemplate 외부 API와의 통신을 위한 RestTemplate 객체
   * @param apiKey       API 호출에 필요한 API 키
   */
  public DemandDepositService(RestTemplate restTemplate, String apiKey) {
    super(restTemplate, apiKey);
  }

  /**
   * 수시입출금 상품 조회 API 요청을 처리하는 메서드입니다.
   * 
   * 클라이언트로부터 별도의 요청 본문 없이 수시입출금 상품 목록 조회 요청을 처리하고,
   * 조회된 상품 목록 정보를 반환합니다.
   * 
   * @return InquireDemandDepositListModel.Response - 조회된 상품 목록 정보 응답
   */
  public InquireDemandDepositListModel.Response inquireDemandDepositList() {
    // 공통 헤더 생성, userKey는 필요하지 않음
    CommonHeaderModel.Request header = createCommonHeader("inquireDemandDepositList", "inquireDemandDepositList", null);

    // 수시입출금 상품 조회 요청 데이터 생성
    InquireDemandDepositListModel.Request request = new InquireDemandDepositListModel.Request(header);

    // API 호출 및 응답 반환
    return sendRequest("/edu/demandDeposit/inquireDemandDepositList", HttpMethod.POST, request,
        InquireDemandDepositListModel.Response.class, true);
  }

  /*
   *
   * /demandDeposit/createDemandDeposit
   * 은행별 수시입출금 상품을 등록하는 API 경로입니다.
   * 
   * /demandDeposit/createDemandDepositAccount
   * 계좌를 생성하는 API 경로입니다.
   * 
   * /demandDeposit/inquireDemandDepositAccountList
   * 계좌 목록을 조회하는 API 경로입니다.
   */
}
