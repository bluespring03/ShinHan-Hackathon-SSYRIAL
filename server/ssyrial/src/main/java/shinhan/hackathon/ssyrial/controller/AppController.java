package shinhan.hackathon.ssyrial.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shinhan.hackathon.ssyrial.model.ApiResponse;
import shinhan.hackathon.ssyrial.model.api.IssuedApiKeyModel;
import shinhan.hackathon.ssyrial.model.api.ReIssuedApiKeyModel;
import shinhan.hackathon.ssyrial.service.AppService;

/**
 * AppController는 /api/app 경로에 대한 REST API 요청을 처리하는 컨트롤러입니다.
 */
@RestController
@RequestMapping("/api/app")
public class AppController {

  private final AppService appService;

  public AppController(AppService appService) {
    this.appService = appService;
  }

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

  /**
   * /getReApiKey 엔드포인트로 API 키 재발급 요청을 처리하는 메서드입니다.
   * 
   * @param request ReIssuedApiKeyModel.Request - API 키 재발급 요청 데이터
   * @return ResponseEntity<ApiResponse<ReIssuedApiKeyModel.Response>> - 재발급된 API
   *         키 응답
   */
  @PostMapping("/getReApiKey")
  public ResponseEntity<ApiResponse<ReIssuedApiKeyModel.Response>> getReApiKey(
      @RequestBody ReIssuedApiKeyModel.Request request) {
    ReIssuedApiKeyModel.Response response = appService.getReIssuedApiKey(request);
    return ResponseEntity.ok(ApiResponse.success(response));
  }
}
