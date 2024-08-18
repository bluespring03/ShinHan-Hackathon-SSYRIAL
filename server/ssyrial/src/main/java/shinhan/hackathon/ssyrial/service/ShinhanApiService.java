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

@Service
public abstract class ShinhanApiService {

  private static final Logger logger = LoggerFactory.getLogger(ShinhanApiService.class);

  protected final RestTemplate restTemplate;
  protected static final String BASE_URL = "https://finopenapi.ssafy.io/ssafy/api/v1/edu";

  public ShinhanApiService(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

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
