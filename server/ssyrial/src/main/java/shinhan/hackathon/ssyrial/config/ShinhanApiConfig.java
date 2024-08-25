package shinhan.hackathon.ssyrial.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShinhanApiConfig {

  @Value("${SHINHAN_API_KEY}")
  private String apiKey;

  @Bean
  public String apiKey() {
    return apiKey;
  }
}
