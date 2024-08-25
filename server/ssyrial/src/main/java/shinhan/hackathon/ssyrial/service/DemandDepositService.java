package shinhan.hackathon.ssyrial.service;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import shinhan.hackathon.ssyrial.model.CommonHeaderModel;
import shinhan.hackathon.ssyrial.model.demandDeposit.CreateDemandDepositAccountModel;
import shinhan.hackathon.ssyrial.model.demandDeposit.InquireDemandDepositListModel;

/**
 * DemandDepositService 클래스는 수시입출금 상품 관련 비즈니스 로직을 처리하는 서비스 클래스입니다.
 */
@Service
public class DemandDepositService extends ShinhanApiService {

  public DemandDepositService(RestTemplate restTemplate, String apiKey) {
    super(restTemplate, apiKey);
  }

  public InquireDemandDepositListModel.Response inquireDemandDepositList() {
    CommonHeaderModel.Request header = createCommonHeader("inquireDemandDepositList", "inquireDemandDepositList", null);
    InquireDemandDepositListModel.Request request = new InquireDemandDepositListModel.Request(header);
    return sendRequest("/edu/demandDeposit/inquireDemandDepositList", HttpMethod.POST, request,
        InquireDemandDepositListModel.Response.class, true);
  }

  public CreateDemandDepositAccountModel.Response createDemandDepositAccount(String userKey,
      String accountTypeUniqueNo) {
    CommonHeaderModel.Request header = createCommonHeader("createDemandDepositAccount", "createDemandDepositAccount",
        userKey);
    CreateDemandDepositAccountModel.Request request = new CreateDemandDepositAccountModel.Request(header,
        accountTypeUniqueNo);
    return sendRequest("/edu/demandDeposit/createDemandDepositAccount", HttpMethod.POST, request,
        CreateDemandDepositAccountModel.Response.class, true);
  }
}