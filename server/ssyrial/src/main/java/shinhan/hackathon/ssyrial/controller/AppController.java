package shinhan.hackathon.ssyrial.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import shinhan.hackathon.ssyrial.model.ApiResponse;
import shinhan.hackathon.ssyrial.model.IssuedApiKeyModel;
import shinhan.hackathon.ssyrial.service.AppService;

/**
 * AppController는 /api/app 경로에 대한 REST API 요청을 처리하는 컨트롤러입니다.
 * 
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/app")
public class AppController {
  private final AppService appService;

  /**
   * /getApiKey 엔드포인트로 API 키 발급 요청을 처리하는 메서드입니다.
   * 
   * @param request IssuedApiKeyModel.Request - API 키 발급 요청 데이터
   * @return ResponseEntity<ApiResponse<IssuedApiKeyModel.Response>> - 발급된 API 키
   *         응답
   */
  @PostMapping("/getApiKey")
  public ResponseEntity<ApiResponse<IssuedApiKeyModel.Response>> getApiKey(
      @RequestBody IssuedApiKeyModel.Request request) {
    IssuedApiKeyModel.Response response = appService.getIssuedApiKey(request);
    return ResponseEntity.ok(ApiResponse.success(response));
  }
}
