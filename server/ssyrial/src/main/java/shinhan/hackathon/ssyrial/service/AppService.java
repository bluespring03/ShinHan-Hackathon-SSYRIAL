package shinhan.hackathon.ssyrial.service;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import shinhan.hackathon.ssyrial.model.IssuedApiKeyModel;

@Service
public class AppService extends ShinhanApiService {

  public AppService(RestTemplate restTemplate) {
    super(restTemplate);
  }

  public IssuedApiKeyModel.Response getIssuedApiKey(IssuedApiKeyModel.Request request) {
    return sendRequest("/app/issuedApiKey", HttpMethod.POST, request, IssuedApiKeyModel.Response.class);
  }
}
