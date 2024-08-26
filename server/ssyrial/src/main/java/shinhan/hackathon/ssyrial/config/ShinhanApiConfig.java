package shinhan.hackathon.ssyrial.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ShinhanApiConfig 클래스는 환경 변수로부터 API 키를 관리하는 설정 클래스입니다.
 */
@Configuration
public class ShinhanApiConfig {

  // 환경 변수에서 SHINHAN_API_KEY 값을 읽어옵니다.
  @Value("${SHINHAN_API_KEY}")
  private String apiKey;

  /**
   * 환경 변수로부터 API 키를 빈으로 등록합니다.
   * 
   * @return String - 발급받은 API 키
   */
  @Bean
  public String apiKey() {
    return apiKey; // 환경 변수로부터 읽어온 API 키 반환
  }
}
