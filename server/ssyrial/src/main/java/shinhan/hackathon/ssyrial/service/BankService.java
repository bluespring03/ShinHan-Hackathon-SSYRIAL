package shinhan.hackathon.ssyrial.service;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import shinhan.hackathon.ssyrial.model.CommonHeaderModel;
import shinhan.hackathon.ssyrial.model.bank.InquireBankCodes;

@Service
public class BankService extends ShinhanApiService {

  public BankService(RestTemplate restTemplate, String apiKey) {
    super(restTemplate, apiKey);
  }

  public InquireBankCodes.Response inquireBankCodes() {
    CommonHeaderModel.Request header = createCommonHeader("inquireBankCodes", "inquireBankCodes", null);

    InquireBankCodes.Request request = new InquireBankCodes.Request(header);

    return sendRequest("/edu/bank/inquireBankCodes", HttpMethod.POST, request, InquireBankCodes.Response.class, true);
  }
}
