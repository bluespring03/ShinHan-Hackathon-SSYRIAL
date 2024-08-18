package shinhan.hackathon.ssyrial.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * RestTemplateConfig는 RestTemplate을 빈으로 등록하는 설정 클래스입니다.
 * 
 * RestTemplate은 외부 API와의 통신을 위해 사용됩니다.
 */
@Configuration
public class RestTemplateConfig {

  /**
   * RestTemplate 빈을 생성하여 Spring 컨텍스트에 등록합니다.
   * 
   * @return RestTemplate - API 호출을 위한 RestTemplate 객체
   */
  @Bean
  RestTemplate restTemplate() {
    return new RestTemplate();
  }
}