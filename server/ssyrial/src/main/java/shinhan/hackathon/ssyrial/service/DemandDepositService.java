package shinhan.hackathon.ssyrial.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import shinhan.hackathon.ssyrial.model.CommonHeaderModel;
import shinhan.hackathon.ssyrial.model.demandDeposit.CreateDemandDepositAccountModel;
import shinhan.hackathon.ssyrial.model.demandDeposit.InquireDemandDepositListModel;

@Service
public class DemandDepositService extends ShinhanApiService {

  private static final Logger logger = LoggerFactory.getLogger(DemandDepositService.class);

  public DemandDepositService(RestTemplate restTemplate, String apiKey) {
    super(restTemplate, apiKey);
  }

  public InquireDemandDepositListModel.Response inquireDemandDepositList() {
    logger.info("Creating header for inquireDemandDepositList");

    CommonHeaderModel.Request header = createCommonHeader("inquireDemandDepositList", "inquireDemandDepositList", null);
    InquireDemandDepositListModel.Request request = new InquireDemandDepositListModel.Request(header);

    logger.info("Sending request to Shinhan API for inquireDemandDepositList");

    InquireDemandDepositListModel.Response response = sendRequest("/edu/demandDeposit/inquireDemandDepositList",
        HttpMethod.POST, request, InquireDemandDepositListModel.Response.class, true);

    logger.info("Received response from Shinhan API: {}", response);

    return response;
  }

  public CreateDemandDepositAccountModel.Response createDemandDepositAccount(String userKey,
      String accountTypeUniqueNo) {
    logger.info("Creating header for createDemandDepositAccount with userKey: {}", userKey);

    CommonHeaderModel.Request header = createCommonHeader("createDemandDepositAccount", "createDemandDepositAccount",
        userKey);
    CreateDemandDepositAccountModel.Request request = new CreateDemandDepositAccountModel.Request(header,
        accountTypeUniqueNo);

    logger.info("Sending request to Shinhan API for createDemandDepositAccount with accountTypeUniqueNo: {}",
        accountTypeUniqueNo);

    CreateDemandDepositAccountModel.Response response = sendRequest("/edu/demandDeposit/createDemandDepositAccount",
        HttpMethod.POST, request, CreateDemandDepositAccountModel.Response.class, true);

    logger.info("Received response from Shinhan API for createDemandDepositAccount: {}", response);

    return response;
  }
}
