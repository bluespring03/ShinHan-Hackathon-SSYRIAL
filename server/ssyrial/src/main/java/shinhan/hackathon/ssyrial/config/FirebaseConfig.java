package shinhan.hackathon.ssyrial.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;

@Configuration
public class FirebaseConfig {

  private static final Logger logger = LoggerFactory.getLogger(FirebaseConfig.class);
  private static final String FIREBASE_CONFIG_PATH = "ssyrial-firebase-adminsdk.json";

  @Bean
  public FirebaseApp firebaseApp() throws IOException {
    InputStream serviceAccount = loadServiceAccount();
    FirebaseOptions options = buildFirebaseOptions(serviceAccount);

    return initializeFirebaseApp(options);
  }

  private InputStream loadServiceAccount() {
    InputStream serviceAccount = getClass().getClassLoader().getResourceAsStream(FIREBASE_CONFIG_PATH);
    if (serviceAccount == null) {
      throw new IllegalArgumentException("Firebase service account file not found in resources.");
    }
    return serviceAccount;
  }

  private FirebaseOptions buildFirebaseOptions(InputStream serviceAccount) throws IOException {
    return FirebaseOptions.builder()
        .setCredentials(GoogleCredentials.fromStream(serviceAccount))
        .build();
  }

  private FirebaseApp initializeFirebaseApp(FirebaseOptions options) {
    try {
      if (FirebaseApp.getApps().isEmpty()) {
        FirebaseApp.initializeApp(options);
        logger.info("FirebaseApp initialized successfully.");
      }
      return FirebaseApp.getInstance();
    } catch (Exception e) {
      logger.error("Unexpected error during FirebaseApp initialization: {}", e.getMessage());
      throw new RuntimeException("Unexpected error during FirebaseApp initialization", e);
    }
  }
}
