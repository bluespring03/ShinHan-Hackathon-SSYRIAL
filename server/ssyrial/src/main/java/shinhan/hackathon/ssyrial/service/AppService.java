package shinhan.hackathon.ssyrial.service;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import shinhan.hackathon.ssyrial.model.api.IssuedApiKeyModel;
import shinhan.hackathon.ssyrial.model.api.ReIssuedApiKeyModel;

/**
 * AppService 클래스는 비즈니스 로직을 처리하는 서비스 클래스입니다.
 * 
 * IssuedApiKeyModel 관련 API 통신을 담당합니다.
 */
@Service
public class AppService extends ShinhanApiService {

  public AppService(RestTemplate restTemplate) {
    super(restTemplate);
  }

  /**
   * API 키 발급 요청을 처리하는 메서드입니다.
   * 
   * @param request IssuedApiKeyModel.Request - API 키 발급 요청 데이터
   * @return IssuedApiKeyModel.Response - 발급된 API 키 응답 데이터
   */
  public IssuedApiKeyModel.Response getIssuedApiKey(IssuedApiKeyModel.Request request) {
    return sendRequest("/edu/app/issuedApiKey", HttpMethod.POST, request, IssuedApiKeyModel.Response.class);
  }

  public ReIssuedApiKeyModel.Response getReIssuedApiKey(ReIssuedApiKeyModel.Request request) {
    return sendRequest("/edu/app/reIssuedApiKey", HttpMethod.POST, request, ReIssuedApiKeyModel.Response.class);
  }
}
