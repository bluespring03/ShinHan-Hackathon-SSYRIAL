package shinhan.hackathon.ssyrial.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ShinhanApiService 클래스는 외부 API와의 통신을 처리하는 추상화된 서비스 클래스입니다.
 * 
 * RestTemplate을 사용하여 API 요청을 보냅니다.
 */
@Service
public abstract class ShinhanApiService {

  private static final Logger logger = LoggerFactory.getLogger(ShinhanApiService.class);

  protected final RestTemplate restTemplate;
  protected static final String BASE_URL = "https://finopenapi.ssafy.io/ssafy/api/v1/edu";

  public ShinhanApiService(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  /**
   * 외부 API에 요청을 보내고 응답을 받는 메서드입니다.
   * 
   * @param <T>          응답 데이터의 타입
   * @param endpoint     호출할 API 엔드포인트
   * @param method       HTTP 메서드 (GET, POST 등)
   * @param requestBody  요청 데이터
   * @param responseType 응답 데이터의 클래스 타입
   * @return T - 응답 데이터
   */
  protected <T> T sendRequest(String endpoint, HttpMethod method, Object requestBody, Class<T> responseType) {
    HttpHeaders headers = new HttpHeaders();
    headers.set("Content-Type", "application/json");

    HttpEntity<Object> entity = new HttpEntity<>(requestBody, headers);

    try {
      ResponseEntity<T> responseEntity = restTemplate.exchange(
          BASE_URL + endpoint,
          method,
          entity,
          responseType);

      return responseEntity.getBody();
    } catch (HttpClientErrorException e) {
      logger.error("Error calling Shinhan API: {}", e.getResponseBodyAsString());
      throw e;
    } catch (Exception e) {
      logger.error("Unexpected error occurred: {}", e.getMessage());
      throw e;
    }
  }
}